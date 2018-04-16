package org.easyframework.edi.standart.exception;

import org.easyframework.edi.exception.SerializerException;

public class InvalidCharsetException extends SerializerException
{
	private static final long serialVersionUID = 5465111675465363905L;

	public InvalidCharsetException()
	{
		super();
	}

	public InvalidCharsetException(String format, Object... args)
	{
		super(format, args);
	}

	public InvalidCharsetException(String msg)
	{
		super(msg);
	}

}
