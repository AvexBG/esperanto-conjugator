package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameClass extends JFrame implements ActionListener {

	JLabel wordLabel;
	JTextField wordTextField;
	JTextArea outputTextArea;
	
	JButton presentButton;
	JButton pastButton;
	JButton futureButton;
	JButton conditionalButton;
	JButton volitiveButton;
	
	FrameClass() {
		JPanel textFieldPanel;
		JPanel outputPanel;
//		JPanel presentTensePanel;
//		JPanel pastTensePanel;
//		JPanel futureTensePanel;
		JPanel buttonPanel;
		
		wordLabel = new JLabel("Infinitive Verb: ");
		wordLabel.setFont(wordLabel.getFont().deriveFont(40.0f));
		
		wordTextField = new JTextField(20);
		Font newTextFieldFont = new Font(wordTextField.getFont().getName(), wordTextField.getFont().getStyle(), 30);
		wordTextField.setFont(newTextFieldFont);
		
		outputTextArea = new JTextArea();
		outputTextArea.setFont(newTextFieldFont);

		
		// setting up buttons
		presentButton = new JButton("Present Tense");
		presentButton.setActionCommand("PRESENT");
		presentButton.addActionListener(this);
		
		pastButton = new JButton("Past Tense");
		pastButton.setActionCommand("PAST");
		pastButton.addActionListener(this);
		
		futureButton = new JButton("Future Tense");
		futureButton.setActionCommand("FUTURE");
		futureButton.addActionListener(this);
		
		conditionalButton = new JButton("Conditional Tense");
		conditionalButton.setActionCommand("CONDITIONAL");
		conditionalButton.addActionListener(this);
		
		volitiveButton = new JButton("Volitive Button");
		volitiveButton.setActionCommand("VOLITIVE");
		volitiveButton.addActionListener(this);
		// ---------------------------------------------------------
		
		textFieldPanel = new JPanel();
		textFieldPanel.add(wordLabel);
		textFieldPanel.add(wordTextField);
		
		outputPanel = new JPanel();
		outputPanel.add(outputTextArea);
		
		buttonPanel = new JPanel();
		buttonPanel.add(presentButton);
		buttonPanel.add(pastButton);
		buttonPanel.add(futureButton);
		buttonPanel.add(conditionalButton);
		buttonPanel.add(volitiveButton);
		
		add(textFieldPanel, BorderLayout.NORTH);
//		add(outputPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setupMainFrame();
	}
	
	void setupMainFrame() {
		
		setTitle("Conjugator");
		setSize(900, 600);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("PRESENT")) {
			
			processText(1);
		}
		else if (e.getActionCommand().equals("PAST")) {
			
			processText(2);
		}	
		else if (e.getActionCommand().equals("FUTURE")) {
			
			processText(3);
		}
		else if (e.getActionCommand().equals("CONDITIONAL")) {
			
			processText(4);
		}
		else if (e.getActionCommand().equals("VOLITIVE")) {
			
			processText(5);
		}
	}

	private void processText(int x) {

		if (wordTextField.getText().equals("")) {
			
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			
			switch(x) {
				case 1:
					System.out.println("---Present Tense---");
					String presentSuffix = "as";
					conjugate(word, presentSuffix);
					break;
				case 2:
					System.out.println("---Past Tense---");
					String pastSuffix = "is";
					conjugate(word, pastSuffix);
					break;
				case 3:
					System.out.println("---Future Tense---");
					String futureSuffix = "os";
					conjugate(word, futureSuffix);
					break;
				case 4:
					System.out.println("---Conditional Tense---");
					String conditionalSuffix = "us";
					conjugate(word, conditionalSuffix);
					break;
				case 5:
					System.out.println("---Volitive Tense---");
					String volitiveSuffix = "u";
					conjugate(word, volitiveSuffix);
					break;
				default:
					break;
			}
		}
	}

	private void conjugate(String word, String suffix) {
			
		removeLastChar(word);
			
		String newWord = removeLastChar(word).concat(suffix);

		System.out.println("Infinitive: " + word);
		System.out.println("Conjugated: " + newWord + "\n");
	}

	
	private String removeLastChar(String word) {

		return removeLastChars(word, 1);
	}
	
	private String removeLastChars(String word, int chars) {
		
		return word.substring(0, word.length() - chars);
	}
}
