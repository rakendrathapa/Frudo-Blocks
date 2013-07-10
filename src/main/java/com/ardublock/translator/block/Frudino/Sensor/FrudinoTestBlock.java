/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ardublock.translator.block.Frudino.Sensor;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

/**
 *
  @author Expression Raken is undefined on line 12, column 13 in Templates/Classes/Class.java.
 */

public class FrudinoTestBlock extends TranslatorBlock{
    
    public FrudinoTestBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
        String testCode = "TestCode here..!!!";
        return codePrefix + testCode + codeSuffix;
    }

}
