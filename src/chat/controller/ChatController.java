/**
 * this controlles it all 
 */

package chat.controller;

import chat.view.ChatView;
import chat.model.*;
import chat.view.*;
import static org.junit.Assert.*;

public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	private CTECTwitter myTwitter;

	public ChatController()
	{
		myTwitter = new CTECTwitter(this);
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
			if (simpleBot.quitChecker(conversation))
			{
				shutDown();
			}
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
		public void sendTweet(String tweet)
		{
			myTwitter.sendTweet(tweet);
		}
		
		public String analyze(String userName)
		{
			String userAnalysis = "The Twitter user " + userName + "has...";
			
			return userAnalysis;
		}
		
		public void handleErrors(String error)
		{
			display.display(error);
		}
		
		public String sampleInvestigate()
		{
			return myTwitter.sampleInvestigation();
		}
		
}
