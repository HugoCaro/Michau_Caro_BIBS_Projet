public class ARNnomme extends ARN{
    private String nom;
    private ARN arn;

    public ARNnomme(ARN arn, String nom){
        this.nom=nom;
        this.arn=arn;
    }
    public String returnStruct() { return this.struct; }
    public String returnSeq() { return this.arn.seq; }
    public String returnNom(){
        return this.nom;
    }

    public Boolean compareStruct(ARN b){
        return this.arn.struct.equals(b.struct);
    }
    public Boolean compareSeq(ARN b){
        return this.arn.seq.equals(b.seq) && this.struct.equals(b.struct);
    }

    public Boolean compareStruct(ARNnomme b){
        return this.arn.struct.equals(b.arn.struct);
    }
    public Boolean compareSeq(ARNnomme b){
        return this.arn.seq.equals(b.arn.seq) && this.arn.struct.equals(b.arn.struct);
    }


}
