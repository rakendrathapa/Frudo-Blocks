package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.exception.SocketNullException;
import com.frugalblock.translator.block.exception.SubroutineNotDeclaredException;

public class AdditionBlock extends TranslatorBlock
{
	public AdditionBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret = "( ";
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		ret = ret + translatorBlock.toCode();
		ret = ret + " + ";
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		ret = ret + translatorBlock.toCode();
		ret = ret + " )";
		return codePrefix + ret + codeSuffix;
	}

}
