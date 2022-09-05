package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameClass extends JFrame implements ActionListener {

	JLabel wordLabel;
	JTextField wordTextField;
	
	JButton presentButton;
	JButton pastButton;
	JButton futureButton;
	JButton conditionalButton;
	JButton volitiveButton;
	
	FrameClass() {
		JPanel textFieldPanel;
//		JPanel presentTensePanel;
//		JPanel pastTensePanel;
//		JPanel futureTensePanel;
		JPanel buttonPanel;
		
		wordLabel = new JLabel("Infinitive Verb: ");
		
		wordTextField = new JTextField(20);
		
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
		
		buttonPanel = new JPanel();
		buttonPanel.add(presentButton);
		buttonPanel.add(pastButton);
		buttonPanel.add(futureButton);
		buttonPanel.add(conditionalButton);
		buttonPanel.add(volitiveButton);
		
		add(textFieldPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		setupMainFrame();
	}
	
	void setupMainFrame() {
		
		setTitle("Conjugator");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("PRESENT")) {
			
			if (wordTextField.getText().equals("")) {
				
				System.out.println("Empty! Please enter a verb in the infinitive form.");
			}
			else {
				String word = wordTextField.getText();
				String suffix = "as";
				
				System.out.println("---Present Tense---");

				
				conjugate(word, suffix);
			}
		}
		else if (e.getActionCommand().equals("PAST")) {
			
			if (wordTextField.getText().equals("")) {
				
				System.out.println("Empty! Please enter a verb in the infinitive form.");
			}
			else {
				String word = wordTextField.getText();
				String suffix = "is";
				
				System.out.println("---Past Tense---");

				
				conjugate(word, suffix);
			}
		}	
		else if (e.getActionCommand().equals("FUTURE")) {
			
			if (wordTextField.getText().equals("")) {
				
				System.out.println("Empty! Please enter a verb in the infinitive form.");
			}
			else {
				String word = wordTextField.getText();
				String suffix = "os";
				
				System.out.println("---Future Tense---");

				
				conjugate(word, suffix);
			}
		}
		else if (e.getActionCommand().equals("CONDITIONAL")) {
			
			if (wordTextField.getText().equals("")) {
				
				System.out.println("Empty! Please enter a verb in the infinitive form.");
			}
			else {
				String word = wordTextField.getText();
				String suffix = "us";
				
				System.out.println("---Conditional Tense---");
				
				conjugate(word, suffix);
			}
		}
		else if (e.getActionCommand().equals("VOLITIVE")) {
			
			if (wordTextField.getText().equals("")) {
				
				System.out.println("Empty! Please enter a verb in the infinitive form.");
			}
			else {
				String word = wordTextField.getText();
				String suffix = "u";
				
				System.out.println("---Volitive Tense---");

				
				conjugate(word, suffix);
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
