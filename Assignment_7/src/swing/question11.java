package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class question11 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Event Handling Demo");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a label
		JLabel label = new JLabel("Click the button", SwingConstants.CENTER);

		// Create a button
		JButton button = new JButton("Click Me");

		// Add action listener to the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Button clicked!");
			}
		});

		// Add label and button to the frame
		frame.add(label, BorderLayout.CENTER);
		frame.add(button, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
