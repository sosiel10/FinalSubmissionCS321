import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataEntry extends JFrame {
    static JFrame f;
    static JLabel l;
    static JButton b;

    public DataEntry() {

    }

    public static void main(String[] args) {
        f = new JFrame("Data Entry");
        l = new JLabel();
        b = new JButton("Submit");
        Dimension size = b.getPreferredSize();
        b.setBounds(400, 250, size.width, size.height);
        JTextField tf = new JTextField("Enter Last Name");
        JTextField tf1 = new JTextField("Enter First Name");
        JTextField tf2 = new JTextField("Enter Alien Number");
        JTextField tf3 = new JTextField("Enter  Reletive Last Name");
        JTextField tf4 = new JTextField("Enter Reletive First Name");
        ActionListener act = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        };
        b.addActionListener(act);
        l.setText("Please Enter Your Immigrant Request Form Data ");
        JPanel p = new JPanel();
        p.add(l);
        p.add(b);
        p.add(tf);
        p.add(tf1);
        p.add(tf2);
        p.add(tf3);
        p.add(tf4);
        f.add(p);
        f.setSize(500, 500);
        f.show();
    }
}
