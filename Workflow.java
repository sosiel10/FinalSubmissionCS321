import java.util.ArrayList;

/**
* The class represents the workflow and how the
* program will run.
*/
public class Workflow {
	/**
	 * Indicates the next step.
	 * 0 - Review
	 * 1 - Approval
	 * 2 - Finished
	 */
	private int nextStep;

	/**
	 * The immigrant's form.
	 */
	private Immigrant form;

	/**
	 * List of immigrant forms
	 */
	ArrayList<Immigrant> formList;


	/**
	 * Constructor creates a worfklow with no immigrant form
	 */
	public Workflow(){
		this.nextStep = -1;
		this.form = null;
		this.formList = new ArrayList<>();
	}

	/**
	 * Constructor creates the workflow and
	 * initializes the immigrant form.
	 */
	public Workflow(Immigrant form) {
		this.nextStep = 0;
		this.form = form;
		this.formList = new ArrayList<>();
		this.formList.add(form);
	}

	/**
	 * Gets the next step of the workflow.
	 * 
	 * @return the next step.
	 */
	public int getNextStep() {
		return nextStep;
	}

	/**
	 * Sets the next step of the workflow. Returns true if
	 * it was set properly and false otherwise.
	 * 
	 * @param step the next step.
	 * @return whether or not it was successful.
	 */
	public boolean setNextStep(int step) {
		if(step > 2 || step < 0){
			return false;
		}
		nextStep = step;
		return true;
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
	 * Sets the form if needed.
	 */
	public void setForm(Immigrant form) {
		this.form = form;
	}

	/**
	 * Gets next immigrant form in the list for review.
	 * 
	 * @return the next form.
	 */
	public Immigrant getNextForm(){
		if(formList.size() == 0)
			return null;

		Immigrant form = null;
		for(int i=0; i<formList.size(); i++){
			form = formList.get(i);
			if(!form.getComplete())
				return form;
		}
		return null;
	}

	/**
	 * Adds a form to the list.
	 * 
	 * @param form the form.
	 */
	public void addForm(Immigrant form){
		this.formList.add(form);
	}

	/**
	 * Generates an email to send to the applicant
	 * depending on their qualification.
	 * 
	 */
	public boolean generateEmail() {
		return true;
	}

	/**
	 * Main method to execute the workflow process.
	 * 
	 * @param args the command line arguments if applicable.
	 */
	public static void main(String args[]){
		DataEntry a = new DataEntry();
    a.showDisplay();
    Immigrant immigrant = new Immigrant();
    Workflow workflow = new Workflow();
    ReviewScreen reviewScreen;
        
    do {
      immigrant = a.getForm();
      immigrant.setValidAN(true);        
      workflow = new Workflow(immigrant);
      reviewScreen = new ReviewScreen(workflow);
      System.out.println();
    }while(a.startReview != 0);
       
    //Review step commences if next step is set to review
    if(workflow.getNextStep() == 0)
    {
    	//Runs the review screen
  	  reviewScreen.runScreen();
  	  //Keeps review screen running until all forms have been reviewed
  	  //You have to approve edits to approve each form and get every workflow item
  	  //until there are no more forms to review			
	    while(reviewScreen.getFrame().isVisible()){
	    	try{
			    Thread.sleep(100);
	     	}
	      catch(InterruptedException e) {
	         e.printStackTrace();
	      }
	  	}
	  }

    //do {
	  	//updates the workflow
			workflow = reviewScreen.getWorkflow();
      if(workflow.getNextStep()==1)
      {
    	 new ApprovalScreen(workflow);
      }
    //}while(workflow.getNextStep()!=1);
	}
}
