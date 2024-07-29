package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class question9 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("GridLayout Demo");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a panel with GridLayout
		JPanel gridPanel = new JPanel(new GridLayout(3, 3));

		// Create and add buttons to the panel in a 3x3 grid with colors
		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton("Button " + i);
			button.setBackground(new Color((int) (Math.random() * 0x1000000)));
			button.setOpaque(true);
			button.setBorderPainted(false);
			gridPanel.add(button);

			// Add action listener to each button
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String text = button.getText();
					label.setText("You clicked: " + text);
				}
			});
		}

		// Create a label to display messages
		JLabel label = new JLabel("Click a button", SwingConstants.CENTER);

		// Add the grid panel and label to the frame
		frame.add(gridPanel, BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
