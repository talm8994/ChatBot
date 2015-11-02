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
			String conversation = display.getAnswer("What would you like to talk about today");
			while(simpleBot.lengthChecker(conversation))
			{
				
				if(simpleBot.contentChecker(conversation))
				{
					display.display("Wow, i had no idea you loved " + simpleBot.getContent());
				}
				if(simpleBot.memeChecker(conversation))
				{
					display.display("dang thats a dank meme" + simpleBot.getContent());
				}
				conversation = display.getAnswer("what is " + conversation );
			}
		}
}
