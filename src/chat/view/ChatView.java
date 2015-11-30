package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * pops up GUI.
 * @author talm8994
 *
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	private ImageIcon sansIcon;
	private ImageIcon papyIcon;
	private ImageIcon pearlIcon;
	private ImageIcon jakeIcon;
	public ChatView()
	{
		windowMessage = ("this is chatbot");
		papyIcon = new ImageIcon(getClass().getResource("images/papyras.jpg"));
		chatIcon = new ImageIcon(getClass().getResource("images/megaman_icon.png"));
		sansIcon = new ImageIcon(getClass().getResource("images/sans.png"));
		pearlIcon = new ImageIcon(getClass().getResource("images/pearl.jpeg"));
		jakeIcon = new ImageIcon(getClass().getResource("images/jake.png"));
	}
	
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, displayMessage, windowMessage, JOptionPane.INFORMATION_MESSAGE, RandomIcon(), null, "Type here please!") + "";
				
	    return answer;
	}
	public void display(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage, windowMessage, JOptionPane.PLAIN_MESSAGE, RandomIcon());
	}
	
	private ImageIcon RandomIcon()
	{
		int RandomIcon = (int) (Math.random() * 5);
		
		switch(RandomIcon)
		{
		case 0:
			return papyIcon;
		case 1:
			return sansIcon;
		case 2: 
			return chatIcon;
		case 3:
			return pearlIcon;
		case 4:
			return jakeIcon;
		default:
			return chatIcon;
			
		}
		
	}
}
