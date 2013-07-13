package com.frugalblock.translator.block.exception;

import com.frugalblock.core.exception.FrugalBlockkException;

public class SubroutineNotDeclaredException extends FrugalBlockkException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2621233841585294257L;
	
	private Long blockId;
	
	public SubroutineNotDeclaredException(Long blockId)
	{
		this.blockId = blockId;
	}
	
	public Long getBlockId()
	{
		return this.blockId;
	}
}
