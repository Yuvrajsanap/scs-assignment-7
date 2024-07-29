package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class question1 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Swing Example");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a new JPanel
		JPanel panel = new JPanel();

		// Create a new JButton
		JButton button = new JButton("Click Me");

		// Create a new JLabel
		JLabel label = new JLabel("Hello, Swing!");

		button.addActionListener(e -> label.setText("Button Clicked!"));

		// Add the button and label to the panel
		panel.add(button);
		panel.add(label);

		// Add the panel to the frame
		frame.add(panel);

		// Make the frame visible
		frame.setVisible(true);
	}
}
