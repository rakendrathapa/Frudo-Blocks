package com.frugalblock.translator.block.exception;

import com.frugalblock.core.exception.FrugalBlockkException;

public class SocketNullException extends FrugalBlockkException
{

	/**
	 * 
	 */
	private Long blockId;
	
	
	public SocketNullException(Long blockId)
	{
		this.blockId = blockId;
	}
	
	public Long getBlockId()
	{
		return blockId;
	}
	private static final long serialVersionUID = -3386587749080938964L;

}
