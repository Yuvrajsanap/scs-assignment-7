package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class question17 {
	public static void main(String[] args) {

		JFrame frame = new JFrame("JOptionPane Demo");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		JButton messageButton = new JButton("Show Message Dialog");
		messageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "This is a message dialog.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton inputButton = new JButton("Show Input Dialog");
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(frame, "Enter some text:", "Input Dialog",
						JOptionPane.PLAIN_MESSAGE);
				if (input != null) {
					JOptionPane.showMessageDialog(frame, "You entered: " + input, "Input Received",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		JButton confirmationButton = new JButton("Show Confirmation Dialog");
		confirmationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frame, "Do you confirm this action?",
						"Confirmation Dialog", JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(frame, "You selected: Yes", "Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (response == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(frame, "You selected: No", "Confirmation",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		frame.add(messageButton);
		frame.add(inputButton);
		frame.add(confirmationButton);

		frame.setVisible(true);
	}
}
