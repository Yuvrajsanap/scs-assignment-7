package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class question26 extends JFrame {
	private JTextArea textArea;
	private JFileChooser fileChooser;

	public question26() {
		// Set up the frame
		setTitle("File Editor");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create components
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea.setBackground(new Color(30, 30, 30)); // Dark background
		textArea.setForeground(new Color(230, 230, 230)); // Light text
		JScrollPane scrollPane = new JScrollPane(textArea);

		fileChooser = new JFileChooser();

		// Create menu bar
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");

		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		menuBar.add(fileMenu);

		setJMenuBar(menuBar);

		// components to the frame
		add(scrollPane, BorderLayout.CENTER);

		// action listeners
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});

		saveItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});

		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	private void openFile() {
		int returnValue = fileChooser.showOpenDialog(this);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String fileName = selectedFile.getName().toLowerCase();

			if (fileName.endsWith(".pdf")) {
				try {
					Desktop.getDesktop().open(selectedFile);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error opening PDF file", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
					textArea.read(reader, null);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void saveFile() {
		int returnValue = fileChooser.showSaveDialog(this);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
				textArea.write(writer);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question26 frame = new question26();
				frame.getContentPane().setBackground(new Color(45, 45, 45)); // Darker background for the frame
				frame.setVisible(true);
			}
		});
	}
}
