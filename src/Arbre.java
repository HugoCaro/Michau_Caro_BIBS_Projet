import java.util.ArrayList;

public class Arbre extends ARN {
    private ArrayList<ElementsArbre> tree;


    public Arbre(){
        this.tree = new ArrayList<ElementsArbre>();
    }

    public Arbre(ArrayList<ElementsArbre> Tree){
        this.tree = Tree;
    }

    private void add(ElementsArbre ele) {
        this.tree.add(ele);
    }

    public void creationArbre(ARN arn){
        Arbre newTree = new Arbre();
        ElementsArbre pere = new ElementsArbre();
        newTree.add(pere);
        String struct = arn.returnStruct();
        String [] structure = struct.split("");
        String seq = arn.returnSeq();
        String [] sequence = seq.split("");
        for(int i = 0; i < struct.length(); i++){
            if(structure[i] == "("){
                ArrayList<ElementsArbre> suivant = new ArrayList<ElementsArbre>();
                ElementsArbre elem = new ElementsArbre("", pere, suivant);
                pere = elem;
                String value = sequence[i];
                ElementsArbre fils = new ElementsArbre(value, pere, null);
                elem.suivant.add(fils);
            }// else if()
        }
    }




    public static void main(String[] args) {
        String test = "Test";
        String [] parts = test.split( "" );
        System.out.println(parts[0]);
    }
}
