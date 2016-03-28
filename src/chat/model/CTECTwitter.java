package chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
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
			statusList.clear();
			wordsList.clear();
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
			String[] boringWords =  importWordsToArray();
			
			for(int count = 0; count < wordsList.size(); count++)
			{
				for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
				{
					 if(wordsList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
					 {
						 wordsList.remove(count);
						 count--;
						 removeSpot = boringWords.length;
						 
					 }
				}
			}
			
			return null;
		}
		
		private String removePunctuation(String currentString)
		{
			String punctuation = ",.'?\"(){}^[]<>-";
			
			String scrubbedString = "";
			for(int i = 0; i < currentString.length(); i++)
			{
				if(punctuation.indexOf(currentString.charAt(i)) == -1)
				{
					scrubbedString += currentString.charAt(i);
				}
			}
			return scrubbedString;
		}
		private void removeEmptyText()
		{
			for(int spot = 0; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(spot).equals(""))
				{
					wordsList.remove(spot);
					spot--;
				}
			}
			
		}
		public String sampleInvestigation()
		{
			String results = "";
			
			Query query = new Query("drugs");
			query.setCount(100);
			query.setGeoCode(new GeoLocation(40.4123523, -243295.23423), 5, Query.MILES);
			query.setSince("2016-1-1");
			try
			{
				QueryResult result = chatbotTwitter.search(query);
				results += ("Count : " + result.getTweets().size());
				for(Status tweet : result.getTweets())
				{
					results += ("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
				}
			}
			
			catch(TwitterException error)
			{
			error.printStackTrace();
			}
			return results;
		}
		private String[] importWordsToArray()
		{
			String[] boringWords;
			int wordCount = 0;
			
			Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			
			wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
			
			return boringWords;
		}
}
