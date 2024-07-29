package swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class question15 {
	public static void main(String[] args) {
		// Create the main frame
		JFrame frame = new JFrame("JList and JLabel Demo");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Create a JList with items
		String[] items = { "Item 1", "Item 2", "Item 3", "Item 4" };
		JList<String> list = new JList<>(items);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Create a JLabel
		JLabel label = new JLabel("Select an item from the list");
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setHorizontalAlignment(JLabel.CENTER);

		// Add ListSelectionListener to JList
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					String selectedItem = list.getSelectedValue();
					label.setText("Selected Item: " + selectedItem);
				}
			}
		});

		// Add components to the frame
		frame.add(new JScrollPane(list), BorderLayout.CENTER);
		frame.add(label, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
