import java.util.ArrayList;

public class ElementsArbre extends Arbre {
    private String valeur;
    private ElementsArbre precedent;
    private ArrayList<ElementsArbre> suivant;

    public ElementsArbre(){
        this.valeur = "";
        this.precedent = null;
        this.suivant = null;

    }

    public ElementsArbre(String valeur, ElementsArbre precedent, ArrayList<ElementsArbre> suivant){
        this.valeur = valeur;
        this.precedent = precedent;
        this.suivant = suivant;
    }



}
