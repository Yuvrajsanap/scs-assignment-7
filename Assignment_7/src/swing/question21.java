package swing;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class question21 extends JFrame {
	public question21() {
		// Setup the frame
		setTitle("Split Pane Demo");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// left panel with some components
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(new JLabel("Left Panel"));
		leftPanel.add(new JTextArea(5, 20));

		// right panel with some components
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(new JLabel("Right Panel"));
		rightPanel.add(new JTextArea(5, 20));

		// the split pane
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		splitPane.setDividerLocation(200); // Initial divider location

		// Add the split pane to the frame
		add(splitPane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// Create and display the frame
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question21 frame = new question21();
				frame.setVisible(true);
			}
		});
	}
}
