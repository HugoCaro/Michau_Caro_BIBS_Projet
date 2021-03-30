import java.util.ArrayList;

public class ElementsArbre extends Arbre {
    public String valeur;
    public String composant; //DN pour début noeud FN pour fin noeud et F pour Feuille

    public ElementsArbre(){
        this.valeur = "";
        this.composant = "";

    }

    public ElementsArbre(String valeur, String composant){
        this.valeur = valeur;
        this.composant = composant;
    }




}
