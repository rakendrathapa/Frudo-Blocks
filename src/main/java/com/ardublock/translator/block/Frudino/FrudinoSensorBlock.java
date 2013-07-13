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

public class FrudinoSensorBlock extends TranslatorBlock{
    public FrudinoSensorBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label){
        super(blockId, translator, codePrefix, codeSuffix, label);
    }
    
    public String toCode() throws SocketNullException, SubroutineNotDeclaredException{
        String sensorName = null;
        String headerStr = null;
        String setupCode;
        String ret;
        if(label.equals("Sensor_0")){
            sensorName = "sensor_0";
            headerStr = "int "+sensorName+"=A0;";
        }
        else if(label.equals("Sensor_1")){
            sensorName = "sensor_1";
            headerStr = "int "+sensorName+"=A1;\n";
        }
        else if(label.equals("Sensor_2")){
            sensorName = "sensor_2";
            headerStr = "int "+sensorName+"=A2;\n";
        }
        else if(label.equals("Sensor_3")){
            sensorName = "sensor_3";
            headerStr = "int "+sensorName+"=A3;\n";
        }
        else if(label.equals("Sensor_4")){
            sensorName = "sensor_4";
            headerStr = "int "+sensorName+"=A4;\n";
        }
        else if(label.equals("Sensor_5")){
            sensorName = "sensor_5";
            headerStr = "int "+sensorName+"=A5;\n";
        }
        
        setupCode = "pinMode("+sensorName+", INPUT);\n";
        ret = "digitalRead(" +sensorName+ ") == HIGH";
        
        translator.addDefinitionCommand(headerStr);
        translator.addSetupCommand(setupCode);
        return codePrefix + ret + codeSuffix;
    }
}

        