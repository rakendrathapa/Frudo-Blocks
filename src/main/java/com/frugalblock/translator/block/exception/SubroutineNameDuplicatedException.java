package com.frugalblock.translator.block.exception;

import com.frugalblock.core.exception.FrugalBlockkException;

public class SubroutineNameDuplicatedException extends FrugalBlockkException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 882306487358983819L;
	
	private Long blockId;

	public Long getBlockId() {
		return blockId;
	}
	
	public SubroutineNameDuplicatedException(Long blockId)
	{
		this.blockId = blockId;
	}

}
