package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Thomas Almeida
 * @version 1.2 10/28/15 Build new stuff and things.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> keyBoardMasher;
	private String userName;
	private String content;
	private String Maincontent;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;	
		this.content ="csgo";
		
		buildMemesList();
		buildPoliticalTopicsList();
		buildKeyboardMasherChecker();
	}
	
	private void buildMemesList()
	{
		this.memesList.add("adames face");
		this.memesList.add("doge");
		this.memesList.add("PEPE");
		this.memesList.add("illuminati");
		this.memesList.add("MLG");
		this.memesList.add("dezzz nuts");
		this.memesList.add("your mom");
		this.memesList.add("trevors face");
		this.memesList.add("meme");
		this.memesList.add("yee");
	}
	
	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("democrat");
		this.politicalTopicList.add("republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Trump");
		this.politicalTopicList.add("Clinton");
		this.politicalTopicList.add("Biden");
		this.politicalTopicList.add("Carson");
		this.politicalTopicList.add("Rubio");
		this.politicalTopicList.add("Fiorina");
		this.politicalTopicList.add("Sanders");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/8/2016");
		
	}
	
	private void buildKeyboardMasher()
	{
		this.keyboardMashCheker.add("sdf");
		this.keyboardMashCheker.add("dfg");
		this.keyboardMashCheker.add("cvb");
		this.keyboardMashCheker.add(",./");
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				hasLength = true; 
			}
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent= true;
		}
		
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitical = false;
		for(String politicalTopicsList : politicalTopicList)
		{
			if(currentInput.toLowerCase().contains(politicalTopicsList.toLowerCase()))
			{
				hasPolitical = true;
			}
				
		}
		return hasPolitical;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean isMeme = false;
		
		for(String meme : memesList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				isMeme = true;
			}
		}
		
		return isMeme;
	}
	
	
	
	public String processConversation(String currentInput)
	{
		String nextConversation = "oh, what else would you like to talk about?";
		int randomTopic = (int) (Math.random() * 5);
		
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "hey you talked about my special topic, thats neat! Wha else do you like?";
			}
			break;
		case 1:
			if (memeChecker(currentInput))
			{
				nextConversation = "That is a popular meme this year! wow! what is your favorite food?";
			}
			break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				
			}
			break;
		case 3:
			if (currentInput.length() > 23)
			{
				nextConversation = "";
			}
			break;
		case 4:
			nextConversation = "haha wow no way thats super cool also do you love cats";
			break;
		case 5:
			nextConversation = "";
			break;
		case 6:
			nextConversation = "";
			break;
		}
		
		return nextConversation;
		
	}
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return null;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}



