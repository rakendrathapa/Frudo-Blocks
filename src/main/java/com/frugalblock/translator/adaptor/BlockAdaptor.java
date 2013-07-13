package com.frugalblock.translator.adaptor;

import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.TranslatorBlock;

public interface BlockAdaptor 
{
	public TranslatorBlock nextTranslatorBlock(Translator translator, Long blockId, String codePrefix, String codeSuffix);
	public TranslatorBlock getTranslatorBlockAtSocket(Translator translator, Long blockId, int i, String codePrefix, String codeSuffix);
}
