package swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class question19 {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Custom Dialog Demo");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		// Button to open the custom dialog
		JButton openDialogButton = new JButton("Open Custom Dialog");
		openDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomDialog customDialog = new CustomDialog(frame);
				customDialog.setVisible(true);
			}
		});

		frame.add(openDialogButton);

		frame.setVisible(true);
	}
}

// Custom dialog class
class CustomDialog extends JDialog {
	private JTextField nameField;
	private JTextField ageField;
	private JButton submitButton;
	private JButton cancelButton;

	public CustomDialog(JFrame parent) {
		super(parent, "Custom Dialog", true);
		setLayout(new GridLayout(3, 2));

		// Name field
		add(new JLabel("Name:"));
		nameField = new JTextField();
		add(nameField);

		// Age field
		add(new JLabel("Age:"));
		ageField = new JTextField();
		add(ageField);

		// Submit button
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String age = ageField.getText();
				JOptionPane.showMessageDialog(CustomDialog.this, "Name: " + name + "\nAge: " + age, "Submitted Data",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
		add(submitButton);

		// Cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(cancelButton);

		setSize(300, 150);
		setLocationRelativeTo(parent);
	}
}
