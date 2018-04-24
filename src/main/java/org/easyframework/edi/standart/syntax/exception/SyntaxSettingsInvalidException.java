package org.easyframework.edi.standart.syntax.exception;

import org.easyframework.edi.exception.SerializerException;

public class SyntaxSettingsInvalidException extends SerializerException
{

	private static final long serialVersionUID = -5589849602892394720L;

	public SyntaxSettingsInvalidException()
	{
		super();
	}

	public SyntaxSettingsInvalidException(String format, Object... args)
	{
		super(format, args);
	}

	public SyntaxSettingsInvalidException(String msg)
	{
		super(msg);
	}

}
