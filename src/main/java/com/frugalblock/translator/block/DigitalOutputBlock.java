package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.exception.SocketNullException;
import com.frugalblock.translator.block.exception.SubroutineNotDeclaredException;

public class DigitalOutputBlock extends TranslatorBlock
{
	public static final String ARDUBLOCK_DIGITAL_WRITE_DEFINE = "void __ardublockDigitalWrite(int pinNumber, boolean status)\n{\npinMode(pinNumber, OUTPUT);\ndigitalWrite(pinNumber, status);\n}\n";
	
	public DigitalOutputBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		if (translatorBlock instanceof NumberBlock)
		{
			String number = translatorBlock.toCode();
			String setupCode = "pinMode( " + number + " , OUTPUT);";
			translator.addSetupCommand(setupCode);
			
			String ret = "digitalWrite( ";
			ret = ret + number;
			ret = ret + " , ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			ret = ret + translatorBlock.toCode();
			ret = ret + " );\n";
			return ret;
		}
		else
		{
			translator.addDefinitionCommand(ARDUBLOCK_DIGITAL_WRITE_DEFINE);
			String ret = "__ardublockDigitalWrite(";
			
			ret = ret + translatorBlock.toCode();
			ret = ret + ", ";
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			ret = ret + translatorBlock.toCode();
			ret = ret + ");\n";
			return ret;
		}
		
	}

}
