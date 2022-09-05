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
		
		wordLabel = new JLabel("Word");
		
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
			
			presentConjugate();
		}
		else if (e.getActionCommand().equals("PAST")) {
			
			pastConjugate();
		}	
		else if (e.getActionCommand().equals("FUTURE")) {
			
			futureConjugate();
		}
		else if (e.getActionCommand().equals("CONDITIONAL")) {
			
			conditionalConjugate();
		}
		else if (e.getActionCommand().equals("VOLITIVE")) {
			
			volitiveConjugate();
		}
	}

	private void presentConjugate() {
		
		if (wordTextField.getText().equals("")) {
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			String presentSuffix = "as";
			
			removeLastChar(word);
			
			String newWord = removeLastChar(word).concat(presentSuffix);

			System.out.println("---Present Tense---");
			System.out.println("Infinitive: " + word);
			System.out.println("Conjugated: " + newWord + "\n");
		}
	}
	
	private void pastConjugate() {
		
		if (wordTextField.getText().equals("")) {
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			String pastSuffix = "is";

			removeLastChar(word);
			
			String newWord = removeLastChar(word).concat(pastSuffix);
			
			System.out.println("---Past Tense---");
			System.out.println("Infinitive: " + word);
			System.out.println("Conjugated: " + newWord + "\n");
		}
	}
	
	private void futureConjugate() {

		if (wordTextField.getText().equals("")) {
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			String futureSuffix = "os";
			
			removeLastChar(word);
			
			String newWord = removeLastChar(word).concat(futureSuffix);
			
			System.out.println("---Future Tense---");
			System.out.println("Infinitive: " + word);
			System.out.println("Conjugated: " + newWord + "\n");
		}
	}

	private void conditionalConjugate() {
		
		if (wordTextField.getText().equals("")) {
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			String futureSuffix = "us";
			
			removeLastChar(word);
			
			String newWord = removeLastChar(word).concat(futureSuffix);
			
			System.out.println("---Conditional Tense---");
			System.out.println("Infinitive: " + word);
			System.out.println("Conjugated: " + newWord + "\n");
		}
	}
	
	private void volitiveConjugate() {
		
		if (wordTextField.getText().equals("")) {
			System.out.println("Empty! Please enter a verb in the infinitive form.");
		}
		else {
			String word = wordTextField.getText();
			String futureSuffix = "u";
			
			removeLastChar(word);
			
			String newWord = removeLastChar(word).concat(futureSuffix);
			
			System.out.println("---Volitive Tense---");
			System.out.println("Infinitive: " + word);
			System.out.println("Conjugated: " + newWord + "\n");
		}
	}
	
	private String removeLastChar(String word) {

		return removeLastChars(word, 1);
	}
	
	private String removeLastChars(String word, int chars) {
		
		return word.substring(0, word.length() - chars);
	}
}
