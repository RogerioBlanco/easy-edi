package org.easyframework.edi.schema;

import org.easyframework.edi.standart.syntax.Syntax;

public interface EdifactConverter
{

	public EdifactConverterReturn from(Syntax syntax, String text);

	public <T> EdifactConverterReturn from(Schema schema, T instance);

	public interface EdifactConverterReturn 
	{
		public Edifact toEdifact();
		
		public <T> T toPOJO(Schema schema);
	}

}
