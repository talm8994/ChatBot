package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * pops up GUI.
 * @author talm8994
 *
 */
public class ChatPopupView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatPopupView()
	{
		windowMessage = ("this is chatbot");
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}
	
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, displayMessage);
				
	    return answer;
	}
	public void display(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage);
	}
}
