package org.easyframework.edi.schema.exception;

import org.easyframework.edi.exception.SerializerException;

public class SchemaException extends SerializerException
{
	private static final long serialVersionUID = 3788550206506521169L;

	public SchemaException()
	{
		super();
	}

	public SchemaException(String format, Object... args)
	{
		super(format, args);
	}

	public SchemaException(String msg, Throwable arg)
	{
		super(msg, arg);
	}

	public SchemaException(String msg)
	{
		super(msg);
	}

	public SchemaException(Throwable arg)
	{
		super(arg);
	}

}
