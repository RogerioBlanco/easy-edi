package org.easyframework.edi.schema;

import org.easyframework.edi.schema.converter.EdifactReader;
import org.easyframework.edi.standart.syntax.Syntax;

public class DefaultEdifactConverter implements EdifactConverter
{

	@Override
	public EdifactConverterReturn from(final Syntax syntax, final String text)
	{

		return new EdifactConverterReturn() {

			@Override
			public <T> T toPOJO(Schema schema)
			{
				return null;
			}

			@Override
			public Edifact toEdifact()
			{
				return new EdifactReader(syntax).read(text);
			}
		};
	}

	@Override
	public <T> EdifactConverterReturn from(Schema schema, T instance)
	{
		return null;
	}

}
