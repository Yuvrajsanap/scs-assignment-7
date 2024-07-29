package swing;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class question13 extends JFrame implements ActionListener {
	// Components
	private JTextField display;
	private JButton[] numberButtons;
	private JButton[] functionButtons;
	private JButton addButton, subButton, mulButton, divButton;
	private JButton decButton, equButton, delButton, clrButton;
	private JPanel panel;

	// Variables
	private double num1 = 0, num2 = 0, result = 0;
	private char operator;
	private boolean isNewOperation = true;
	private int i;

	public question13() {
		// Frame properties
		setTitle("Calculator");
		setSize(420, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		// Display field
		display = new JTextField();
		display.setBounds(50, 25, 300, 50);
		display.setFont(new Font("Arial", Font.PLAIN, 30));
		display.setEditable(false);
		add(display);

		// Number buttons
		numberButtons = new JButton[10];
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 30));
			numberButtons[i].addActionListener(this);
		}

		// Function buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");

		functionButtons = new JButton[] { addButton, subButton, mulButton, divButton, decButton, equButton, delButton,
				clrButton };

		for (JButton button : functionButtons) {
			button.setFont(new Font("Arial", Font.PLAIN, 30));
			button.addActionListener(this);
		}

		// Panel for buttons
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));

		// Adding buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		add(panel);

		// Additional buttons
		delButton.setBounds(50, 430, 145, 50);
		clrButton.setBounds(205, 430, 145, 50);
		add(delButton);
		add(clrButton);
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				if (isNewOperation) {
					display.setText("");
					isNewOperation = false;
				}
				display.setText(display.getText().concat(String.valueOf(i)));
			}
		}

		if (e.getSource() == decButton) {
			if (isNewOperation) {
				display.setText("");
				isNewOperation = false;
			}
			if (!display.getText().contains(".")) {
				display.setText(display.getText().concat("."));
			}
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(display.getText());
			operator = '+';
			display.setText("");
		}

		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(display.getText());
			operator = '-';
			display.setText("");
		}

		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(display.getText());
			operator = '*';
			display.setText("");
		}

		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(display.getText());
			operator = '/';
			display.setText("");
		}

		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(display.getText());
			switch (operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					display.setText("Cannot divide by zero");
					return;
				}
				break;
			}
			display.setText(String.valueOf(result));
			num1 = result;
			isNewOperation = true;
		}

		if (e.getSource() == clrButton) {
			display.setText("");
		}

		if (e.getSource() == delButton) {
			String text = display.getText();
			if (!text.isEmpty()) {
				display.setText(text.substring(0, text.length() - 1));
			}
		}
	}

	public static void main(String[] args) {
		// Use invokeLater to ensure thread safety when creating the GUI
		SwingUtilities.invokeLater(() -> {
			question13 calculator = new question13();
			calculator.setVisible(true);
		});
	}
}