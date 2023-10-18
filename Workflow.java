public class Workflow {
    private String nextStep;
    private Immigrant form;

    public Workflow() {
    }
    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public Immigrant getForm() {
        return form;
    }

    public void setForm(Immigrant form) {
        this.form = form;
    }

    public boolean generateEmail() {
        
        return false;
    }

    public void callNext() {
        
    }
}
