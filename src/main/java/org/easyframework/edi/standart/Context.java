package org.easyframework.edi.standart;

import org.easyframework.edi.standart.exception.ContextInvalidException;

public class Context
{

	private final SyntaxSettings syntax;

	private final boolean strict;

	public Context(final SyntaxSettings syntax)
	{
		this(syntax, Boolean.TRUE);
	}

	public Context(final SyntaxSettings syntax, final boolean strict)
	{
		this.syntax = syntax;
		this.strict = strict;
		validate();
	}

	private void validate()
	{
		if (syntax == null)
			throw new ContextInvalidException("The syntax settings can't be null.");

		syntax.validate();
	}

	public SyntaxSettings getSyntax()
	{
		return syntax;
	}

	public boolean isStrict()
	{
		return strict;
	}
}
