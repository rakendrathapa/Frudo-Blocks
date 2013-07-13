/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frugalblock.translator.block.Frudino;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.TranslatorBlock;
import com.frugalblock.translator.block.exception.SocketNullException;
import com.frugalblock.translator.block.exception.SubroutineNotDeclaredException;

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
