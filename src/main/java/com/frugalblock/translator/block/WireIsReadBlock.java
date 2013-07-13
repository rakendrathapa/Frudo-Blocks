package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;

public class WireIsReadBlock extends TranslatorBlock
{
	public WireIsReadBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode()
	{
		WireReadBlock.setupWireEnvironment(translator);
		return codePrefix + " __ardublockIsI2cReadOk " + codeSuffix;
	}

}
