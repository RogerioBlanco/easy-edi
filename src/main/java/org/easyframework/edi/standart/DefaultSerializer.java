package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.Serializer;
import org.easyframework.edi.exception.SerializerException;
import org.easyframework.edi.standart.syntax.Syntax;

public class DefaultSerializer implements Serializer
{

	private final Traverser traverser;

	public DefaultSerializer(final Syntax syntax)
	{
		this.traverser = new DefaultTraverser(syntax);
	}

	public <T> T read(Class<T> type, InputStream input, Charset charset) throws SerializerException
	{
		return traverser.read(type, input, charset);
	}

	@Override
	public <T> void write(T instance, OutputStream output, Charset charset) throws SerializerException
	{
		traverser.write(instance, output, charset);
	}

}
