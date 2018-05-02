package org.easyframework.edi.schema;

import java.util.ArrayList;
import java.util.List;

public class SegmentGroupSchema extends Schema
{
	public final List<Schema> segments;

	public SegmentGroupSchema()
	{
		this.segments = new ArrayList<>();
	}

	public void addSegment(Schema segment)
	{
		this.segments.add(segment);
	}

}
