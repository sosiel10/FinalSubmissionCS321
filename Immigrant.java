/**
 * Class represents the application of an immigrant requesting
 * entry for a relative.
 */
public class Immigrant {
    /**
     * Whether or not the form is complete.
     */
    private boolean complete;

    /**
     * Whether or not the relative has already been granted access.
     */
    private boolean relativeAccessGranted;

    /**
     * Whether or not the alien number is valid.
     */
    private boolean validAN;

    /**
     * The name of the immigrant.
     */
    private String name;

    /**
     * The name of the relative being requested for.
     */
    private String relativeName;

    /**
     * The alien number.
     */
    private int aNumber;

    /**
     * Default constructor creates a blank immigrant form.
     */
    public Immigrant() {
        this.complete = false;
        this.validAN = false;
    }
    /**
     * Constructor that takes in name, alien number and relative name 
     * //can include other parameters we might want in Data Entry
     */
    public Immigrant(String name, int aNumber, String relativeName){
        this.name = name;
        this.aNumber = aNumber;
        this.relativeName = relativeName;
        this.complete = false;
        this.validAN = false;
    }

    /**
     * Gets the complete field.
     * 
     * @return whether or not the form is complete.
     */
    public boolean getComplete() {
        return complete;
    }

    /**
     * Sets the complete field.
     * 
     * @param complete whether or not the form is complete.
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Gets the validAN field.
     *
     * @return whether or not the alien number is valid.
     */
    public boolean getValidAN() {
        return validAN;
    }

    /**
     * Sets the validAN field.
     * 
     * @param whether or not the alien number is valid.
     */
    public void setValidAN(boolean validAN) {
        this.validAN = validAN;
    }

    /**
     * Gets the name of the immigrant.
     * 
     * @return the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the immigrant.
     * 
     * @param name the new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the alien number of the immigrant.
     * 
     * @return the alien number.
     */
    public int getAN() {
        return this.aNumber;
    }

    /**
     * Sets the alien number.
     * 
     * @param aNumber the new alien number.
     */
    public void setAN(int aNumber) {
        this.aNumber = aNumber;
        if(aNumber <= 0 || aNumber > 999999999){
            setValidAN(false);
            return;
        }
        setValidAN(true);
    }

    /**
     * Gets the name of the relative.
     * 
     * @return the name of the relative.
     */
    public String getRelativeName() {
        
        return this.relativeName;
    }

    /**
     * Sets the name of the relative.
     * 
     * @param relativeName the new name.
     */
    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName;
    }

    /**
     * Updates whether or not relative has been granted access.
     * 
     * @param accessGranted whether or not access has been granted.
     */
    public void setAccessGranted(boolean accessGranted){
        this.relativeAccessGranted = accessGranted;
    }

    /**
     * Checks if the relative has been granted access 
     * under a different immigrant.
     * 
     * @return if the relative has been granted access under a different immigrant.
     */
    public boolean relativeAccessGranted(){
        return relativeAccessGranted;
    }
}
