public class ARN {
    private String seq;
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
            System.out.println("gros nul");
        }
    }

    public Boolean compareStruct(ARN b){
        return this.struct.equals(b.struct);
    }
    public Boolean compareSeq(ARN b){
        return this.seq.equals(b.seq) && this.struct.equals(b.struct);
    }

    public static void main(String[] args) {
        ARN a = new ARN("AUGGGC","--((--");
        ARN b = new ARN("AUGGGC","--((--");
        ARN c = new ARN("AUGGGC","--(())");
        ARN d = new ARN("AUOOGC","--((--");
        ARN e = new ARN("AUPMLJ","--(+--");
        System.out.println(a.compareStruct(b));
        System.out.println(a.compareStruct(c));
        System.out.println(a.compareStruct(d));
        System.out.println(a.compareStruct(e));

        WindowStart test = new WindowStart();
    }
}
