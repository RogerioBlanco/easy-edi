package org.easyframework.edi.standart.exception;

import org.easyframework.edi.exception.SerializerException;

public class InvalidTypeClassException extends SerializerException
{

	private static final long serialVersionUID = -7157238533307665551L;

	public InvalidTypeClassException()
	{
		super();
	}

	public InvalidTypeClassException(String format, Object... args)
	{
		super(format, args);
	}

	public InvalidTypeClassException(String msg)
	{
		super(msg);
	}

}
