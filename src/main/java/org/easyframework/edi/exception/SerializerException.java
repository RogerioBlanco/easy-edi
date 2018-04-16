package org.easyframework.edi.exception;

public class SerializerException extends RuntimeException
{
	private static final long serialVersionUID = 7703582876932699576L;

	public SerializerException()
	{
		super();
	}

	public SerializerException(String msg, Throwable arg)
	{
		super(msg, arg);
	}

	public SerializerException(Throwable arg)
	{
		super(arg);
	}

	public SerializerException(String msg)
	{
		super(msg);
	}

	public SerializerException(String format, Object... args)
	{
		this(String.format(format, args));
	}
}
