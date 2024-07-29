package swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class question8 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("BorderLayout Demo");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create components for different regions
		JButton northButton = new JButton("North");
		JButton southButton = new JButton("South");
		JButton eastButton = new JButton("East");
		JButton westButton = new JButton("West");
		JButton centerButton = new JButton("Center");

		// Add components to the frame in different regions
		frame.add(northButton, BorderLayout.NORTH);
		frame.add(southButton, BorderLayout.SOUTH);
		frame.add(eastButton, BorderLayout.EAST);
		frame.add(westButton, BorderLayout.WEST);
		frame.add(centerButton, BorderLayout.CENTER);

		// Make the frame visible
		frame.setVisible(true);
	}
}
