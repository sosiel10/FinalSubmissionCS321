import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApprovalScreen extends JFrame {
	private Workflow workflow;
	private JLabel nameLabel, aNumberLabel, relativeNameLabel;
	private JButton approveButton, reviewButton;

	public ApprovalScreen(Workflow workflow) {
		this.workflow = workflow;
		GUI();
	}

	private void GUI() {
		setTitle("Approval Screen");
		setSize(400, 300);
		setLayout(new GridLayout(5, 1));

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
		add(approveButton);
		add(reviewButton);

		// Add approve button pop up
		approveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//boolean emailSent = workflow.generateEmail();
				JOptionPane.showMessageDialog(ApprovalScreen.this, "Application Approved and Email Sent!");
				// Close the window
				ApprovalScreen.this.dispose();
			}
		});

		// Add review button pop up
		reviewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Send back to review
				workflow.setNextStep(0);
				JOptionPane.showMessageDialog(ApprovalScreen.this, "Sent back for Review");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	//  public static void main(Workflow workflow) {
	//  new ApprovalScreen(workflow);
	//}
}

