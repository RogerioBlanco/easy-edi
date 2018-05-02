package org.easyframework.edi.schema;

import java.util.ArrayList;
import java.util.List;

public class RootSchema extends Schema
{

	public final List<Schema> segments;

	public RootSchema()
	{
		this.segments = new ArrayList<>();
	}

	public void addSegment(Schema segment)
	{
		this.segments.add(segment);
	}

}
