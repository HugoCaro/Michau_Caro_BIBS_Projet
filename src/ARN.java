public class ARN {
    protected String seq;
    protected String struct;

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

    public void test(){
        System.out.println("test");
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

    public Boolean compareStruct(ARN b){
        return this.struct.equals(b.struct);
    }
    public Boolean compareSeq(ARN b){
        return this.seq.equals(b.seq) && this.struct.equals(b.struct);
    }
    public static void main(String[] args) {
        String test1 = "GgagauaU.A.GCucAgU...GGU...AgaGCg.u.cgGaC.UuaaAAuCcg.aag........................g...cgcg.GGU.UCg.Aa..UCCcg.c.uaucucC.a";
        String test2 = enlevePointEtMetEnMajuscule(test1);
        System.out.println(test2);
        String test3 = "(((((((,.,.<<<<___...___..._>>>>,.<.<<<<_.______>>>>.>,,........................,...,<<<.<<_.___.__.._>>>>.>.))))))).:";
        String test4 = transformeEnBonneStructure(test3);
        System.out.println(test4);
        /*ARN a = new ARN("AUGGGC","--((--");
        ARN b = new ARN("AUGGGC","--((--");
        ARN c = new ARN("AUGGGC","--(())");
        ARN d = new ARN("AUOOGC","--((--");
        ARN e = new ARN("AUPMLJ","--(+--");
        System.out.println(a.compareStruct(b));
        System.out.println(a.compareStruct(c));
        System.out.println(a.compareStruct(d));
        System.out.println(a.compareStruct(e));

        WindowStart test = new WindowStart();*/

    }

}
