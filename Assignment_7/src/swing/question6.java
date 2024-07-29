package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class question6 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Simple Form");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new java.awt.FlowLayout());

		// Create a new JTextField
		JTextField textField = new JTextField(20);

		// Create a new JButton
		JButton button = new JButton("Submit");

		// Create a new JLabel
		JLabel label = new JLabel("Enter text and click submit");

		// Add an action listener to the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				label.setText("You entered: " + text);
			}
		});

		// Add the text field, button, and label to the frame
		frame.add(textField);
		frame.add(button);
		frame.add(label);

		// Make the frame visible
		frame.setVisible(true);
	}
}
