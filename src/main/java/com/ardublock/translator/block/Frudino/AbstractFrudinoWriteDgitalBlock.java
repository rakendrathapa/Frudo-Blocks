/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ardublock.translator.block.Frudino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import com.ardublock.translator.block.tinker.TinkerOutputPortBlock;

/**
 *
  @author Expression Raken is undefined on line 12, column 13 in Templates/Classes/Class.java.
 */

public abstract class AbstractFrudinoWriteDgitalBlock extends TranslatorBlock
{
    public static final String FRUGALBLOCK_DIGITAL_WRITE_DEFINE = "void __frugalblockDigitalWrite(int pinNumber, boolean status)\n{\npinMode(pinNumber, OUTPUT);\ndigitalWrite(pinNumber, status);\n}\n";
	
    AbstractFrudinoWriteDgitalBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
	super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    @Override
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException
    {
        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	String ret = "";
		
	if (translatorBlock instanceof NumberBlock || translatorBlock instanceof TinkerOutputPortBlock){
            String number = translatorBlock.toCode();
            String setupCode = "pinMode( " + number + " , OUTPUT);";
            translator.addSetupCommand(setupCode);
			
            ret = "digitalWrite( ";
            ret = ret + number;
	}
        else{
            translator.addDefinitionCommand(FRUGALBLOCK_DIGITAL_WRITE_DEFINE);
            ret = "__frugalblockDigitalWrite(";
            ret = ret + translatorBlock.toCode();
	}
		
	ret = ret + " , ";
	translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
        ret = ret + translatorBlock.toCode();
        ret = ret + " );\n";
	return ret;
    }
}