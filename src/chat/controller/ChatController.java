package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;
import chat.view.*;
import static org.junit.Assert.*;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;

	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name");
		simpleBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
		
	}
	
	public void start()
	{
		display.display("hello " + simpleBot.getUserName());
		//chat();
		
	}
	
		private void chat()
		{
			String conversation = display.getAnswer("What would you like to talk about today");
			while(simpleBot.lengthChecker(conversation))
			{
				conversation = simpleBot.processConversation(conversation);
				conversation = display.getAnswer(conversation);
			}
		}
		
		public String fromUserToChatBot(String conversation)
		{
			String botResponse = "";
			
			botResponse = simpleBot.processConversation(conversation);
			
			return botResponse;
		}
		
		public Chatbot getChatbot()
		{
			return simpleBot;
		}
		
		public ChatView getChatView()
		{
			return display;
		}
		
		public ChatFrame getBaseFrame()
		{
			return baseFrame;
		}
		
		private void shutDown()
		{
			display.display("bye " + simpleBot.getUserName() + "it has been my pleasure to talk with you");
			System.exit(0);
		}
		
}
