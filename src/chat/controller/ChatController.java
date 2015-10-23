package chat.controller;

import chat.view.ChatPopupView;
import chat.model.Chatbot;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatPopupView display;

	public ChatController()
	{
		display = new ChatPopupView();
		String user = display.getAnswer("What is your name");
		simpleBot = new Chatbot(user);
	}
	
	public void start()
	{
		display.display("hello " + simpleBot.getUserName());
		chat();
		
	}
	
		private void chat()
		{
			String textFromUser = display.getAnswer("Talk to chatbot");
			while(simpleBot.lengthChecker(textFromUser))
			{
				textFromUser = display.getAnswer("wow " + textFromUser);
			}
		}
	
}
