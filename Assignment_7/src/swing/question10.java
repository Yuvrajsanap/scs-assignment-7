package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class question10 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("BoxLayout Demo");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a panel with BoxLayout for vertical alignment
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Create text fields
		JTextField firstNameField = new JTextField(20);
		JTextField lastNameField = new JTextField(20);
		JTextField emailField = new JTextField(20);
		JTextField phoneField = new JTextField(20);

		// Add labels and text fields to the form panel
		formPanel.add(createLabeledField("First Name:", firstNameField));
		formPanel.add(createLabeledField("Last Name:", lastNameField));
		formPanel.add(createLabeledField("Email:", emailField));
		formPanel.add(createLabeledField("Phone:", phoneField));

		// Create a panel with BoxLayout for horizontal alignment of buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

		// Create buttons
		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		// Add action listener for the Submit button
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message = "Form Submitted:\n" + "First Name: " + firstNameField.getText() + "\n" + "Last Name: "
						+ lastNameField.getText() + "\n" + "Email: " + emailField.getText() + "\n" + "Phone: "
						+ phoneField.getText();
				JOptionPane.showMessageDialog(frame, message, "Submission", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Add action listener for the Cancel button
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNameField.setText("");
				lastNameField.setText("");
				emailField.setText("");
				phoneField.setText("");
			}
		});

		// Add buttons to the button panel
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(submitButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createHorizontalGlue());

		// Add form panel and button panel to the frame
		frame.add(formPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}

	// Helper method to create a panel with a label and text field
	private static JPanel createLabeledField(String labelText, JTextField textField) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JLabel label = new JLabel(labelText);
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		panel.add(textField);
		return panel;
	}
}
