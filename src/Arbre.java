import java.util.ArrayList;

public class Arbre extends ARN {
    private ElementsArbre tree;


    public Arbre(){
        this.tree = new ElementsArbre();
    }

    public Arbre(ElementsArbre tree){
        this.tree = tree;
    }

    public static Arbre creationArbre(ARN arn){
        Arbre newTree = new Arbre();
        ElementsArbre pere = new ElementsArbre();
        String struct = arn.returnStruct();
        String [] structure = struct.split("");
        String seq = arn.returnSeq();
        String [] sequence = seq.split("");
        for(int i = 0; i < struct.length(); i++){
            if(structure[i] == "("){
                ArrayList<ElementsArbre> suivant = new ArrayList<ElementsArbre>();
                ElementsArbre elem = new ElementsArbre("", pere, suivant);
                pere.suivant.add(elem);
                pere = elem;
                String value = sequence[i];
                ElementsArbre fils = new ElementsArbre(value, pere, null);
                elem.suivant.add(fils);
            } else if(structure[i] == ")"){
                String value = sequence[i];
                ElementsArbre fils = new ElementsArbre(value, pere, null);
                pere.suivant.add(fils);
                pere = pere.precedent;
            } else {
                String value = sequence[i];
                ElementsArbre fils = new ElementsArbre(value, pere, null);
                pere.suivant.add(fils);
            }
        }
        newTree = pere;
        return newTree;
    }




    public static void main(String[] args) {
        String test = "Test";
        ARN c = new ARN("AUGGGC","--(())");
        //String [] parts = test.split( "" );
        Arbre arbreTest = creationArbre(c);
        System.out.println(arbreTest);
    }
}
