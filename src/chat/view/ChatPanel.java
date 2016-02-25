/**
 * this is where the gui is 
 */

package chat.view;

import chat.controller.ChatController;

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
		
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	private void setupChatPane()
	{
		outputField.setLineWrap(true);
		outputField.setWrapStyleWord(true);
		outputField.setEditable(false);
		outputField.setEditable(false);
		textPane = new JScrollPane(outputField);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		JButton btnNewButton = new JButton("social");
		baseLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, btnNewButton, -25, SpringLayout.WEST, submitButton);
		add(btnNewButton);
		
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
		
	}
	
	public JTextField getTextField()
	{
		return inputField;
	}
}
