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
	 * Sets the next step of the workflow.
	 * 
	 * @param step the next step.
	 */
	public void setNextStep(int step) {
		nextStep = step;
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
	public void generateEmail() {
		
	}

	public static void main(String agrs[]){
//		//Immigrant form
//      Immigrant immigrant = new Immigrant("John Doe", 6598737, "Doe John");
//      immigrant.setValidAN(true);
//      //new workflow
//      Workflow workflow = new Workflow(immigrant);
//      ReviewScreen reviewScreen = new ReviewScreen(workflow);
		//int startReview = 0;
		DataEntry a = new DataEntry();
    a.showDisplay();
    Immigrant immigrant = new Immigrant();
    Workflow workflow = new Workflow();
    ReviewScreen reviewScreen/* = new ReviewScreen()*/;
        
    do {
      immigrant = a.getForm();
      immigrant.setValidAN(true);        
      workflow = new Workflow(immigrant);
      reviewScreen = new ReviewScreen(workflow);
      System.out.println();
    }while(a.startReview != 0);
       
    if(workflow.getNextStep() == 0)
    {
  	  reviewScreen.runScreen();			
    }

    do {
			workflow = reviewScreen.getWorkflow();
			workflow.setForm(reviewScreen.getForm());
      if(workflow.getNextStep()==1)
      {
    	 new ApprovalScreen(workflow);
      }
    }while(workflow.getNextStep()!=1);
	}
}
