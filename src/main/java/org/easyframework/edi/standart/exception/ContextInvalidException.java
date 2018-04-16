package org.easyframework.edi.standart.exception;

import org.easyframework.edi.exception.SerializerException;

public class ContextInvalidException extends SerializerException
{
	private static final long serialVersionUID = 7021766627262721936L;

	public ContextInvalidException()
	{
		super();
	}

	public ContextInvalidException(String format, Object... args)
	{
		super(format, args);
	}

	public ContextInvalidException(String msg)
	{
		super(msg);
	}

}
