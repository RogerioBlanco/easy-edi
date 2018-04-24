package org.easyframework.edi.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import org.easyframework.edi.helper.exception.StreamHelperException;

public class StreamHelper
{

	public String read(final InputStream input, final Charset charset)
	{

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, charset)))
		{
			return reader.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e)
		{
			throw new StreamHelperException("Isn't possible convert the input stream to string.", e);
		}
	}

	public void write(String data, final OutputStream output, final Charset charset)
	{
		try (OutputStreamWriter writer = new OutputStreamWriter(output, charset))
		{
			writer.write(data);
		} catch (IOException e)
		{
			throw new StreamHelperException("Isn't possible write string into the output stream.", e);
		}
	}
}
