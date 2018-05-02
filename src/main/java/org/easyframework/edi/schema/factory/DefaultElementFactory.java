package org.easyframework.edi.schema.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.lang.model.type.NullType;

import org.easyframework.edi.schema.factory.Factory.ElementFactory;
import org.easyframework.edi.schema.factory.exception.ElementFactoryException;

public class DefaultElementFactory
{
	public static Class<? extends ElementFactory<?>> fetchFactory(Class<?> type, Field field)
	{
		if (CharSequence.class.isAssignableFrom(type))
			return CharSequenceElementFactory.class;

		if (Number.class.isAssignableFrom(type))
			return NumberElementFactory.class;

		throw new ElementFactoryException("Isn't possible utilize a default factory to field %s from class %s. Please create a custom factory.", field.getName(), type.getName());
	}

	public static ElementFactory<?> newInstance(Class<? extends ElementFactory<?>> factoryType, Class<?> type)
	{
		try
		{
			Constructor<? extends ElementFactory<?>> constructor = factoryType.getConstructor(Class.class);

			constructor.setAccessible(Boolean.TRUE);

			return constructor.newInstance(type);

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
		{
			throw new ElementFactoryException(e);
		}
	}

	public static class NumberElementFactory extends ElementFactory<Number>
	{

		public NumberElementFactory(Class<Number> type)
		{
			super(type);
		}

		public Number build(String... args)
		{
			return null;
		}

	}

	public static class StringBuilderElementFactory extends ElementFactory<StringBuilder>
	{

		public StringBuilderElementFactory(Class<StringBuilder> type)
		{
			super(type);
		}

		@Override
		public StringBuilder build(String... args)
		{
			return null;
		}
	}

	public static class StringBufferElementFactory extends ElementFactory<StringBuffer>
	{

		public StringBufferElementFactory(Class<StringBuffer> type)
		{
			super(type);
		}

		@Override
		public StringBuffer build(String... args)
		{
			return null;
		}
	}

	public static class CharSequenceElementFactory extends ElementFactory<CharSequence>
	{

		public CharSequenceElementFactory(Class<CharSequence> type)
		{
			super(type);
		}

		@Override
		public CharSequence build(String... args)
		{
			if(args.length == 0 || args.length > 1)
				throw new ElementFactoryException("It's necessary one argument, if need two or more, create your own custom factory.");
			
			return null;
		}
	}

	public static class None extends ElementFactory<NullType>
	{

		public None(Class<NullType> type)
		{
			super(type);
		}

		public NullType build(String... args)
		{
			return null;
		}
	}

}
