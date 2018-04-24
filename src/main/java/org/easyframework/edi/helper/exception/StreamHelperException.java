package org.easyframework.edi.helper.exception;

import org.easyframework.edi.exception.SerializerException;

public class StreamHelperException extends SerializerException
{
	private static final long serialVersionUID = -2537829077605119830L;

	public StreamHelperException()
	{
		super();
	}

	public StreamHelperException(String format, Object... args)
	{
		super(format, args);
	}

	public StreamHelperException(String msg, Throwable arg)
	{
		super(msg, arg);
	}

	public StreamHelperException(String msg)
	{
		super(msg);
	}

	public StreamHelperException(Throwable arg)
	{
		super(arg);
	}

}
