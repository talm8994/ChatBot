package chat.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IOController
{
	public static String saveFile(String textToSave)
	{
		String fileName = "Saved ChatFile - ";
		fileName += Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		fileName += ":" + Calendar.getInstance().get(Calendar.MINUTE);
		fileName += ".txt";
		FileWriter chatWriter;
		try
		{
			chatWriter = new FileWriter(fileName);
			chatWriter.write("this is the " + fileName + "\n");
			chatWriter.write(textToSave);
			chatWriter.close();
			JOptionPane.showMessageDialog(null, "fileSaved as: " + fileName);
		}
		catch (IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		return fileName;
	}

	public static String readTextFromFile(String text)
	{
		String text1 = "";
		File chatTextFile = new File(text);
		Scanner chatScanner;
		try
		{
			chatScanner = new Scanner (chatTextFile);
			while(chatScanner.hasNext())
			{
				text1 += chatScanner.nextLine();
			}
			chatScanner.close();
			JOptionPane.showMessageDialog(null, text + "wasloaded to the chatFiled");
		}
		catch (IOException ioError)
		{
			JOptionPane.showMessageDialog(null, ioError.getMessage());
		}
		return text1;
	}
}
