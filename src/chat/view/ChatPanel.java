/**
 * this is where the gui is 
 */

package chat.view;

import chat.controller.ChatController;
import chat.controller.IOController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JScrollPane textPane;
	private JButton submitButton;
	private JTextField inputField;
	private JTextArea outputField;
	private SpringLayout baseLayout;
	private JLabel label;
	private JButton socialButton;
	private JButton tweetButton;
	private JButton investigateButton;
	private JButton saveButton;
	private JButton loadButton;
	private JLabel promptButton;
	
	public ChatPanel(ChatController baseController)
	{
		
		setBackground(Color.BLUE);
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("submit");
		inputField = new JTextField("type crap");
		outputField = new JTextArea("type here");
		label = new JLabel("hello");
		outputField = new JTextArea(10,25);
		socialButton = new JButton("social");
		tweetButton = new JButton("Tweet");
		investigateButton = new JButton("Investigate");
		baseLayout.putConstraint(SpringLayout.NORTH, investigateButton, 9, SpringLayout.SOUTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, investigateButton, 100, SpringLayout.EAST, label);
		baseLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -6, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -156, SpringLayout.EAST, this);
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	private void setupChatPane()
	{
		outputField.setLineWrap(true);
		outputField.setWrapStyleWord(true);
		outputField.setEnabled(false);
		outputField.setEditable(false);
		textPane = new JScrollPane(outputField);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 48, SpringLayout.WEST, this);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(inputField);
		this.add(label);
		this.add(tweetButton);
		this.add(investigateButton);
		inputField.setToolTipText("Type here fro chat bot");
		outputField.setEnabled(false);
		JButton btnNewButton = new JButton("social");
		baseLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, btnNewButton, -25, SpringLayout.WEST, submitButton);
		add(btnNewButton);
		this.add(textPane);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, outputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -6, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 210, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 102, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputField, -97, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -88, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, outputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, outputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 15, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, outputField, -16, SpringLayout.EAST, this);
		outputField.setBackground(Color.WHITE);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String response = baseController.fromUserToChatBot(userText);
				outputField.append("\nUser: " + userText);
				outputField.append("\nChatbot: " + response);
				inputField.setText("");
			}
		});
		
		socialButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = inputField.getText();
				String results = baseController.analyze(user);
				outputField.setText(results);
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet(inputField.getText());
			}
		});
		
		investigateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String results = baseController.sampleInvestigate();
				outputField.setText(results);
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String file = IOController.saveFile(inputField.getText());
				label.setText(file);
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(label.getText());
			}
		});
	}
	
	public JTextField getTextField()
	{
		return inputField;
	}
}
