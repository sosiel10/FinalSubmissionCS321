import javax.swing.*;
class gui{
    public static void main(String args[]){
       JFrame frame = new JFrame("Review");
       JLabel title = new JLabel();
       JLabel name = new JLabel();
       JLabel alienNumber = new JLabel();
       JLabel relativeName = new JLabel();
       JPanel panel = new JPanel();

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       JButton button1 = new JButton("Approve Edits");
       JButton button2 = new JButton("Edit");
       title.setText("Review Screen\n");

       panel.add(name);
       panel.add(alienNumber);
       panel.add(relativeName);
       panel.add(button1);
       panel.add(button2);
       frame.add(panel);

       name.setText("Name: John Doe\n");
       alienNumber.setText("Alien Number: 6598737\n");
       relativeName.setText("Relative Name: Doe John\n");

       frame.setVisible(true);
    }
}