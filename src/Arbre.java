import java.util.ArrayList;

public class Arbre extends ARN {
    private ArrayList<ElementsArbre> Tree;


    public Arbre(){
        this.Tree = new ArrayList<ElementsArbre>();
        this.Tree.add(new ElementsArbre());
    }

    public Arbre(ArrayList<ElementsArbre> Tree){
        this.Tree = Tree;
    }

    public void creationArbre(ARN arn){
        Arbre NewTree = new Arbre();
        String struct = arn.returnStruct();
        String [] structure = struct.split("");
        for(int i = 0; i < struct.length(); i++){
            
        }
    }

    public static void main(String[] args) {
        String test = "Test";
        String [] parts = test.split( "" );
        System.out.println(parts[0]);
    }
}
