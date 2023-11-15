import javax.swing.*;

/**
 * This class creates a review screen which allows the user 
 * to review and edit an exisiting Immigration form
 */
class ReviewScreen{
   /**
    * The workflow
    */
   Workflow workflow;

   /**
    * The immigrant form.
    */
   Immigrant form;

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