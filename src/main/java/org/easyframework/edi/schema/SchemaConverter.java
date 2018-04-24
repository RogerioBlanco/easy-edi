package org.easyframework.edi.schema;

import org.easyframework.edi.schema.model.Edifact;

public interface SchemaConverter
{

	public Edifact convert(String text);

}
