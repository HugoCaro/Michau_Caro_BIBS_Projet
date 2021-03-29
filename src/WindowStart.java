import javax.swing.*;

public class WindowStart {

    public static void main(String argv[]) {

        JFrame f = new JFrame("ma fenetre");
        f.setSize(300, 300);
        JPanel pannel = new JPanel();

        JTextArea  textArea1 = new JTextArea ("Entrer une séquence ARN");
        textArea1.setSize(200, 100);
        JTextArea  textArea2 = new JTextArea ("Entrer une structure ARN");

        pannel.add(textArea1);
        pannel.add(textArea2);
        f.getContentPane().add(pannel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
