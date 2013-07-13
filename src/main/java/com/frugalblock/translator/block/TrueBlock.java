package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;

public class TrueBlock extends ConstBlock
{
	public TrueBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("true");
	}
}
