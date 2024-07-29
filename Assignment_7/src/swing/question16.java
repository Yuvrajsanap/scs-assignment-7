package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class question16 {
	public static void main(String[] args) {

		JFrame frame = new JFrame("JTable Demo");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Name");
		tableModel.addColumn("Age");

		// Create a JTable with the table model
		JTable table = new JTable(tableModel);

		// Add some initial data
		tableModel.addRow(new Object[] { "1", "yuvraj", 20 });
		tableModel.addRow(new Object[] { "2", "aniket", 21 });
		tableModel.addRow(new Object[] { "3", "sanket", 22 });

		// Create the input fields and buttons
		JTextField idField = new JTextField(5);
		JTextField nameField = new JTextField(10);
		JTextField ageField = new JTextField(5);
		JButton addButton = new JButton("Add");
		JButton updateButton = new JButton("Update");
		JButton deleteButton = new JButton("Delete");

		// Panel for input fields and buttons
		JPanel inputPanel = new JPanel();
		inputPanel.add(new JLabel("ID:"));
		inputPanel.add(idField);
		inputPanel.add(new JLabel("Name:"));
		inputPanel.add(nameField);
		inputPanel.add(new JLabel("Age:"));
		inputPanel.add(ageField);
		inputPanel.add(addButton);
		inputPanel.add(updateButton);
		inputPanel.add(deleteButton);

		// Add action listeners for buttons
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String name = nameField.getText();
				String age = ageField.getText();
				if (!id.isEmpty() && !name.isEmpty() && !age.isEmpty()) {
					tableModel.addRow(new Object[] { id, name, age });
					idField.setText("");
					nameField.setText("");
					ageField.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String id = idField.getText();
					String name = nameField.getText();
					String age = ageField.getText();
					if (!id.isEmpty() && !name.isEmpty() && !age.isEmpty()) {
						tableModel.setValueAt(id, selectedRow, 0);
						tableModel.setValueAt(name, selectedRow, 1);
						tableModel.setValueAt(age, selectedRow, 2);
						idField.setText("");
						nameField.setText("");
						ageField.setText("");
					} else {
						JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a row to update", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					tableModel.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(frame, "Please select a row to delete", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Add a ListSelectionListener to update input fields when a row is selected
		table.getSelectionModel().addListSelectionListener(e -> {
			int selectedRow = table.getSelectedRow();
			if (selectedRow != -1) {
				idField.setText(tableModel.getValueAt(selectedRow, 0).toString());
				nameField.setText(tableModel.getValueAt(selectedRow, 1).toString());
				ageField.setText(tableModel.getValueAt(selectedRow, 2).toString());
			}
		});

		// Add components to the frame
		frame.add(new JScrollPane(table), BorderLayout.CENTER);
		frame.add(inputPanel, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);
	}
}
