import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStart {

    private JFrame frameStart = new JFrame ("Saisi ARN");
    private JButton buttonAdd = new JButton("Ajout de la séquence");
    private JPanel panARN = new JPanel();
    private JTextArea txtARN= new JTextArea("Entrer une \n\tséquence ARN");;
    private JLabel labARN= new JLabel("Séquence : ");
    private JPanel panStrc= new JPanel();
    private JTextArea txtStrc= new JTextArea("Entrer une \n\tstructure ARN");;
    private JLabel labStrc= new JLabel("Strcuture : ");

    public WindowStart() {

        this.panARN.setLayout(new GridLayout(1,2));
        this.panARN.add(this.labARN);
        this.panARN.add(this.txtARN);

        this.panStrc.setLayout(new GridLayout(1,2));
        this.panStrc.add(this.labStrc);
        this.panStrc.add(this.txtStrc,1);

        this.frameStart.setLayout(new GridLayout(3,1));
        this.frameStart.add(this.panARN);
        this.frameStart.add(this.panStrc,1);
        this.frameStart.setSize(400,300);
        this.frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameStart.setVisible(true);
    }

}
