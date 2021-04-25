import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WindowStart {

    public ARN a = new ARN();
    public ARN b = new ARN();

    private JRadioButton buttonManuel= new JRadioButton();
    private JButton open1 = new JButton("Selectionner le fichier 1"); //nouveau bouton open1
    private JButton open2 = new JButton("Selectionner le fichier 2"); //nouveau bouton open2
    private JRadioButton buttonFichier= new JRadioButton();
    private ButtonGroup selecTraitement = new ButtonGroup();

    private JFrame frameStart = new JFrame ("Saisie ARN");

    private JPanel panManuel = new JPanel();

    private JLabel labManuel = new JLabel("Saisie Manuelle");

    private JPanel panARN = new JPanel();
    private JPanel panARN1 = new JPanel();
    private JLabel labvide = new JLabel("");
    private JLabel labseq1 = new JLabel("ARN 1");
    private JLabel labseq2 = new JLabel("ARN 2");

    private JPanel panARN2 = new JPanel();
    private JLabel labARN= new JLabel("Séquence : ");
    public JTextArea txtARN= new JTextArea("Entrer la 1ère \nséquence ARN");
    public JTextArea txtARN2= new JTextArea("Entrer la 2ème \nséquence ARN");

    private JPanel panARN3= new JPanel();
    private JLabel labStrc= new JLabel("Structure : ");
    public JTextArea txtStrc= new JTextArea("Entrer la 1ère \nstructure ARN");
    public JTextArea txtStrc2= new JTextArea("Entrer la 2ème \nstructure ARN");

    private JPanel panFichier = new JPanel();

    private JPanel panfile = new JPanel();
    private JLabel labfile= new JLabel("Sélection de fichier");
    private JPanel panfile2 = new JPanel();
    //public JTextField txtpath1= new JTextField("saisir le path de l'arn1");
    public JTextField txtpath1= new JTextField("RF00004.stockholm.txt");
    //public JTextField txtpath2= new JTextField("saisir le path de l'arn2");
    public JTextField txtpath2= new JTextField("RF00004.stockholm.txt");


    private JButton buttonAdd = new JButton("Lancer l'analyse");


    public WindowStart() throws IOException {

        this.selecTraitement.add(this.buttonFichier);
        this.selecTraitement.add(this.buttonManuel);
        buttonManuel.setSelected(true);
        buttonManuel.setActionCommand("manuel");
        buttonFichier.setActionCommand("fichier");

        //Saisi manuel des sequences
        this.labManuel.setHorizontalAlignment(SwingConstants.CENTER);
        this.labseq1.setHorizontalAlignment(SwingConstants.CENTER);
        this.labseq2.setHorizontalAlignment(SwingConstants.CENTER);
        labseq1.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        labseq2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
        this.panARN1.setLayout(new GridLayout(1,3));
        this.panARN1.add(this.labvide);
        this.panARN1.add(this.labseq1);
        this.panARN1.add(this.labseq2);
        this.panARN1.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.labARN.setHorizontalAlignment(SwingConstants.CENTER);
        this.panARN2.setLayout(new GridLayout(1,3));
        this.panARN2.add(this.labARN);
        this.panARN2.add(this.txtARN);
        this.panARN2.add(this.txtARN2);
        this.panARN2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.labStrc.setHorizontalAlignment(SwingConstants.CENTER);
        this.panARN3.setLayout(new GridLayout(1,2));
        this.panARN3.add(this.labStrc);
        this.panARN3.add(this.txtStrc);
        this.panARN3.add(this.txtStrc2);
        this.panARN3.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.panARN.setLayout(new GridLayout(4,1));
        this.panARN.add(this.labManuel);
        this.panARN.add(this.panARN1);
        this.panARN.add(this.panARN2);
        this.panARN.add(this.panARN3);

        this.panManuel.add(this.panARN, "CENTER");
        this.panManuel.add(this.buttonManuel,"EAST");

        // Selection de fichier
        this.labfile.setHorizontalAlignment(SwingConstants.CENTER);

        this.panfile2.setLayout(new GridLayout(1,2));
        this.panfile2.add(this.txtpath1);
        this.panfile2.add(this.txtpath2);
        this.panfile2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.panfile.setLayout(new GridLayout(2,1));
        this.panfile.add(this.labfile);
        this.panfile.add(this.panfile2);

        this.panFichier.add(this.panfile, "CENTER");
        this.panFichier.add(this.buttonFichier,"EAST");


        /////
        // Sélection des fichiers 2
        this.labfile.setHorizontalAlignment(SwingConstants.CENTER);

        this.panfile2.setLayout(new GridLayout(1,2));
        this.panfile2.add(this.txtpath1);
        this.panfile2.add(this.txtpath2);
        this.panfile2.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));

        this.panfile.setLayout(new GridLayout(2,1));
        this.panfile.add(this.labfile);
        this.panfile.add(this.panfile2);

        this.panFichier.add(this.open1, "CENTER");
        this.panFichier.add(this.open2, "CENTER");
        this.panFichier.add(this.buttonFichier.createToolTip(),"EAST");

        this.open1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent actionEvent) {
                                            JFileChooser fileChooser = new JFileChooser(new File("."));
                                            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                                File selectedFile = fileChooser.getSelectedFile();
                                                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                                                String selectionne = selectedFile.getName();
                                                txtpath1.setText(selectionne);
                                                System.out.println("selection : " + selectionne);
                                            }
                                        }
                                    });

        this.open2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser(new File("."));
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                    String selectionne = selectedFile.getName();
                    txtpath2.setText(selectionne);
                    System.out.println("selection : " + selectionne);
                }
            }
        });
        /////


        this.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String choice = selecTraitement.getSelection().getActionCommand();

                if (choice.equals("fichier")) {
                    try {
                        a = a.lireFichier(txtpath1.getText());
                        b = b.lireFichier(txtpath2.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else{

                String seq = txtARN.getText().toUpperCase();
                String strc = txtStrc.getText().toUpperCase();
                String seq2 = txtARN2.getText().toUpperCase();
                String strc2 = txtStrc2.getText().toUpperCase();
                a = new ARN(seq, strc);
                b = new ARN(seq2, strc2);
                }

                Arbre arbreComp = Arbre.comparateurArbre(a, b);
                System.out.println(a.seq);
                System.out.println(a.returnStruct());
                System.out.println(b.seq);
                System.out.println(b.returnStruct());
                System.out.println(arbreComp);
                ARN arnComp = Arbre.creationARN(arbreComp);
                System.out.println("composant : " + arnComp.struct);
                System.out.println("valeur :" + arnComp.seq);


                JFrame fenetre = new JFrame();

                fenetre.setTitle("Résultat comparaison");
                //Définit sa taille : 400 pixels de large et 100 pixels de haut
                fenetre.setSize(400, 100);
                //Nous demandons maintenant à notre objet de se positionner au centre
                fenetre.setLocationRelativeTo(null);
                //Termine le processus lorsqu'on clique sur la croix rouge
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetre.setLayout(new FlowLayout ());
                TextArea textArea = new TextArea("Composant : " + arnComp.struct, 5, 40);
                TextArea textArea1 = new TextArea("Valeur : " + arnComp.seq, 5, 40);
                fenetre.add(textArea);
                fenetre.add(textArea1);
                //Et enfin, la rendre visible
                fenetre.show();
                fenetre.pack();
            }
        });

        //Fenetre final
        this.frameStart.add(this.panManuel,"North");
        this.frameStart.add(this.panFichier,"Center");
        this.frameStart.add(this.buttonAdd,"South");

        this.frameStart.setSize(400,300);
        this.frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameStart.setVisible(true);
    }
}