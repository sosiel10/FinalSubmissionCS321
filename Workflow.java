//import java.util.concurrent.CountDownLatch;

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
	 * Constructor creates a worfklow with no immigrant form
	 */
	public Workflow(){
		this.nextStep = -1;
		this.form = null;
	}

	/**
	 * Constructor creates the workflow and
	 * initializes the immigrant form.
	 */
	public Workflow(Immigrant form) {
		this.nextStep = -1;
		this.form = form;
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
	 * Generates an email to send to the applicant
	 * depending on their qualification.
	 * 
	 * @return true if qualified, false if not.
	 */
	public boolean generateEmail() {
		return false;
	}

	public static void main(String agrs[]){
		//Immigrant form
        Immigrant immigrant = new Immigrant("John Doe", 6598737, "Doe John");
        immigrant.setValidAN(true);
        //new workflow
        Workflow workflow = new Workflow(immigrant);
        workflow.setNextStep(0);
        int nextStep = workflow.getNextStep();
		
		//CountDownLatch latch = new CountDownLatch(1);

		//Creates new instance of Review Screen
		ReviewScreen reviewScreen = new ReviewScreen(workflow);

        //while(nextStep != 1){
        	if(nextStep == 0){
				reviewScreen.main(workflow);
				workflow = reviewScreen.getWorkflow();
				workflow.setForm(reviewScreen.getForm());
        	}
			nextStep = workflow.getNextStep();
			if(nextStep == 1)
				System.out.println("Workflow next step was updated properly");
			
				/*try{
					latch.await();
				}
				catch(InterruptedException e){
					System.out.print("Failed");
				}*/
      
		//}
		System.out.println("Finished");
	}
}