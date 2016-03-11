package chat.model;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import chat.controller.ChatController;

public class CTECTwitter
{
		private ArrayList <Status> statusList;
		private ArrayList <String> wordsList;
		private Twitter chatbotTwitter;
		private ChatController baseController;
		
		public CTECTwitter(ChatController baseController)
		{
			this.baseController = baseController;
			this.statusList = new ArrayList<Status>();
			this.wordsList = new ArrayList<String>();
			this.chatbotTwitter = TwitterFactory.getSingleton();
		}
		
		public void sendTweet(String message)
		{
			try
			{
				chatbotTwitter.updateStatus(message);
			}
			catch(TwitterException error)
			{
				baseController.handleErrors(error.getErrorMessage());
			}
		}
		public void loadTweets(String twitterHandle) throws TwitterException
		{
			Paging statusPage = new Paging(1, 200);
			int page = 1;
			while (page <= 10)
			{
				statusPage.setPage(page);
				statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
				page++;
			}
			for (Status currentStatus : statusList)
			{
				String[] tweetText = currentStatus.getText().split(" ");
				for (String word : tweetText)
				{
					wordsList.add(removePunctuation(word).toLowerCase());
				}
			}
			removeCommonEnglishWords(wordsList);
			removeEmptyText();
		}
		
		private List removeCommonEnglishWords(List<String> wordList)
		{
			return null;
		}
		
		private String removePunctuation(String currentString)
		{
			return null;
		}
		private void removeEmptyText()
		{
			
		}
}
