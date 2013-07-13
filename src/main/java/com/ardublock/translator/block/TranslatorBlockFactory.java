package com.ardublock.translator.block;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.ardublock.translator.Translator;
import com.ardublock.util.PropertiesReader;

public class TranslatorBlockFactory
{
	private static final String BLOCK_MAPPING = "com/ardublock/block/block-mapping.properties";
	
	private Map<String, String> shortClassName;
	
	public TranslatorBlockFactory()
	{
		shortClassName = new HashMap<String, String>();
		shortClassName.put("analogInput", "com.ardublock.translator.block.AnalogInputBlock");
		shortClassName.put("digitalInput", "com.ardublock.translator.block.DigitalInputBlock");
		shortClassName.put("analogOutput", "com.ardublock.translator.block.AnalogOutputBlock");
		shortClassName.put("digitalOutput", "com.ardublock.translator.block.DigitalOutputBlock");
		shortClassName.put("inversedDigitalInput", "com.ardublock.translator.block.InversedDigitalInputBlock");
		shortClassName.put("inversedDigitalOutput", "com.ardublock.translator.block.InversedDigitalOutputBlock");
		shortClassName.put("inversedAnalogOutput", "com.ardublock.translator.block.InversedAnalogOutputBlock");
                shortClassName.put("servo", "com.ardublock.translator.block.ServoBlock");
                shortClassName.put("Frudino_Sensor", "com.ardublock.translator.block.Frudino.FrudinoSensorBlock");       //Raken Comment : Introduced for Frudino Libraries
                shortClassName.put("Input_A", "com.ardublock.translator.block.Frudino.FrudinoSensorInputBlock");     //Raken Comment : Input PIN for our Analog SENSOR.
                shortClassName.put("Frudino_Motor", "com.ardublock.translator.block.Frudino.FrudinoMotorBlock");    //Raken Comment: Output of the Frudino Motor
                shortClassName.put("Frudino_LED", "com.ardublock.translator.block.Frudino.FrudinoLEDBlock");    //Raken Comment: Connect LED - By default - Pin 13
                shortClassName.put("Frudino_Buzzer","com.ardublock.translator.block.Frudino.FrudinoLEDBlock");            //Raken Comment: Connect Buzzer - By default - Pin 14   
                shortClassName.put("TestBlock","com.ardublock.translator.block.Frudino.FrudinoTestBlock");           //Raken Comment : Out Test Block - Can experiment here ..!!
	}
	
	
	public TranslatorBlock buildTranslatorBlock(Translator translator, Long blockId, String blockName, String codePrefix, String codeSuffix, String label)
	{
//		System.out.println("block name : " + blockName + " captured");
		
		String className = PropertiesReader.getValue(blockName, BLOCK_MAPPING);
		//System.out.println("className: " + className);
		String longName = shortClassName.get(className);
		if (longName != null)
		{
			className = longName;
		}
		
		try
		{
			Class blockClass = Class.forName(className);
			Constructor constructor = blockClass.getConstructor(Long.class, Translator.class, String.class, String.class, String.class);
			TranslatorBlock ret = (TranslatorBlock)constructor.newInstance(blockId, translator, codePrefix, codeSuffix, label);
			return ret;
		}
		catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println(blockName + " not suitable class!");
		}		

		System.err.println(blockName + " not found!");
		
		return null;
	}
}
