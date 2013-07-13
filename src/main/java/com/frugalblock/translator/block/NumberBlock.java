package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;

public class NumberBlock extends TranslatorBlock
{
	public NumberBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode()
	{
		return codePrefix + label + codeSuffix;
	}

}
