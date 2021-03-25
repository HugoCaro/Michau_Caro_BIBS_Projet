public class ARN {
    private String seq;
    private String struct;

    public ARN(){
        this.seq="";
        this.struct="";
    }
    public ARN( String seq, String struct){
        this.seq=seq;
        this.struct=struct;
    }

    public Boolean compareStruct(ARN b){
        return this.struct.equals(b.struct);
    }
    public Boolean compareSeq(ARN b){
        return this.seq.equals(b.seq) && this.struct.equals(b.struct);
    }
}
