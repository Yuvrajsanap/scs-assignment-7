package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//UserManagementApp
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class question28 extends JFrame {
	private JTextField nameField, emailField;
	private JButton addButton, updateButton, deleteButton;
	private JTable table;
	private DefaultTableModel tableModel;

	private Connection connection;

	public question28() {
		// Set up the frame
		setTitle("User Management");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Initialize components
		nameField = new JTextField(15);
		emailField = new JTextField(15);
		addButton = new JButton("Add");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");

		tableModel = new DefaultTableModel(new String[] { "ID", "Name", "Email" }, 0);
		table = new JTable(tableModel);

		// Layout components
		JPanel inputPanel = new JPanel();
		inputPanel.add(new JLabel("Name:"));
		inputPanel.add(nameField);
		inputPanel.add(new JLabel("Email:"));
		inputPanel.add(emailField);
		inputPanel.add(addButton);
		inputPanel.add(updateButton);
		inputPanel.add(deleteButton);

		add(new JScrollPane(table), BorderLayout.CENTER);
		add(inputPanel, BorderLayout.SOUTH);

		// Add action listeners
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUser();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteUser();
			}
		});

		// Connect to the database and load data
		connectToDatabase();
		loadUserData();
	}

	private void connectToDatabase() {
		try {
			// Update the connection string to connect to MySQL
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Assignment7_db", "root",
					"Yuvraj@12345");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Failed to connect to the database", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void loadUserData() {
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM ass28")) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				tableModel.addRow(new Object[] { id, name, email });
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Failed to load user data", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void addUser() {
		String name = nameField.getText();
		String email = emailField.getText();

		if (name.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Name and Email fields cannot be empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO ass28 (name, email) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.executeUpdate();
			tableModel.addRow(new Object[] { getGeneratedId(stmt), name, email });
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Failed to add user", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private int getGeneratedId(PreparedStatement stmt) throws SQLException {
		try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new SQLException("Creating user failed, no ID obtained.");
			}
		}
	}

	private void updateUser() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "No user selected", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = (int) tableModel.getValueAt(selectedRow, 0);
		String name = nameField.getText();
		String email = emailField.getText();

		if (name.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Name and Email fields cannot be empty", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try (PreparedStatement stmt = connection
				.prepareStatement("UPDATE ass28 SET name = ?, email = ? WHERE id = ?")) {
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setInt(3, id);
			stmt.executeUpdate();
			tableModel.setValueAt(name, selectedRow, 1);
			tableModel.setValueAt(email, selectedRow, 2);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Failed to update user", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void deleteUser() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "No user selected", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = (int) tableModel.getValueAt(selectedRow, 0);

		try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM ass28 WHERE id = ?")) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			tableModel.removeRow(selectedRow);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Failed to delete user", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question28 app = new question28();
				app.getContentPane().setBackground(new Color(45, 45, 45));
				app.setVisible(true);
			}
		});
	}
}
