package org.easyframework.edi.schema;

import java.util.ArrayList;
import java.util.List;

public class SegmentSchema extends Schema
{

	private final List<Schema> elements;

	public SegmentSchema()
	{
		this.elements = new ArrayList<>();
	}

	public void addElement(Schema element)
	{
		this.elements.add(element);
	}

}
