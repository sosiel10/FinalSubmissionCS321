public class Workflow {
	private int nextStep;
	private Immigrant form;

	public Workflow(){}

	public Workflow(Immigrant form) {

	}
	public int getNextStep() {
		return nextStep;
	}
// Data Entry is 1, Review is 2, Approval is 3
	public void setNextStep(int step) {
		nextStep = step;
	}

	public Immigrant getForm() {
		return form;
	}

	public void setForm(Immigrant form) {
		this.form = form;
	}

	public boolean generateEmail() {
		//use isComplete() on form
		return false;
	}

	public void callNext() {

	}
}
