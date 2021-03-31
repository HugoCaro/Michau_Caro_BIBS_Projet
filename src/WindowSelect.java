import javax.swing.*;
import java.awt.*;

public class WindowSelect {

    public static ListeARNnomme listetotale;

    private JFrame frameSelect = new JFrame ("ARN saisies");
    private JPanel panelARNnom= new JPanel();
    private JLabel labARNnom = new JLabel("Liste des ARN saisies");
    public JLabel arn1 = new JLabel("   /   ");
    public JLabel arn2 = new JLabel("   /   ");
    public JLabel arn3 = new JLabel("   /   ");
    public JLabel arn4 = new JLabel("   /   ");
    public JLabel arn5 = new JLabel("   /   ");

    private JPanel select1 = new JPanel();
    private ButtonGroup groupSelect1 = new ButtonGroup();
    private JLabel labselect1 = new JLabel("1ère séquence");
    private JCheckBox boxarn11 = new JCheckBox();
    private JCheckBox boxarn12 = new JCheckBox();
    private JCheckBox boxarn13 = new JCheckBox();
    private JCheckBox boxarn14 = new JCheckBox();
    private JCheckBox boxarn15 = new JCheckBox();

    private JPanel select2 = new JPanel();
    private ButtonGroup groupSelect2 = new ButtonGroup();
    private JLabel labselect2 = new JLabel("2ème séquence");
    private JCheckBox boxarn21 = new JCheckBox();
    private JCheckBox boxarn22 = new JCheckBox();
    private JCheckBox boxarn23 = new JCheckBox();
    private JCheckBox boxarn24 = new JCheckBox();
    private JCheckBox boxarn25 = new JCheckBox();

    public WindowSelect(){

        ListeARNnomme listetotale=new ListeARNnomme(5);

        this.arn1.setHorizontalAlignment(SwingConstants.CENTER);
        this.arn2.setHorizontalAlignment(SwingConstants.CENTER);
        this.arn3.setHorizontalAlignment(SwingConstants.CENTER);
        this.arn4.setHorizontalAlignment(SwingConstants.CENTER);
        this.arn5.setHorizontalAlignment(SwingConstants.CENTER);
        this.panelARNnom.setLayout(new GridLayout(6,1));
        this.panelARNnom.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.panelARNnom.add(labARNnom);
        this.panelARNnom.add(arn1);
        this.panelARNnom.add(arn2);
        this.panelARNnom.add(arn3);
        this.panelARNnom.add(arn4);
        this.panelARNnom.add(arn5);

        this.select1.setLayout(new GridLayout(6,1));
        this.select2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.labselect1.setHorizontalAlignment(SwingConstants.CENTER);
        this.select1.add(labselect1);
        this.groupSelect1.add(this.boxarn11);
        this.groupSelect1.add(this.boxarn12);
        this.groupSelect1.add(this.boxarn13);
        this.groupSelect1.add(this.boxarn14);
        this.groupSelect1.add(this.boxarn15);
        this.boxarn11.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn12.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn13.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn14.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn15.setHorizontalAlignment(SwingConstants.CENTER);
        this.select1.add(boxarn11);
        this.select1.add(boxarn12);
        this.select1.add(boxarn13);
        this.select1.add(boxarn14);
        this.select1.add(boxarn15);

        this.select2.setLayout(new GridLayout(6,1));
        this.select2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.labselect2.setHorizontalAlignment(SwingConstants.CENTER);
        this.select2.add(labselect2);
        this.groupSelect2.add(this.boxarn21);
        this.groupSelect2.add(this.boxarn22);
        this.groupSelect2.add(this.boxarn23);
        this.groupSelect2.add(this.boxarn24);
        this.groupSelect2.add(this.boxarn25);
        this.boxarn21.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn22.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn23.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn24.setHorizontalAlignment(SwingConstants.CENTER);
        this.boxarn25.setHorizontalAlignment(SwingConstants.CENTER);
        this.select2.add(boxarn21);
        this.select2.add(boxarn22);
        this.select2.add(boxarn23);
        this.select2.add(boxarn24);
        this.select2.add(boxarn25);

        this.frameSelect.add(panelARNnom,"West");
        this.frameSelect.add(select1,"Center");
        this.frameSelect.add(select2,"East");
        this.frameSelect.setSize(400,300);
        this.frameSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameSelect.setVisible(true);
    }

    public void updateLabel(){
        if (listetotale.emplacement==1) {
            this.arn1.setText(listetotale.listeARN.get(0).returnNom());
        }
        if (listetotale.emplacement==1) {
            this.arn2.setText(listetotale.listeARN.get(1).returnNom());
        }
        if (listetotale.emplacement==1) {
            this.arn3.setText(listetotale.listeARN.get(2).returnNom());
        }
        if (listetotale.emplacement==1) {
            this.arn4.setText(listetotale.listeARN.get(3).returnNom());
        }
        if (listetotale.emplacement==1){
            this.arn5.setText(listetotale.listeARN.get(4).returnNom());
        }
    }

}
