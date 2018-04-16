package org.easyframework.edi.standart.exception;

public class SyntaxSettingsInvalidException extends ContextInvalidException
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
