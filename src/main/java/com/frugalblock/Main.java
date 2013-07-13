package com.frugalblock;

import com.frugalblock.core.Context;
import com.frugalblock.ui.ConsoleFrame;
import com.frugalblock.ui.OpenblocksFrame;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Main
{
	public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException
	{
		Main me = new Main();
		me.startArdublock();
	}
	
	public void startArdublock() throws SAXException, IOException, ParserConfigurationException
	{
		startOpenblocksFrame();
		//startConsoleFrame();
	}
	
	private void startOpenblocksFrame() throws SAXException, IOException, ParserConfigurationException
	{
		
		OpenblocksFrame openblocksFrame;
                openblocksFrame = new OpenblocksFrame();
		openblocksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Normal closing the GUI : TODO : Nothing
		Context context = Context.getContext();
		context.setInArduino(false);
		openblocksFrame.setVisible(true);
	}
	
	private void startConsoleFrame()
	{
		ConsoleFrame consoleFrame = new ConsoleFrame();
		consoleFrame.setVisible(true);
	}
}
