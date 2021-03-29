import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStart {

    private JFrame frameStart = new JFrame ("Saisie ARN");

    private JButton buttonAdd = new JButton("Ajout de la séquence");

    private JPanel panNom = new JPanel();
    public JTextArea txtNom= new JTextArea("Entrer un identifiant de \nla séquence ARN");
    private JLabel labNom= new JLabel("ID : ");

    private JPanel panARN = new JPanel();
    public JTextArea txtARN= new JTextArea("Entrer une séquence ARN");
    private JLabel labARN= new JLabel("Séquence : ");

    private JPanel panStrc= new JPanel();
    public JTextArea txtStrc= new JTextArea("Entrer une structure ARN");
    private JLabel labStrc= new JLabel("Strcuture : ");

    public WindowStart() {

        txtNom = this.txtNom;
        this.labNom.setHorizontalAlignment(SwingConstants.CENTER);
        this.panNom.setLayout(new GridLayout(1,2));
        this.panNom.add(this.labNom);
        this.panNom.add(txtNom,1);
        panNom.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        txtARN = this.txtARN;
        this.labARN.setHorizontalAlignment(SwingConstants.CENTER);
        this.panARN.setLayout(new GridLayout(1,2));
        this.panARN.add(this.labARN);
        this.panARN.add(txtARN,1);
        panARN.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        txtStrc = this.txtStrc;
        this.labStrc.setHorizontalAlignment(SwingConstants.CENTER);
        this.panStrc.setLayout(new GridLayout(1,2));
        this.panStrc.add(this.labStrc);
        this.panStrc.add(txtStrc,1);
        panStrc.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nomARN = txtNom.getText();
                String seq = txtARN.getText().toUpperCase() ;
                String strc = txtStrc.getText().toUpperCase() ;
                System.out.println(nomARN);
                System.out.println(seq);
                System.out.println(strc);
                ARN a = new ARN(seq,strc);
                ARNnomme test = new ARNnomme(a,nomARN);
                System.out.println(test.returnStruct());
                System.out.println(test.returnSeq());
                System.out.println(test.returnNom());
            }
        });

        this.frameStart.setLayout(new GridLayout(4,1));
        this.frameStart.add(this.panNom);
        this.frameStart.add(this.panARN);
        this.frameStart.add(this.panStrc);
        this.frameStart.add(this.buttonAdd);
        this.frameStart.setSize(400,294);
        this.frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameStart.setVisible(true);
    }

}
