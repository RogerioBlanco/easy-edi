package org.easyframework.edi.schema;

public interface SchemaRoot
{

	public Edifact convert(String text);

	public <T> T convert(Schema schema, Edifact edifact);

}
