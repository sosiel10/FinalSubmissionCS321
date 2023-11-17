import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataEntry extends JFrame {
    static JFrame f;
    static JLabel l;
    static JButton b;

    public static String fname;
    public static String Lname;
    public static int Anum;
    public static String Benefname;
    public static String BeneLname;
    public static Immigrant test;

    public void showDisplay(){
        f = new JFrame("Data Entry");
        l = new JLabel();
        b = new JButton("Submit");
        Dimension size = b.getPreferredSize();
        b.setBounds(400, 250, size.width, size.height);
        JTextField tf = new JTextField("Enter Last Name");
        JTextField tf1 = new JTextField("Enter First Name");
        JTextField tf2 = new JTextField("Enter Alien Number");
        JTextField tf3 = new JTextField("Enter Reletive Last Name");
        JTextField tf4 = new JTextField("Enter Reletive First Name");
        l.setText("Please Enter Your Immigrant Request Form Data (Click Enter After Each Field Is Entered)");
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        p.add(l);
        p2.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("First Name: " + fname);
                System.out.println("Last Name: " + Lname);
                System.out.println("Alien Number: " + Anum);
                test.setAN(Anum);
                System.out.println("Beneficiary First Name: " + Benefname);
                System.out.println("Beneficiary Last Name: " + BeneLname);
                test.setName(fname + " " + Lname);
                test.setRelativeName(Benefname + " " + BeneLname);
                //Immigrant im = new Immigrant(fname + " " + Lname, Anum, Benefname + " " + BeneLname); 
               //System.out.println("Immigrant Num:" + im.getAN());
               //System.out.println("Immigrant Name: " + im.getName());
                //System.out.println("Reletive Name: " + im.getRelativeName());
                System.exit(0);
            }
        });
        p3.add(tf);
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setLname(tf.getText());
                tf.setForeground(Color.GREEN);
            }
        });
        p3.add(tf1);
        tf1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setfname(tf1.getText());
                tf1.setForeground(Color.GREEN);
            }
        });
        p3.add(tf2);
        tf2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setAnum(tf2.getText());
                tf2.setForeground(Color.GREEN);
            }
        });
        p3.add(tf3);
        tf3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setBenLname(tf3.getText());
                tf3.setForeground(Color.GREEN);
            }
        });
        p3.add(tf4);
        tf4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setBeneFname(tf4.getText());
                tf4.setForeground(Color.GREEN);
            }
        });
        f.add(p, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);
        f.add(p3, BorderLayout.CENTER);
        f.setSize(550, 550);
        f.setVisible(true); 
    }

    public String getfname(){
        return fname;
    }

    public String getLname(){
        return Lname;
    }

    public int getanAnum(){
        return Anum;
    }

    public String getBeneFname(){
        return Benefname;
    }

    public String getBenLname(){
        return BeneLname;
    }

    public static void setfname(String str){
        fname = str;
    }

    public static void setLname(String str){
        Lname = str;
    }

    public static void setAnum(String str){
        Anum = Integer.parseInt(str);
    }

    public static void setBeneFname(String str){
        Benefname = str;
    }

    public static void setBenLname(String str){
        BeneLname = str;
    }

    public static void main(String[] args) {
        DataEntry a = new DataEntry();
        a.showDisplay();
    }
}