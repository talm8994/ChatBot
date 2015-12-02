package chat.view;

import chat.controller.ChatController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton submitButton;
	private JTextField inputField;
	private JTextArea outputField;
	private SpringLayout baseLayout;
	private JLabel label;
	
	public ChatPanel(ChatController baseController)
	{
		setBackground(Color.BLUE);
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("submit");
		inputField = new JTextField("type crap");
		outputField = new JTextArea("type here");
		label = new JLabel("hello");
		baseLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, outputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, this);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(inputField);
		this.add(outputField);
		this.add(label);
		inputField.setToolTipText("Type here fro chat bot");
		outputField.setEnabled(false);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, outputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 162, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 275, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 95, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, -95, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, outputField, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, outputField, 15, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, outputField, -6, SpringLayout.NORTH, inputField);
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
		
	}
	
	public JTextField getTextField()
	{
		return inputField;
	}
}
