package org.easyframework.edi.schema;

import org.easyframework.edi.schema.converter.EdifactReader;
import org.easyframework.edi.standart.syntax.Syntax;

public class DefaulSchemaConverter implements SchemaConverter
{

	private final Syntax syntax;

	public DefaulSchemaConverter(final Syntax syntax)
	{
		this.syntax = syntax;
	}

	@Override
	public Edifact convert(String text)
	{
		return new EdifactReader(syntax).read(text);
	}

}
