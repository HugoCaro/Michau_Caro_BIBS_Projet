import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ouvrir extends JFrame implements ActionListener {

    JButton open = new JButton("Selectionner un fichier"); //nouveau bouton open

    public Ouvrir()
    {
        super("Explorateur de fichier"); //titre
        setSize(450,100); //taille
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fermeture
        open.addActionListener(this);//ajout d'un actionlistener
        JPanel pane = new JPanel();
        BorderLayout bord = new BorderLayout();
        pane.setLayout(bord);
        pane.add("Center", open);
        setContentPane(pane);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
        chooser.setApproveButtonText("Choix du fichier..."); //intitulé du bouton
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String Firm = chooser.getSelectedFile().getAbsolutePath();
            this.setVisible(false);
            System.out.println(Firm);/*
            try {
                ARN.lireFichier(Firm);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }
}
