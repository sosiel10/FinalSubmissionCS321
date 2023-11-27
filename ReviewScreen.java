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

   
   
   
   public ReviewScreen(){

      }
   /**
    * Constructor initializes the workflow, immigrant form,
    * and the next step in the workflow.
    */
   public ReviewScreen(Workflow workflow){
      this.workflow = workflow;
      this.form = this.workflow.getNextForm();
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
   public void toWorkflow(){
      //sets the next step for approval
      this.nextStep = 1;
      this.workflow.setNextStep(1);
      //latch.countDown();
   }

   /**
    * Gets the immigrant form.
    * 
    * @return the form.
    */
   public Immigrant getForm() {
      return form;
   }

   /**
    * Gets the next immigrant form.
    * 
    * @return the next form.
    */
   public Immigrant getNextForm(){
      this.form = this.workflow.getNextForm();
      return this.workflow.getNextForm();
   }

   /**
    * Gets the updated workflow.
    * 
    * @return the workflow.
    */
   public Workflow getWorkflow(){
      return workflow;
   }

   /**
    * Gets the next step of the workflow.
    * 
    * @return the next step.
    */
   public int getNextStep() {
      return workflow.getNextStep();
   }

   /**
    * This method would save the updated immigrant form to the database
    * it was retrieved from, currently not able to implemented
    * as we are not working with a database.
    */
   public void save(){
      
   }

   /**
    * Runs the screen.
    */
   public void runScreen(){
      //ReviewScreen review = new ReviewScreen(workflow);
      String name = getForm().getName();
      int alienNumber = getForm().getAN();
      String relativeName = getForm().getRelativeName();
      String workflowStep = "";
      int nextStep = getNextStep();
      if(nextStep == 0)
         workflowStep = "Review";
      else if(nextStep == 1)
         workflowStep = "Approval";

      JFrame frame = new JFrame("Review");
      
      //Creating all text and labels
      JLabel title = new JLabel();
      JLabel nameLabel = new JLabel();
      JLabel alienNumberLabel = new JLabel();
      JLabel relativeNameLabel = new JLabel();
      JLabel workflowLabel = new JLabel();
      workflowLabel.setVisible(false);
      JTextField nameText = new JTextField(name);
      JTextField alienNumberText = new JTextField(Integer.toString(alienNumber));
      JTextField relativeNameText = new JTextField(relativeName);
      JTextField workflowText = new JTextField(workflowStep);
      workflowText.setVisible(false);
      
      //creates the panel
      JPanel panel = new JPanel(new GridLayout(6, 2));

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600,600);

      //creates the 3 buttons
      JButton editButton = new JButton("Edit");
      JButton approveButton = new JButton("Approve Edits");
      JButton workflowButton = new JButton("Get Workflow Step");
      
      //sets texts for the labels
      title.setText("Review Screen");
      nameLabel.setText("Name: ");
      alienNumberLabel.setText("Alien Number: ");
      relativeNameLabel.setText("Relative Name: ");
      workflowLabel.setText("Workflow Step: ");

      //adding everything to the panel
      panel.add(title);
      panel.add(workflowButton);
      panel.add(workflowLabel);
      panel.add(workflowText);
      panel.add(nameLabel);
      panel.add(nameText);
      panel.add(alienNumberLabel);
      panel.add(alienNumberText);
      panel.add(relativeNameLabel);
      panel.add(relativeNameText);
      panel.add(editButton);
      panel.add(approveButton);
      //adding the frame to the panel
      frame.add(panel);

      //formats it so all the text is central
      title.setHorizontalAlignment(JLabel.CENTER);
      nameLabel.setHorizontalAlignment(JLabel.CENTER);
      alienNumberLabel.setHorizontalAlignment(JLabel.CENTER);
      relativeNameLabel.setHorizontalAlignment(JLabel.CENTER);
      workflowLabel.setHorizontalAlignment(JLabel.CENTER);
      nameText.setHorizontalAlignment(JLabel.CENTER);
      alienNumberText.setHorizontalAlignment(JLabel.CENTER);
      relativeNameText.setHorizontalAlignment(JLabel.CENTER);
      workflowText.setHorizontalAlignment(JLabel.CENTER);
      //sets the frame to be visible
      frame.setVisible(true);

      //makes all text fields not editable
      editChange(false, nameText, alienNumberText, relativeNameText);
      workflowText.setEditable(false);

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
            //setting the new edited fields to the form
            getForm().setName(nameText.getText());
            getForm().setAN(Integer.parseInt(alienNumberText.getText()));
            getForm().setRelativeName(relativeNameText.getText());
            isComplete();
            validAN();
            toWorkflow();
            frame.dispose();
         }
      });

      //adds action to workflow button
      workflowButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event){
            workflowLabel.setVisible(true);
            workflowText.setVisible(true);
         }
      });
   }


   /**
    * Main method.
    */
   public static void main(){
      
   }

   /**
    * Helper method that changes the editability of the text fields.
    * 
    * @param bool the editiability, true it change to editable, false otherwise.
    * @param nameText the name text field.
    * @param alienNumberText the alien number text field.
    * @param relativeNameText the relative number text field.
    */
   private void editChange(boolean bool, JTextField nameText, JTextField alienNumberText, JTextField relativeNameText){
      nameText.setEditable(bool);
      alienNumberText.setEditable(bool);
      relativeNameText.setEditable(bool);
   }

}