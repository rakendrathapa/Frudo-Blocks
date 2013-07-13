/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ardublock.translator.block.Frudino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
	



/**
 *
  @author Expression Raken is undefined on line 12, column 13 in Templates/Classes/Class.java.
 */

public class FrudinoMotorBlock extends TranslatorBlock{
    public static final String FRUDOBLOCK_MOTOR_WRITE = "void __frudoblockMotorWrite(int pinNumber, boolean status)\n{\npinMode(pinNumber, OUTPUT);\ndigitalWrite(pinNumber, status);\n}\n";
    
    public FrudinoMotorBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
    {
        super(blockId, translator, codePrefix, codeSuffix, label);
    }

    public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
        String motorName = null;
        String headerStr = null;
        if(label.equals("Motor1_dir_0")){
                motorName = "Motor_1_0";
                headerStr = "int "+motorName+"=10;";
        }
        else if(label.equals("Motor1_dir_1")){
                motorName = "Motor_1_1";
                headerStr = "int "+motorName+"=11;\n";
        }
        else if(label.equals("Motor2_dir_0")){
            motorName = "Motor_2_0";
            headerStr = "int "+motorName+"=8;\n";
        }
        else if(label.equals("Motor2_dir_1")){
            motorName = "Motor_2_1";
            headerStr = "int "+motorName+"=9;\n";
        }
        else if(label.equals("Motor3_dir_0")){
            motorName = "Motor_3_0";
            headerStr = "int "+motorName+"=6;\n";
        }
        else if(label.equals("Motor3_dir_1")){
            motorName = "Motor_3_1";
            headerStr = "int "+motorName+"=7;\n";
        }
        else if(label.equals("Motor4_dir_0")){
            motorName = "Motor_4_0";
            headerStr = "int "+motorName+"=4;\n";
        }
        else if(label.equals("Motor4_dir_1")){
            motorName = "Motor_4_1";
            headerStr = "int "+motorName+"=5;\n";
        }
        
        
        String setupCode = "pinMode("+motorName+", OUTPUT);\n";
        translator.addDefinitionCommand(headerStr);
        translator.addSetupCommand(setupCode);
        
        String ret = "digitalWrite( ";
        ret = ret + motorName;
        ret = ret + " , ";
	TranslatorBlock translatorBlock;
        translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	ret = ret + translatorBlock.toCode();
	ret = ret + " );\n";
	return ret;
    }
}