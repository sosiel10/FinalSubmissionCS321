import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApprovalScreen extends JFrame {
	private Workflow workflow;
	private JLabel nameLabel, aNumberLabel, relativeNameLabel;
	private JButton approveButton, reviewButton, getNextButton,closeButton;;
	private static boolean isClosed = false;

	public ApprovalScreen(Workflow workflow) {
		this.workflow = workflow;
		GUI();
	}

	private void GUI() {
		setTitle("Approval Screen");
		setSize(400, 300);
		setLayout(new GridLayout(10, 2));

		// Create labels
		nameLabel = new JLabel("Name: " + workflow.getForm().getName());
		aNumberLabel = new JLabel("Alien Number: " + workflow.getForm().getAN());
		relativeNameLabel = new JLabel("Relative's Name: " + workflow.getForm().getRelativeName());
		add(nameLabel);
		add(aNumberLabel);
		add(relativeNameLabel);

		// Create buttons
		approveButton = new JButton("Approve");
		reviewButton = new JButton("Send Back to Review");
		getNextButton = new JButton("Get Next Form");
		closeButton = new JButton("Close");
		add(approveButton);
		add(reviewButton);
		add(getNextButton);
		add(closeButton);

		// For approveButton
		approveButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(ApprovalScreen.this, "Application Approved!");
		        workflow.setNextStep(2);
		        workflow.generateEmail();
		        
		     // Remove the current form from the list
		        workflow.removeCurrentForm();

		        // Clear labels
		        nameLabel.setText("Name: ");
		        aNumberLabel.setText("Alien Number: ");
		        relativeNameLabel.setText("Relative's Name: ");
		    }
		});

		// For reviewButton
		reviewButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        workflow.setNextStep(0);
		        JOptionPane.showMessageDialog(ApprovalScreen.this, "Sent back for Review");

		        // Clear labels
		        nameLabel.setText("Name: ");
		        aNumberLabel.setText("Alien Number: ");
		        relativeNameLabel.setText("Relative's Name: ");
		    }
		});
		
		getNextButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        Immigrant nextForm = workflow.getNextFormApproval();
		        if (nextForm != null) {
		            workflow.setForm(nextForm);
		            nameLabel.setText("Name: " + nextForm.getName());
		            aNumberLabel.setText("Alien Number: " + nextForm.getAN());
		            relativeNameLabel.setText("Relative's Name: " + nextForm.getRelativeName());
		        } else {
		            JOptionPane.showMessageDialog(ApprovalScreen.this, "No more forms to process");
		            nameLabel.setText("Name: ");
		            aNumberLabel.setText("Alien Number: ");
		            relativeNameLabel.setText("Relative's Name: ");
		        }
		    }
		});


		closeButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        ApprovalScreen.this.dispose();
		        isClosed = true;
		    }
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//  public static void main(Workflow workflow) {
	//  new ApprovalScreen(workflow);
	//}
	static boolean getisClosed()
	{
	return isClosed;	
	}
}

