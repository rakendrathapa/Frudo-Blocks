package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;

public class FalseBlock extends ConstBlock
{
	public FalseBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("false");
	}
}
