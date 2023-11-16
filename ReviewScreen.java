import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a review screen which allows the user 
 * to review and edit an exisiting Immigration form
 */
class ReviewScreen{
   

   /**
    * The workflow
    */
   private Workflow workflow;

   /**
    * The immigrant form.
    */
   private Immigrant form;

   /**
    * Indicates the next step.
    * 0 - Review
    * 1 - Approval
    * 2 - Finished
    */
   private int nextStep;

   /**
    * Constructor initializes the workflow, immigrant form,
    * and the next step in the workflow.
    */
   public ReviewScreen(Workflow workflow){
      this.workflow = workflow;
      this.form = this.workflow.getForm();
      this.nextStep = this.workflow.getNextStep();
   }

   /**
    * Allows the user to mark complete after reviewing
    * and applying edits to the form as needed.
    */
   public void isComplete(){
      this.form.setComplete(true);
   }

   /**
    * Allows the reviewer to mark the alien number
    * as valid on the form.
    */
   public void validAN(){
      this.form.setValidAN(true);
   }

   /**
    * Updates the workflow to indicate the next step.
    */
   public void toWorflow(){
      //sets the next step for approval
      this.workflow.setNextStep(1);
   }

   /**
    * This method would save the updated immigrant form to the database
    * it was retrieved from, currently not able to implemented
    * as we are not working with a database.
    */
   public void save(){
      
   }



   public static void main(String args[]){
      JFrame frame = new JFrame("Review");
      
      //Creating all text and labels
      JLabel title = new JLabel();
      JLabel name = new JLabel();
      JLabel alienNumber = new JLabel();
      JLabel relativeName = new JLabel();
      JTextField nameText = new JTextField("John Doe");
      JTextField alienNumberText = new JTextField("6598737");
      JTextField relativeNameText = new JTextField("Doe John");
      
      //creates the panel
      JPanel panel = new JPanel(new GridLayout(5, 2));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600,600);

      //creates the 3 buttons
      JButton editButton = new JButton("Edit");
      JButton approveButton = new JButton("Approve Edits");
      JButton workflowButton = new JButton("Get Workflow Step");
      
      //sets texts for the labels
      title.setText("Review Screen");
      name.setText("Name: ");
      alienNumber.setText("Alien Number: ");
      relativeName.setText("Relative Name: ");

      //adding everything to the panel
      panel.add(title);
      panel.add(workflowButton);
      panel.add(name);
      panel.add(nameText);
      panel.add(alienNumber);
      panel.add(alienNumberText);
      panel.add(relativeName);
      panel.add(relativeNameText);
      panel.add(editButton);
      panel.add(approveButton);
      //adding the frame to the panel
      frame.add(panel);

      //formats it so all the text is central
      title.setHorizontalAlignment(JLabel.CENTER);
      name.setHorizontalAlignment(JLabel.CENTER);
      alienNumber.setHorizontalAlignment(JLabel.CENTER);
      relativeName.setHorizontalAlignment(JLabel.CENTER);
      nameText.setHorizontalAlignment(JLabel.CENTER);
      alienNumberText.setHorizontalAlignment(JLabel.CENTER);
      relativeNameText.setHorizontalAlignment(JLabel.CENTER);
      //sets the frame to be visible
      frame.setVisible(true);

      //makes all text fields not editable
      editChange(false, nameText, alienNumberText, relativeNameText);

      //adds action to edit button so it can allow edits
      editButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event){
            editChange(true, nameText, alienNumberText, relativeNameText);
         }
      });

      //adds action to approv button to accept the edits
      approveButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event){
            editChange(false, nameText, alienNumberText, relativeNameText);
         }
      });
   }

   /**
    * Helper method that changes the editability of the text fields.
    * 
    * @param bool the editiability, true it change to editable, false otherwise.
    * @param name the name text field.
    * @param an the alien number text field.
    * @param rn the relative number text field.
    */
   public static void editChange(boolean bool, JTextField nameText, JTextField alienNumberText, JTextField relativeNameText){
      nameText.setEditable(bool);
      alienNumberText.setEditable(bool);
      relativeNameText.setEditable(bool);
   }

}