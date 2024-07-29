package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class question27 extends JFrame {
	private JTextArea textArea;
	private JTextField searchField;
	private JButton searchButton;

	public question27() {
		// Set up the frame
		setTitle("Text Editor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create components
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea.setBackground(new Color(30, 30, 30)); // Dark background
		textArea.setForeground(new Color(230, 230, 230)); // Light text
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Create menu bar
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu searchMenu = new JMenu("Search");

		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit");

		JMenuItem cutItem = new JMenuItem("Cut");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");

		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(searchMenu);

		setJMenuBar(menuBar);

		// Create search components
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new FlowLayout());
		searchField = new JTextField(20);
		searchButton = new JButton("Search");
		searchPanel.add(new JLabel("Search:"));
		searchPanel.add(searchField);
		searchPanel.add(searchButton);

		// Add components to the frame
		add(scrollPane, BorderLayout.CENTER);
		add(searchPanel, BorderLayout.SOUTH);

		// Add action listeners
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

		cutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.cut();
			}
		});

		copyItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.copy();
			}
		});

		pasteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.paste();
			}
		});

		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchInText();
			}
		});
	}

	private void openFile() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(this);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
				textArea.read(reader, null);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(this, "Error reading file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
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

	private void searchInText() {
		String searchText = searchField.getText();
		String textContent = textArea.getText();

		if (!searchText.isEmpty()) {
			int startIndex = textContent.indexOf(searchText);
			if (startIndex >= 0) {
				try {
					Highlighter highlighter = textArea.getHighlighter();
					Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
					highlighter.removeAllHighlights();
					highlighter.addHighlight(startIndex, startIndex + searchText.length(), painter);
				} catch (BadLocationException ex) {
					JOptionPane.showMessageDialog(this, "Error highlighting text", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Text not found", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				question27 frame = new question27();
				frame.getContentPane().setBackground(new Color(45, 45, 45)); // Darker background for the frame
				frame.setVisible(true);
			}
		});
	}
}
