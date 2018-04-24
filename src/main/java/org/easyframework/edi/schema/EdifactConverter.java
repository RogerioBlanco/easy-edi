package org.easyframework.edi.schema;

import org.easyframework.edi.standart.syntax.Syntax;

public interface EdifactConverter
{

	public EdifactConverterReturn from(final String text);
	
	public <T> EdifactConverterReturn from(final Schema schema, final T instance);

	public interface EdifactConverterReturn
	{
		public EdifactReturn toEdifact(final Syntax syntax);
	}

	public interface EdifactReturn {
		
		public Edifact get();
		
		public <T> T toPOJO(final Schema schema);
	}
	

}
