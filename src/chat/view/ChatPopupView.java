package chat.view;

import javax.swing.JOptionPane;
/**
 * pops up GUI.
 * @author talm8994
 *
 */
public class ChatPopupView
{
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
