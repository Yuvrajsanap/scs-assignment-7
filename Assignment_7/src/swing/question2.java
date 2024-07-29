package swing;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class question2 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Swing Colored Example");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a new JPanel
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);

		// Create a new JButton
		JButton button = new JButton("Click Me");
		button.setBackground(Color.YELLOW);
		button.setForeground(Color.BLUE);

		// Create a new JLabel
		JLabel label = new JLabel("Hello, Swing!");
		label.setOpaque(true);
		label.setBackground(Color.MAGENTA);
		label.setForeground(Color.WHITE);

		// Add an action listener to the button
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
