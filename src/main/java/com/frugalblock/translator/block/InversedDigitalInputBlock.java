package com.frugalblock.translator.block;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.exception.SocketNullException;
import com.frugalblock.translator.block.exception.SubroutineNotDeclaredException;

public class InversedDigitalInputBlock extends DigitalInputBlock
{

	public InversedDigitalInputBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String code = super.toCode();
		code = "!(" + code + ")";
		return code;
	}
}
