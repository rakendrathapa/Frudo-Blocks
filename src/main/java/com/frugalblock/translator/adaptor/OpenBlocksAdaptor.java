package com.frugalblock.translator.adaptor;

import edu.mit.blocks.codeblocks.Block;
import edu.mit.blocks.codeblocks.BlockConnector;
import com.frugalblock.translator.Translator;
import com.frugalblock.translator.block.TranslatorBlock;
import com.frugalblock.translator.block.TranslatorBlockFactory;

public class OpenBlocksAdaptor implements BlockAdaptor
{
	TranslatorBlockFactory translatorBlockFactory;
	public OpenBlocksAdaptor()
	{
		super();
		translatorBlockFactory = new TranslatorBlockFactory();
	}
	
	public TranslatorBlock nextTranslatorBlock(Translator translator, Long blockId, String codePrefix, String codeSuffix)
	{
		Block block = translator.getBlock(blockId);
		blockId = block.getAfterBlockID();
		if (Block.NULL.equals(blockId))
		{
			return null;
		}
		else
		{
			block = translator.getBlock(blockId);
			TranslatorBlock translatorBlock = translatorBlockFactory.buildTranslatorBlock(translator, blockId, block.getGenusName(), codePrefix, codeSuffix, block.getBlockLabel());
			return translatorBlock;
		}
	}
	
	public TranslatorBlock getTranslatorBlockAtSocket(Translator translator, Long blockId, int i, String codePrefix, String codeSuffix)
	{
		Block block = translator.getBlock(blockId);
		if (block == null)
		{
			return null;
		}
		
		BlockConnector blockConnector = block.getSocketAt(i);
		blockId = blockConnector.getBlockID();
		if (Block.NULL.equals(blockId))
		{
			return null;
		}
		else
		{
			block = translator.getBlock(blockId);
//			System.out.println("name: " + block.getGenusName() + "      | label: " + block.getBlockLabel());
			TranslatorBlock translatorBlock = translatorBlockFactory.buildTranslatorBlock(translator, blockId, block.getGenusName(), codePrefix, codeSuffix, block.getBlockLabel());
			return translatorBlock;
		}
		
	}
	
}
