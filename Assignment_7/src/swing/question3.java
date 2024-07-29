package swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// Model class
class Model {
	// Method to calculate the square of a number
	public int calculateSquare(int number) {
		return number * number;
	}
}

// View class
class View {
	private JFrame frame;
	private JTextField inputField;
	private JLabel resultLabel;
	private JButton calculateButton;

	public View(String title) {

		frame = new JFrame(title);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 1));

		inputField = new JTextField();

		resultLabel = new JLabel("Result will be shown here");
		resultLabel.setOpaque(true);
		resultLabel.setBackground(Color.MAGENTA);
		resultLabel.setForeground(Color.WHITE);

		calculateButton = new JButton("Calculate Square");
		calculateButton.setBackground(Color.YELLOW);
		calculateButton.setForeground(Color.BLUE);

		frame.add(inputField);
		frame.add(calculateButton);
		frame.add(resultLabel);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public String getInput() {
		return inputField.getText();
	}

	public void setResult(String result) {
		resultLabel.setText(result);
	}

	public void addCalculateListener(ActionListener listener) {
		calculateButton.addActionListener(listener);
	}
}

// Controller class
class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		// Add action listener to the view's calculate button
		this.view.addCalculateListener(new CalculateListener());
	}

	class CalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int number = Integer.parseInt(view.getInput());
				int result = model.calculateSquare(number);
				view.setResult("Square: " + result);
			} catch (NumberFormatException ex) {
				view.setResult("Invalid input. Please enter a number.");
			}
		}
	}
}

// Main class
public class question3 {
	public static void main(String[] args) {
		// Create the model, view, and controller
		Model model = new Model();
		View view = new View("MVC Example");
		Controller controller = new Controller(model, view);

		// Make the view visible
		view.setVisible(true);
	}
}
