package com.frugalblock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import processing.app.Editor;
import com.frugalblock.core.Context;

import processing.app.tools.Tool;

import com.frugalblock.ui.FrugalBlockToolFrame;
import com.frugalblock.ui.listener.OpenblocksFrameListener;

public class FrugalBlockTool implements Tool, OpenblocksFrameListener
{
	static Editor editor;
	static FrugalBlockToolFrame openblocksFrame;
	
	public void init(Editor editor) {
		if (FrugalBlockTool.editor == null )
		{
			FrugalBlockTool.editor = editor;
			FrugalBlockTool.openblocksFrame = new FrugalBlockToolFrame();
			FrugalBlockTool.openblocksFrame.addListener(this);
			Context context = Context.getContext();
			String arduinoVersion = this.getArduinoVersion();
			context.setInArduino(true);
			context.setArduinoVersionString(arduinoVersion);
			System.out.println("Arduino Version: " + arduinoVersion);
		}
	}

	public void run() {
		try {
			FrugalBlockTool.editor.toFront();
			FrugalBlockTool.openblocksFrame.setVisible(true);
			FrugalBlockTool.openblocksFrame.toFront();
		} catch (Exception e) {
			
		}
	}

	public String getMenuTitle() {
		return Context.APP_NAME;
	}

	public void didSave() {
		
	}
	
	public void didLoad() {
		
	}
	
	public void didGenerate(String source) {
		FrugalBlockTool.editor.setText(source);
		FrugalBlockTool.editor.handleExport(false);
	}
	
	
	private String getArduinoVersion()
	{
		Context context = Context.getContext();
		File versionFile = context.getArduinoFile("lib/version.txt");
		if (versionFile.exists())
		{
			try
			{
				InputStream is = new FileInputStream(versionFile);
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				String line = reader.readLine();
				if (line == null)
				{
					return Context.ARDUINO_VERSION_UNKNOWN;
				}
				line = line.trim();
				if (line.length() == 0)
				{
					return Context.ARDUINO_VERSION_UNKNOWN;
				}
				return line;
				
			}
			catch (FileNotFoundException e)
			{
				return Context.ARDUINO_VERSION_UNKNOWN;
			}
			catch (UnsupportedEncodingException e)
			{
				return Context.ARDUINO_VERSION_UNKNOWN;
			}
			catch (IOException e)
			{
				e.printStackTrace();
				return Context.ARDUINO_VERSION_UNKNOWN;
			}
		}
		else
		{
			return Context.ARDUINO_VERSION_UNKNOWN;
		}
		
	}
}