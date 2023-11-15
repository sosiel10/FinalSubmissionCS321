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

	
	//public Workflow(){}

	/**
	 * Constructor creates the workflow and
	 * initializes the immigrant form.
	 */
	public Workflow(Immigrant form) {
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
}
