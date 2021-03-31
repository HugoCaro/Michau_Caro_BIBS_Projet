import java.util.ArrayList;

public class ListeARNnomme {
    ArrayList<ARNnomme> listeARN;
    int taille;         //taille de la liste
    int taillemax;
    int emplacement;    //emplacement auquel sera ajouté le prochain ARN

    public ListeARNnomme(int taillemax){
        this.listeARN = new ArrayList<>();
        this.emplacement = 0;
        this.taillemax = taillemax;
    }

    public void add(ARNnomme arnN){
        this.listeARN.add(this.emplacement,arnN);
        this.emplacement+=1;
        if (this.emplacement == this.taillemax) {
            this.emplacement = 0;
        }
    }
}

