package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class Traverser
{

	private Context context;

	public Traverser(final Context context)
	{
		this.context = context;
	}

	public void write(Object instance, OutputStream out, Charset charset)
	{
	}

	public <T> T read(Class<T> type, InputStream input, Charset charset)
	{
		return null;
	}

}
