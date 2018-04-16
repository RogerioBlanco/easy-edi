package org.easyframework.edi.standart.exception;

import org.easyframework.edi.exception.SerializerException;

public class InvalidOutputException extends SerializerException
{
	private static final long serialVersionUID = -1777948717710779264L;

	public InvalidOutputException()
	{
		super();
	}

	public InvalidOutputException(String format, Object... args)
	{
		super(format, args);
	}

	public InvalidOutputException(String msg)
	{
		super(msg);
	}

}
