public class Workflow {
    private String nextStep;
    private Immigrant form;

    public Workflow(){}

    public Workflow(Immigrant form) {

    }
    public String getNextStep() {
        return nextStep;
    }

    public String setNextStep(String nextStep) {
        //if input is not a valid step, return an error message
        this.nextStep = nextStep;
        return this.nextStep;
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
