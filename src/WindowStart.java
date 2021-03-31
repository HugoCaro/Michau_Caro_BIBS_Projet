import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStart {

    private JFrame frameStart = new JFrame ("Saisie ARN");

    private JPanel panTitre = new JPanel();
    private JLabel labvide = new JLabel("");
    private JLabel labseq1 = new JLabel("ARN 1");
    private JLabel labseq2 = new JLabel("ARN 2");

    private JPanel panARN = new JPanel();
    private JLabel labARN= new JLabel("Séquence : ");
    public JTextArea txtARN= new JTextArea("Entrer la 1ère \nséquence ARN");
    public JTextArea txtARN2= new JTextArea("Entrer la 2ème \nséquence ARN");

    private JPanel panStrc= new JPanel();
    private JLabel labStrc= new JLabel("Strcuture : ");
    public JTextArea txtStrc= new JTextArea("Entrer la 1ère \nstructure ARN");
    public JTextArea txtStrc2= new JTextArea("Entrer la 2ème \nstructure ARN");

    private JButton buttonAdd = new JButton("Lancer l'analyse");

    public WindowStart() {

        this.labseq1.setHorizontalAlignment(SwingConstants.CENTER);
        this.labseq2.setHorizontalAlignment(SwingConstants.CENTER);
        labseq1.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        labseq2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.panTitre.setLayout(new GridLayout(1,3));
        this.panTitre.add(this.labvide);
        this.panTitre.add(this.labseq1);
        this.panTitre.add(this.labseq2);

        txtARN = this.txtARN;
        txtARN2 = this.txtARN2;
        this.labARN.setHorizontalAlignment(SwingConstants.CENTER);
        this.panARN.setLayout(new GridLayout(1,3));
        this.panARN.add(this.labARN);
        this.panARN.add(txtARN);
        this.panARN.add(txtARN2);
        panARN.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        txtStrc = this.txtStrc;
        txtStrc2 = this.txtStrc2;
        this.labStrc.setHorizontalAlignment(SwingConstants.CENTER);
        this.panStrc.setLayout(new GridLayout(1,2));
        this.panStrc.add(this.labStrc);
        this.panStrc.add(txtStrc);
        this.panStrc.add(txtStrc2);
        panStrc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String seq = txtARN.getText().toUpperCase() ;
                String strc = txtStrc.getText().toUpperCase() ;

                System.out.println(seq);
                System.out.println(strc);
                ARN a = new ARN(seq,strc);
            }
        });

        this.frameStart.setLayout(new GridLayout(4,1));
        this.frameStart.add(this.panTitre);
        this.frameStart.add(this.panARN);
        this.frameStart.add(this.panStrc);
        this.frameStart.add(this.buttonAdd);

        this.frameStart.setSize(400,294);
        this.frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameStart.setVisible(true);
    }
}