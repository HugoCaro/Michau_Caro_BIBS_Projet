import javax.swing.*;
import java.awt.*;

public class WindowStart {

    public WindowStart() {

        JFrame f = new JFrame("");
        f.setSize(300, 300);
        JPanel pannel = new JPanel();

        JTextArea  textArea1 = new JTextArea ("Entrer une \nséquence ARN");
        JTextArea  textArea2 = new JTextArea ("Entrer une structure ARN");

        pannel.add(textArea1);
        pannel.add(textArea2);
        f.getContentPane().add(pannel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public JPanel createTextFieldPanel() {
        JTextField textField=new JTextField();
        return createForm("TextField",textField);
    }
}
