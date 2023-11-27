import java.util.ArrayList;

/**
* The class represents the workflow and how the
* program will run.
*/
public class WorkflowTest {
	/**
	 * Indicates the next step.
	 * 0 - Review
	 * 1 - Approval
	 * 2 - Finished
	 */
	private int nextStep;

	/**
	 * The immigrant's form.
	 
	private Immigrant form;*/

	/**
	 * List of applications
	 */
	ArrayList<Immigrant> formList;
	

	/**
	 * Constructor creates a worfklow with no immigrant form
	 */
	public Workflow(){
		this.nextStep = -1;
		this.formList = new ArrayList<>();
	}

	/**
	 * Constructor creates the workflow and
	 * initializes the immigrant form.
	 */
	public Workflow(Immigrant form) {
		this.nextStep = 0;
		this.formList = new ArrayList<>();
		this.formList.add(form);
		//this.startReview = 0;
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

//	public int getStartReview() {
//		return startReview;
//	}
//	
//	public void setStartReview(int start) {
//		startReview = start;
//	}
	/**
	 * Gets the immigrant form.
	 * 
	 * @return the form.
	 */
	public ArrayList<Immigrant> getFormList() {
		return formList;
	}

	/**
	 * Sets the form if needed.
	 */
	public void addForm(Immigrant form) {
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
        ReviewScreen reviewScreen = new ReviewScreen();
        
        do {
        immigrant = a.getForm();
        immigrant.setValidAN(true);        
        workflow = new Workflow(immigrant);
        reviewScreen = new ReviewScreen(workflow);
        System.out.println();
        }while(a.startReview != 0);
        //a.startReview;
        //workflow.getNextStep();
        //System.out.println(immigrant.getName());
        //do {
      if(workflow.getNextStep() == 0)
      {
    	  reviewScreen.main(workflow);
			
      }
        //} while(workflow.get != 0)
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
