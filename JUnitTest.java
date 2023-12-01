import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

/**
 * Junit tests for the methods in the Immigration and Workflow classes
 */
public class JUnitTest {
	//Workflow class

	/**
	 * Testing to make sure constructor initializes the workflow properly.
	 */
	@Test
	public void wfEmptyConstructor(){
		Workflow workflow = new Workflow();

		//Check that the workflow constructor initializes the next step to -1
		assertEquals(-1, workflow.getNextStep());
		//Check that the workflow constructor initializes the form to null
		assertEquals(null, workflow.getForm());
		//Check that the workflow constructor initializes the form list to an empty list
		assertEquals(true, workflow.getFormList().isEmpty());	
	}

	/**
	 * Testing to make sure constructor initializes the workflow properly.
	 */
	@Test
	public void workflowConstructor(){
		Immigrant immigrant = new Immigrant("Alice Smith", 789012, "Bob Smith");
		Workflow workflow = new Workflow(immigrant);

		//Checks that the workflow constructor initializes the next step appropriately
		assertEquals(0, workflow.getNextStep());
		//Checks that the workflow constructor initializes the form to the immigrant
		assertEquals(immigrant, workflow.getForm());
		//Checks that the workflow constructor adds the form to the form list
		assertEquals(1, workflow.getFormList().size());
	}

	/**
	 * Testing the addForm method and remove method in the workflow.
	 */
	@Test
	public void testAddRemove(){
		Immigrant immigrant1 = new Immigrant("John Doe", 123456, "Jane Doe");
		Immigrant immigrant2 = new Immigrant("Alice Smith", 789012, "Bob Smith");
		Workflow workflow = new Workflow(immigrant1);

		workflow.addForm(immigrant2);
		//Testing if size increases to 2 after addForm()
		assertEquals(2, workflow.getFormList().size());

		workflow.removeCurrentForm();
		//Testing if size decreased after removeCurrentForm()
		assertEquals(1, workflow.getFormList().size());
	}

	/**
	 * Testing to make sure the proper email is sent out depending
	 * on whether the application was approved or not.
	 */
	@Test 
	public void checkEmail(){
		Immigrant immigrant = new Immigrant();
		Workflow wf = new Workflow(immigrant);

		//tests the case in which the form is not complete/approved
		assertEquals("Unfortunately, we cannot allow your request to go through.", false,  wf.generateEmail());
		//sets the immigrant's/form's complete field to true
		immigrant.setComplete(true);
		//tests the case in which the form is completed/approved
		assertEquals("Congratulations, your application is valid and your request has been sent through.", true, wf.generateEmail());
	}

	/**
	 * Testing to make sure setNextStep handles the possible inputs correctly,
	 * has to be either review or approval or approved
	 */
	@Test
	public void nextStepInput(){
		Workflow wf = new Workflow();
		
		wf.setNextStep(0);
		//Checking if next step for Review works, assuming data entry set the next step appropriately
		assertEquals(0, wf.getNextStep());
		wf.setNextStep(1);
		//Checking if next step for Approval works, assuming review set the next step appropriately
		assertEquals(1, wf.getNextStep());
		wf.setNextStep(2);
		//Checking if next step for Finished works, assuming approval set the next step appropriately
		assertEquals(2, wf.getNextStep());
		//Checking if input other than 0,1,2 is valid since it should not be
		assertEquals(false, wf.setNextStep(-1));
		assertEquals(2, wf.getNextStep());
		assertEquals(false, wf.setNextStep(3));
		assertEquals(2, wf.getNextStep());
	}


	//Immigrant class

	/**
	 * Testing to make sure the relative is checked properly to
	 * ensure they have not already been granted access under a
	 * different immigrant.
	 */
	@Test
	public void checkRelative(){
		Immigrant immigrant = new Immigrant("Aleem Sarwar", 5, "John Doe");
		//Immigrant immigrant2 = new Immigrant("Aleem Sarwar", 5, "John Doe");
		//setting the relative name to someone that has not been granted access
		immigrant.setRelativeName("Lionel Pessi");
		assertEquals(false, immigrant.relativeAccessGranted());
		immigrant.setAccessGranted(true);
		//setting the relative name to someone that has been granted access
		immigrant.setRelativeName("Aleem Sarwar");
		assertEquals(true, immigrant.relativeAccessGranted());
	}

	/**
	 * Testing to make sure setAN handles numbers that are out of bounds.
	 */
	@Test
	public void checkSetAN(){
		Immigrant immigrant = new Immigrant();
		//setting AN to -1
		immigrant.setAN(-1);
		//check to see if number is valid.
		assertEquals(false, immigrant.getValidAN());
		//setting AN to 1 billion
		immigrant.setAN(1000000000);
		//check to see if number is valid.
		assertEquals(false, immigrant.getValidAN());
		//setting AN to 0
		immigrant.setAN(0);
		//check to see if number is valid.
		assertEquals(false, immigrant.getValidAN());
		//setting AN to valid number
		immigrant.setAN(1234567);
		//check to make sure it is valid
		assertEquals(true, immigrant.getValidAN());
	}

	/**
	 * Testing to make sure Immigrant constructor values are valid and can be accsessed.
	 */
	@Test
	public void checkImmigrantConstructor(){
		Immigrant im = new Immigrant();
		assertEquals("Check If Complete is false: ", false, im.getComplete());
		assertEquals("Check If getValidAN is false: ", false, im.getValidAN());
		im.setComplete(true);
		im.setValidAN(true);
		assertEquals("Check If Complete is true: ", true, im.getComplete());
		assertEquals("Check If getValidAN is true: ", true, im.getComplete());
	}





















}
