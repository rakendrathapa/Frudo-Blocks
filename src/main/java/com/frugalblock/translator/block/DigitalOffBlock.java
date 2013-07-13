package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;

public class DigitalOffBlock extends ConstBlock
{
	public DigitalOffBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.setCode("LOW");
	}

}
