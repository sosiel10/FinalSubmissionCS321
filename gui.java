import javax.swing.*;
class gui{
    public static void main(String args[]){
       JFrame frame = new JFrame("My First GUI");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300,300);
       JButton button1 = new JButton("Button1");
       frame.getContentPane().add(button1); // Adds Button to content pane of frame
       frame.setVisible(true);
    }
}