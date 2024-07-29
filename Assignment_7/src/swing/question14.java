package swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class question14 {
	public static void main(String[] args) {
		// Create the main frame
		JFrame frame = new JFrame("JComboBox and JTextArea Demo");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a JComboBox with items
		String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };
		JComboBox<String> comboBox = new JComboBox<>(items);

		// Create a JTextArea
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea.setEditable(false);

		// Add ActionListener to JComboBox
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				textArea.setText("Selected Item: " + selectedItem);
			}
		});

		// Add components to the frame
		frame.add(comboBox, BorderLayout.NORTH);
		frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

		// Make the frame visible
		frame.setVisible(true);
	}
}
