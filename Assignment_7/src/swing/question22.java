package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class question22 {
	public static void main(String[] args) {
		// main frame
		JFrame frame = new JFrame("JProgressBar Demo");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// panel for the progress bar and button
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// progress bar
		JProgressBar progressBar = new JProgressBar(0, 100);
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.BLUE);
		progressBar.setBackground(Color.WHITE);
		progressBar.setPreferredSize(new Dimension(500, 30));

		// start button
		JButton startButton = new JButton("Start Task");
		startButton.setPreferredSize(new Dimension(150, 30));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				// Start the long-running task in a separate thread
				new Thread(new Task(progressBar, startButton)).start();
			}
		});

		// components to the panel
		panel.add(progressBar, BorderLayout.CENTER);
		panel.add(startButton, BorderLayout.SOUTH);

		// Add panel to the frame
		frame.add(panel, BorderLayout.CENTER);

		frame.setVisible(true);
	}
}

//implements Runnable
class Task implements Runnable {
	private JProgressBar progressBar;
	private JButton startButton;

	public Task(JProgressBar progressBar, JButton startButton) {
		this.progressBar = progressBar;
		this.startButton = startButton;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			final int progress = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						progressBar.setValue(progress);
						progressBar.setString("Progress: " + progress + "%");
					}
				});
				Thread.sleep(50); // Simulate a long-running task
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				startButton.setEnabled(true);
				JOptionPane.showMessageDialog(progressBar, "Task Completed!");
			}
		});
	}
}
