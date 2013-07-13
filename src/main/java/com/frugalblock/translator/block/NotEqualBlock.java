package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.exception.SocketNullException;
import com.frugalblock.translator.block.exception.SubroutineNotDeclaredException;

public class NotEqualBlock extends TranslatorBlock
{
	public NotEqualBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret = "( ( ";
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		ret = ret + tb.toCode();
		ret = ret + " ) != ( ";
		tb = this.getRequiredTranslatorBlockAtSocket(1);
		ret = ret + tb.toCode();
		ret = ret + " ) )";
		return codePrefix + ret + codeSuffix;
	}
}
