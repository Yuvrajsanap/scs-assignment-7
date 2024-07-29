package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class question25 extends JFrame {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel messageLabel;

	public question25() {
		// Setup the frame
		setTitle("Login Form");
		setSize(500, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		// Create and set up panels
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mainPanel.setBackground(new Color(60, 63, 65));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(43, 43, 43));

		// Create components
		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setForeground(new Color(187, 187, 187));

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setForeground(new Color(187, 187, 187));

		usernameField = new JTextField(20);
		usernameField.setBackground(new Color(69, 73, 74));
		usernameField.setForeground(new Color(187, 187, 187));
		usernameField.setCaretColor(new Color(187, 187, 187));
		usernameField.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187)));

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(new Color(187, 187, 187));

		passwordField = new JPasswordField(20);
		passwordField.setBackground(new Color(69, 73, 74));
		passwordField.setForeground(new Color(187, 187, 187));
		passwordField.setCaretColor(new Color(187, 187, 187));
		passwordField.setBorder(BorderFactory.createLineBorder(new Color(187, 187, 187)));

		JButton loginButton = new JButton("Login");
		loginButton.setBackground(new Color(98, 151, 85));
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusPainted(false);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBackground(new Color(204, 52, 52));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFocusPainted(false);

		messageLabel = new JLabel("", SwingConstants.CENTER);
		messageLabel.setForeground(new Color(255, 69, 0));

		// Add components to main panel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		mainPanel.add(titleLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		mainPanel.add(usernameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainPanel.add(usernameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		mainPanel.add(passwordLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainPanel.add(passwordField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		mainPanel.add(loginButton, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		mainPanel.add(cancelButton, gbc);

		// Add components to button panel
		buttonPanel.add(messageLabel);

		// Add panels to frame
		add(mainPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// Add action listeners
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateLogin();
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
	}

	private void validateLogin() {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());

		if (username.isEmpty() || password.isEmpty()) {
			messageLabel.setText("Username and Password cannot be empty");
		} else {
			messageLabel.setText("Login successful!"); // Replace with actual validation logic
		}
	}

	private void clearFields() {
		usernameField.setText("");
		passwordField.setText("");
		messageLabel.setText("");
	}

	public static void main(String[] args) {
		// Create and display the frame
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question25 frame = new question25();
				frame.setVisible(true);
			}
		});
	}
}
