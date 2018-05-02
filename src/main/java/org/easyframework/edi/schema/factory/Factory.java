package org.easyframework.edi.schema.factory;

public abstract class Factory<T>
{

	protected final Class<T> type;

	public Factory(final Class<T> type)
	{
		this.type = type;
	}

	public abstract T build(String... args);

	public static abstract class ElementFactory<T> extends Factory<T>
	{

		public ElementFactory(Class<T> type)
		{
			super(type);
		}
	}

	public static abstract class SegmentFactory<T> extends Factory<T>
	{

		public SegmentFactory(Class<T> type)
		{
			super(type);
		}
	}

	public static abstract class SegmentGroupFactory<T> extends Factory<T>
	{

		public SegmentGroupFactory(Class<T> type)
		{
			super(type);
		}
	}

	public Class<T> getType()
	{
		return type;
	}

}
