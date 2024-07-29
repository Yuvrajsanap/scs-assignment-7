package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class question12 {
	public static void main(String[] args) {
		// Create a new JFrame
		JFrame frame = new JFrame("Color Change Demo");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a JPanel
		JPanel colorPanel = new JPanel();
		colorPanel.setBackground(Color.WHITE);

		// Create a panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		// Create buttons
		JButton redButton = new JButton("Red");
		JButton greenButton = new JButton("Green");
		JButton blueButton = new JButton("Blue");

		// Add action listeners to the buttons
		redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPanel.setBackground(Color.RED);
			}
		});

		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPanel.setBackground(Color.GREEN);
			}
		});

		blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorPanel.setBackground(Color.BLUE);
			}
		});

		// Add buttons to the button panel
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(blueButton);

		// Add the panels to the frame
		frame.add(colorPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
