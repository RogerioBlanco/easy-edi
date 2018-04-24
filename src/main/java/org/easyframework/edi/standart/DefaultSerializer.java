package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.easyframework.edi.Serializer;
import org.easyframework.edi.exception.SerializerException;

public class DefaultSerializer implements Serializer
{

	private final Traverser traverser;

	public DefaultSerializer()
	{
		this.traverser = new DefaultTraverser();
	}

	public <T> T read(Class<T> type, InputStream input, Charset charset) throws SerializerException
	{
		return traverser.read(type, new InputStreamReader(input, charset));
	}

	@Override
	public <T> boolean write(T instance, OutputStream output, Charset charset) throws SerializerException
	{
		return traverser.write(instance, new OutputStreamWriter(output, charset));
	}

}
