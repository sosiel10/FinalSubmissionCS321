public class Immigrant {
    private boolean complete;
    private boolean validAN;
    private String name, relativeName;
    private int aNumber;

    /**
     * Default constructor creates a blank immigrant form.
     */
    public Immigrant() {

    }

    /**
     * Constructor that takes in name, alien number and relative name 
     * //can include other parameters we might want in Data Entry
     */
    public Immigrant(String name, int aNumber, String relativeName){

    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean getValidAN() {
        return validAN;
    }

    public void setValidAN(boolean validAN) {
        this.validAN = validAN;
    }

    public String getName() {
       
        return "";
    }

    public void setName(String name) {
        
    }

    public int getAN() {
       
        return 0;
    }

    public void setAN(int aNumber) {
        //if aNumber is >9 digits or <=0, print a message indicating it is ot of bounds
    }

    public String getRelativeName() {
        
        return "";
    }

    public void setRelativeName(String relativeName) {
       
    }

    //checks if the relative has been granted access under a different immigrant
    public boolean relativeAccessGranted(){
        //placeholder
        return true;
    }
}