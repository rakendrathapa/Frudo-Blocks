package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.TranslatorBlock;

public abstract class ConstBlock extends TranslatorBlock
{
	private String code;
	protected ConstBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
		this.code = "undefined";
	}

	protected void setCode(String code)
	{
		this.code = code;
	}
	
	public String toCode()
	{
		return codePrefix + code + codeSuffix;
	}

}
