package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class question24 extends JFrame {
	public question24() {

		setTitle("Custom Look and Feel Demo");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// combo box for selecting look and feel
		String[] lookAndFeelOptions = { "Metal", "Nimbus", "Windows", "Windows Classic" };
		JComboBox<String> lookAndFeelComboBox = new JComboBox<>(lookAndFeelOptions);

		// action listener to change the look and feel
		lookAndFeelComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedLookAndFeel = (String) lookAndFeelComboBox.getSelectedItem();
				switch (selectedLookAndFeel) {
				case "Metal":
					setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
					break;
				case "Nimbus":
					setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					break;
				case "Windows":
					setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					break;
				case "Windows Classic":
					setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
					break;
				default:
					break;
				}
			}
		});

		// label to display a message
		JLabel label = new JLabel("Select a Look and Feel from the ComboBox", SwingConstants.CENTER);

		// components to the frame
		add(lookAndFeelComboBox, BorderLayout.NORTH);
		add(label, BorderLayout.CENTER);
	}

	// Method to set the look and feel
	private void setLookAndFeel(String lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Create and display the frame
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question24 frame = new question24();
				frame.setVisible(true);
			}
		});
	}
}
