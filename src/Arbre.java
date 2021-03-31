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

    private String getComposant(int i) {
        return this.tree.get(i).composant;
    }

    private String getValeur(int i) {
        return this.tree.get(i).valeur;
    }

    private int size() {
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





    public static void main(String[] args) {
        String test = "Test";
        ARN c = new ARN("AUGGGC","--(())");
        //String [] parts = test.split( "" );
        Arbre arbreTest = creationArbre(c);
        /*for(int i = 0; i < arbreTest.size(); i++){
            System.out.println("composant : " + arbreTest.getComposant(i));
            System.out.println("valeur :" + arbreTest.getValeur(i));
        }*/
        /*ARN b = creationARN(arbreTest);
        System.out.println(b.seq);
        System.out.println(b.struct);*/
    }



}
