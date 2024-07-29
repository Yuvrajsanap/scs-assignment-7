package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class question5 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Button Click Example");
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new java.awt.FlowLayout());

		// Create a new JLabel
		JLabel label = new JLabel("Click the button!");

		// Create a new JButton
		JButton button = new JButton("Click Me");

		// Add an action listener to the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Button Clicked!");
			}
		});

		// Add the label and button to the frame
		frame.add(label);
		frame.add(button);

		// Make the frame visible
		frame.setVisible(true);
	}
}
