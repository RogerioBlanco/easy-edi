package org.easyframework.edi.standart.exception;

import org.easyframework.edi.exception.SerializerException;

public class InvalidInstanceException extends SerializerException
{

	private static final long serialVersionUID = 2111446250814910498L;

	public InvalidInstanceException()
	{
		super();
	}

	public InvalidInstanceException(String format, Object... args)
	{
		super(format, args);
	}

	public InvalidInstanceException(String msg)
	{
		super(msg);
	}

}
