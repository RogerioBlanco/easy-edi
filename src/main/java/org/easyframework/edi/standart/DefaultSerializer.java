package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.Serializer;
import org.easyframework.edi.exception.SerializerException;

public class DefaultSerializer implements Serializer
{

	private final Context defaultContext;

	public DefaultSerializer()
	{
		this(new Context(new SyntaxSettings()));
	}

	public DefaultSerializer(final Context context)
	{
		this.defaultContext = context;
	}

	public <T> T read(Class<? extends T> type, InputStream input, Charset charset) throws SerializerException
	{
		return read(this.defaultContext, type, input, charset);
	}

	public <T> T read(Context context, Class<? extends T> type, InputStream input, Charset charset) throws SerializerException
	{
		return (T) new Traverser(context).read(type, input, charset);
	}

	public void write(Object instance, OutputStream out, Charset charset) throws SerializerException
	{
		write(this.defaultContext, instance, out, charset);
	}

	public void write(Context context, Object instance, OutputStream out, Charset charset) throws SerializerException
	{
		new Traverser(context).write(instance, out, charset);
	}

	public <T> boolean isValid(Class<? extends T> type, InputStream input, Charset charset)
	{
		return Boolean.FALSE;
	}

}
