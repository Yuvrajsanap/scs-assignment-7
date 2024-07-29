package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class question7 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Layout Manager Examples");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 2));

		// BorderLayout Example
		JPanel borderLayoutPanel = new JPanel(new BorderLayout());
		borderLayoutPanel.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
		borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
		borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
		borderLayoutPanel.add(new JButton("East"), BorderLayout.EAST);
		borderLayoutPanel.add(new JButton("West"), BorderLayout.WEST);
		borderLayoutPanel.add(new JButton("Center"), BorderLayout.CENTER);

		// FlowLayout Example
		JPanel flowLayoutPanel = new JPanel(new FlowLayout());
		flowLayoutPanel.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
		flowLayoutPanel.add(new JButton("Button 1"));
		flowLayoutPanel.add(new JButton("Button 2"));
		flowLayoutPanel.add(new JButton("Button 3"));
		flowLayoutPanel.add(new JButton("Button 4"));
		flowLayoutPanel.add(new JButton("Button 5"));

		// GridLayout Example
		JPanel gridLayoutPanel = new JPanel(new GridLayout(2, 3));
		gridLayoutPanel.setBorder(BorderFactory.createTitledBorder("GridLayout"));
		gridLayoutPanel.add(new JButton("Button 1"));
		gridLayoutPanel.add(new JButton("Button 2"));
		gridLayoutPanel.add(new JButton("Button 3"));
		gridLayoutPanel.add(new JButton("Button 4"));
		gridLayoutPanel.add(new JButton("Button 5"));
		gridLayoutPanel.add(new JButton("Button 6"));

		// BoxLayout Example
		JPanel boxLayoutPanel = new JPanel();
		boxLayoutPanel.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
		boxLayoutPanel.setLayout(new BoxLayout(boxLayoutPanel, BoxLayout.Y_AXIS));
		boxLayoutPanel.add(new JButton("Button 1"));
		boxLayoutPanel.add(new JButton("Button 2"));
		boxLayoutPanel.add(new JButton("Button 3"));
		boxLayoutPanel.add(new JButton("Button 4"));
		boxLayoutPanel.add(new JButton("Button 5"));

		// Adding all panels to the main frame
		frame.add(borderLayoutPanel);
		frame.add(flowLayoutPanel);
		frame.add(gridLayoutPanel);
		frame.add(boxLayoutPanel);

		// Making the frame visible
		frame.setVisible(true);
	}
}
