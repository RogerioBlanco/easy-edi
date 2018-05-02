package org.easyframework.edi.schema.factory.exception;

import org.easyframework.edi.exception.SerializerException;

public class ElementFactoryException extends SerializerException
{

	private static final long serialVersionUID = 1123829393152379398L;

	public ElementFactoryException()
	{
		super();
	}

	public ElementFactoryException(String format, Object... args)
	{
		super(format, args);
	}

	public ElementFactoryException(String msg, Throwable arg)
	{
		super(msg, arg);
	}

	public ElementFactoryException(String msg)
	{
		super(msg);
	}

	public ElementFactoryException(Throwable arg)
	{
		super(arg);
	}

}
