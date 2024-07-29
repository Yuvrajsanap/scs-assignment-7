package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class question4 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Hello World JFrame");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a new JLabel
		JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);

		// Add the label to the frame
		frame.add(label);

		// Make the frame visible
		frame.setVisible(true);
	}
}
