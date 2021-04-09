import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ARN {
    protected String seq;
    private String struct;

    public ARN(){
        this.seq="";
        this.struct="";
    }
    public ARN( String seq, String struct) {
        if (seq.length() == struct.length()) {
            this.seq = seq;
            this.struct = struct;
        }
        else{
            System.out.println("Séquence et structure de tailles différentes");
        }
    }

    public String returnStruct(){
        return this.struct;
    }

    public String returnSeq(){
        return this.seq;
    }


    public static String enlevePointEtMetEnMajuscule(String seqFausse){
        String res = seqFausse.replace(".", "");
        return res.toUpperCase();
    }

    public static String transformeEnBonneStructure(String structFausse){
        String res = structFausse.replace(".", "");
        res = res.replace(":", "-");
        res = res.replace(",", "-");
        res = res.replace("<", "(");
        res = res.replace(">", ")");
        res = res.replace("[", "(");
        res = res.replace("]", ")");
        res = res.replace("{", "(");
        res = res.replace("}", ")");
        res = res.replace("_", "-");
        return res;
    }

    public String bristlecone(ARN b){ //plus grand arbre commun
        int debut=0;
        int fin = 0;
        int taillemax=0;
        String c="";
        for(int i = 0; i < b.struct.length() ; i++) {
            for (int j = i; j < b.struct.length()+1; j++) {
                c = b.struct.substring(i, j);
                if (((j-i) > taillemax) && this.struct.indexOf(c) != -1) {
                    taillemax = j-i;
                    debut = i;
                    fin = j;
                }
            }
        }
        System.out.println(debut);
        System.out.println(fin-1);
        return b.struct.substring(debut,fin);
    }

    public Boolean compareStruct(ARN b){
        return this.struct.equals(b.struct);
    }
    public Boolean compareSeq(ARN b){
        return this.seq.equals(b.seq) && this.struct.equals(b.struct);
    }

    //méthode trouvée sur internet
    public ARN lireFichier(String nomFichier) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(nomFichier));
        ArrayList<String> tableauLines = new ArrayList<String>();
        String line;
        int cpt = 0;
        while ((line = in.readLine()) != null)
        {
            line = line.replace(" ", "");
            tableauLines.add(line);
            cpt++;
            // Afficher le contenu du fichier
            System.out.println (line);
        }
        in.close();
        String struct = tableauLines.get(cpt-3).replace("#=GCSS_cons", "");
        struct = transformeEnBonneStructure(struct);
        String seq = tableauLines.get(cpt-2).replace("#=GCRF", "");
        seq = enlevePointEtMetEnMajuscule(seq);
        return new ARN(seq, struct);
    }

    public static void main(String[] args) throws IOException {
        /*String test1 = "GgagauaU.A.GCucAgU...GGU...AgaGCg.u.cgGaC.UuaaAAuCcg.aag........................g...cgcg.GGU.UCg.Aa..UCCcg.c.uaucucC.a";
        String test2 = enlevePointEtMetEnMajuscule(test1);
        System.out.println(test2);
        String test3 = "(((((((,.,.<<<<___...___..._>>>>,.<.<<<<_.______>>>>.>,,........................,...,<<<.<<_.___.__.._>>>>.>.))))))).:";
        String test4 = transformeEnBonneStructure(test3);
        System.out.println(test4);
        ARN test = lireFichier("RF00005.stockholm.txt");
        System.out.println("Structure : " + test.struct + ", taille : " + test.struct.length());
        System.out.println("Sequence : " + test.seq + ", taille : " + test.seq.length());
        ARN a = new ARN("AUGGGC","--((--");
        ARN b = new ARN("AUGGGC","--((--");
        ARN c = new ARN("AUGGGC","--(())");
        ARN d = new ARN("AUOOGC","--((--");
        ARN e = new ARN("AUPMLJ","--(+--");
        System.out.println(a.compareStruct(b));
        System.out.println(a.compareStruct(c));
        System.out.println(a.compareStruct(d));
        System.out.println(a.compareStruct(e));*/

        WindowStart test = new WindowStart();

       /* ARN a= new ARN ("AAAAAAAAAA","----(-----");
        ARN b= new ARN ("AAAAAAAA","(--(----");
        System.out.println(a.bristlecone(b));
        System.out.println(b.bristlecone(a));*/

    }

}
