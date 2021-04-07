import java.util.ArrayList;

public class Arbre extends ARN {
    private ArrayList<ElementsArbre> tree;


    public Arbre(){
        this.tree = new ArrayList<ElementsArbre>();
    }

    public Arbre(ArrayList<ElementsArbre> tree){
        this.tree = tree;
    }

    private void add(ElementsArbre elem) {
        this.tree.add(elem);
    }

    private ElementsArbre get(int i) {
        return this.tree.get(i);
    }

    private void add(Arbre a) {
        for (int i = 0; i < a.size(); i++) {
            this.tree.add(a.get(i));
        }
    }



    public String getComposant(int i) {
        return this.tree.get(i).composant;
    }

    public String getValeur(int i) {
        return this.tree.get(i).valeur;
    }

    public int size() {
        return this.tree.size();
    }

    public static Arbre creationArbre(ARN arn){
        Arbre newTree = new Arbre();
        String struct = arn.returnStruct();
        String [] structure = struct.split("");
        String seq = arn.returnSeq();
        String [] sequence = seq.split("");
        for(int i = 0; i < struct.length(); i++){
            System.out.println(structure[i].toString());
            System.out.println("(");
            if(structure[i].equals("(")){
                String value = sequence[i];
                ElementsArbre element = new ElementsArbre(value, "DN");
                newTree.add(element);
            } else if(structure[i].equals(")")){
                String value = sequence[i];
                ElementsArbre element = new ElementsArbre(value, "FN");
                newTree.add(element);
            } else {
                String value = sequence[i];
                ElementsArbre element = new ElementsArbre(value, "F");
                newTree.add(element);
            }
        }
        return newTree;
    }

    public static ARN creationARN(Arbre a){
        String structure = "";
        String sequence = "";
        for(int i = 0; i < a.size(); i++){
            if(a.getComposant(i).equals("DN")){
                structure += "(";
            } else if(a.getComposant(i).equals("FN")){
                structure += ")";
            } else {
                structure += "-";
            }
            sequence += a.getValeur(i);

        }
        ARN arn = new ARN(sequence, structure);
        return arn;
    }

    public static ArrayList<Arbre> creationSousArbres (Arbre a, String struct, String seq){
        ArrayList<Arbre> listeSousArbresA = new ArrayList<Arbre>();
        listeSousArbresA.add(a);
        int taille = seq.length();
        String[] structure = struct.split("");
        String[] sequence = seq.split("");
        int cpt = 0;
        //ArrayList<Integer> listeCptB = new ArrayList<Integer>();
        Arbre tree = new Arbre();
        for (int i = 0; i < taille; i++) {
            if (structure[i].equals("-")) {
                if (cpt == 0) {
                    ElementsArbre element = new ElementsArbre(sequence[i], "F");
                    tree.add(element);
                    listeSousArbresA.add(tree);
                    tree = new Arbre();
                } else {
                    ElementsArbre element = new ElementsArbre(sequence[i], "F");
                    tree.add(element);
                }
            } else if (structure[i].equals("(")) {
                if (cpt == 0) {
                    ElementsArbre element = new ElementsArbre(sequence[i], "DN");
                    tree.add(element);
                    cpt++;
                } else {
                    listeSousArbresA.add(tree);
                    tree = new Arbre();
                    ElementsArbre element = new ElementsArbre(sequence[i], "DN");
                    tree.add(element);
                    cpt++;
                }
            } else {
                if (cpt == 1) {
                    ElementsArbre element = new ElementsArbre(sequence[i], "FN");
                    tree.add(element);
                    listeSousArbresA.add(tree);
                    tree = new Arbre();
                    cpt = 0;
                } else {
                    ElementsArbre element = new ElementsArbre(sequence[i], "FN");
                    tree.add(element);
                    listeSousArbresA.add(tree);
                    ArrayList<Arbre> listeSousArbres = new ArrayList<Arbre>();
                    for (int x = 0; x < listeSousArbresA.size()-cpt; x++) {
                        listeSousArbres.add(listeSousArbresA.get(x));
                    }
                    listeSousArbres.add(listeSousArbresA.get(listeSousArbres.size() - 1));
                    for (int j = listeSousArbresA.size()-cpt; j < listeSousArbresA.size()-1; j++){
                        if (j == listeSousArbresA.size() - 1){
                            Arbre treeTemp = listeSousArbresA.get(listeSousArbresA.size() - 2);
                            treeTemp.add(tree);
                            listeSousArbres.add(treeTemp);
                        } else {
                            listeSousArbres.add(listeSousArbresA.get(j));
                        }
                    }
                    tree = new Arbre();
                    cpt--;
                }
            }
        }
        return listeSousArbresA;
    }

    public static Arbre comparateurArbre (ARN a, ARN b) {
        Arbre arbreA = creationArbre(a);
        Arbre arbreB = creationArbre(b);
        ArrayList<Arbre> listeSousArbresA = creationSousArbres(arbreA, a.struct, a.seq);
        ArrayList<Arbre> listeSousArbresB = creationSousArbres(arbreB, b.struct, b.seq);
        Arbre sousArbre = new Arbre();
        for (int i = 0; i < listeSousArbresA.size(); i++){
            Arbre sousArbreA = listeSousArbresA.get(i);
            for (int j = 0; j < listeSousArbresB.size(); j++){
                Arbre sousArbreB = listeSousArbresB.get(j);
                if (sousArbreA == sousArbreB && sousArbreA.size() >= sousArbre.size()){
                    sousArbre = sousArbreA;
                }
            }
        }
        return sousArbre;
    }





    public static void main(String[] args) {
        String test = "Test";
        ARN c = new ARN("AUGGGC","--(())");
        //String [] parts = test.split( "" );
        Arbre arbreTest = creationArbre(c);
        for(int i = 0; i < arbreTest.size(); i++){
            System.out.println("composant : " + arbreTest.getComposant(i));
            System.out.println("valeur :" + arbreTest.getValeur(i));
        }
        ARN b = creationARN(arbreTest);
        System.out.println(b.seq);
        System.out.println(b.struct);
    }



}