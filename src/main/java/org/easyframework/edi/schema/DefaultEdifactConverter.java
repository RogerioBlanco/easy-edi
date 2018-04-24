package org.easyframework.edi.schema;

import org.easyframework.edi.schema.converter.EdifactReader;
import org.easyframework.edi.standart.syntax.Syntax;

public class DefaultEdifactConverter implements EdifactConverter
{

	@Override
	public EdifactConverterReturn from(final String text)
	{
		return (final Syntax syntax) -> {
			Edifact edifact = new EdifactReader(syntax).read(text);
			
			return new EdifactReturn() {
				
				@Override
				public <T> T toPOJO(final Schema schema)
				{
					return null;
				}
				
				@Override
				public Edifact get()
				{
					return edifact;
				}
			};
		};
	}

	@Override
	public <T> EdifactConverterReturn from(final Schema schema, final T instance)
	{
		return (final Syntax syntax) -> {
			return new EdifactReturn() {
				@Override
				public <T> T toPOJO(Schema schema)
				{
					return (T) instance;
				}
				
				@Override
				public Edifact get()
				{
					return null;
				}
			};
		};
	}


}
