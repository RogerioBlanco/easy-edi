package org.easyframework.edi;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.helper.StreamHelper;

public class Resources
{

	public static String getFileResourceContent(String path, Charset charset)
	{
		return getFileInputStreamContent(getResource(path), charset);
	}

	public static String getFileInputStreamContent(InputStream input, Charset charset)
	{

		return new StreamHelper().read(input, charset);
	}

	public static InputStream getResource(String path)
	{
		return getLoader().getResourceAsStream(path);
	}

	private static ClassLoader getLoader()
	{
		return Thread.currentThread().getContextClassLoader();
	}
}
