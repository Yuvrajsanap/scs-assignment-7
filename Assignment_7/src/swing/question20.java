package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class question20 {
	public static void main(String[] args) {
		// main frame
		JFrame frame = new JFrame("JTabbedPane Demo");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JTabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Tab 1: A panel with a label and a button
		JPanel tab1 = new JPanel();
		tab1.setLayout(new FlowLayout());
		tab1.add(new JLabel("This is Tab 1"));
		tab1.add(new JButton("Button in Tab 1"));

		// Tab 2: A panel with a text field and a button
		JPanel tab2 = new JPanel();
		tab2.setLayout(new FlowLayout());
		tab2.add(new JLabel("This is Tab 2"));
		tab2.add(new JTextField("TextField in Tab 2", 20));
		tab2.add(new JButton("Button in Tab 2"));

		// Tab 3: A panel with a text area and a scroll pane
		JPanel tab3 = new JPanel();
		tab3.setLayout(new BorderLayout());
		JTextArea textArea = new JTextArea("TextArea in Tab 3");
		JScrollPane scrollPane = new JScrollPane(textArea);
		tab3.add(scrollPane, BorderLayout.CENTER);

		// Add tabs to the tabbed pane
		tabbedPane.addTab("Tab 1", tab1);
		tabbedPane.addTab("Tab 2", tab2);
		tabbedPane.addTab("Tab 3", tab3);

		// Add the tabbed pane to the frame
		frame.add(tabbedPane);

		// Make the frame visible
		frame.setVisible(true);
	}
}
