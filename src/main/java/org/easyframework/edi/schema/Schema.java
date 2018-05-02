package org.easyframework.edi.schema;

public abstract class Schema
{
	public boolean isRoot()
	{
		return this instanceof RootSchema;
	}

	public boolean isSegment()
	{
		return this instanceof SegmentSchema;
	}

	public boolean isSegmentGroup()
	{
		return this instanceof SegmentGroupSchema;
	}

	public boolean isElement()
	{
		return this instanceof ElementSchema;
	}
}
