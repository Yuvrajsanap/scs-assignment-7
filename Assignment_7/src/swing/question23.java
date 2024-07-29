package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class question23 {
	public static void main(String[] args) {
		// the main frame
		JFrame frame = new JFrame("Look and Feel Demo");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// panel for buttons
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		// buttons to change look and feel
		JButton metalButton = new JButton("Metal Look and Feel");
		JButton nimbusButton = new JButton("Nimbus Look and Feel");
		JButton windowsButton = new JButton("Windows Look and Feel");

		// action listeners to the buttons
		metalButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewWindow("javax.swing.plaf.metal.MetalLookAndFeel");
			}
		});

		nimbusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewWindow("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			}
		});

		windowsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createNewWindow("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		});

		// buttons to the panel
		panel.add(metalButton);
		panel.add(nimbusButton);
		panel.add(windowsButton);

		// the panel to the frame
		frame.add(panel, BorderLayout.CENTER);

		// frame visible
		frame.setVisible(true);
	}

	// Method to create a new window with the selected look and feel
	private static void createNewWindow(String lookAndFeel) {
		try {
			// Set the look and feel
			UIManager.setLookAndFeel(lookAndFeel);

			// Create a new frame
			JFrame newFrame = new JFrame("New Look and Feel Window");
			newFrame.setSize(400, 300);
			newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			newFrame.setLayout(new BorderLayout());

			// Add a label to the new frame
			JLabel label = new JLabel("This is a new window with " + lookAndFeel, SwingConstants.CENTER);
			newFrame.add(label, BorderLayout.CENTER);

			// Update the UI to apply the new look and feel
			SwingUtilities.updateComponentTreeUI(newFrame);

			// Make the new frame visible
			newFrame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
