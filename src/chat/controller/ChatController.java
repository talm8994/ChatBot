package chat.controller;

import chat.view.ChatPopupView;
import chat.model.Chatbot;
import chat.view.*;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatPopupView display;
	private ChatFrame baseFrame;

	public ChatController()
	{
		display = new ChatPopupView();
		String user = display.getAnswer("What is your name");
		simpleBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
		
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
				else if(simpleBot.memeChecker(conversation))
				{
					display.display("dang thats a dank meme");
				}
				conversation = display.getAnswer("what is " + conversation );
			}
		}
}
