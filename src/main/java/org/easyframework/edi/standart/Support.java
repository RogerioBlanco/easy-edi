package org.easyframework.edi.standart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import org.easyframework.edi.exception.SerializerException;
import org.easyframework.edi.standart.exception.InvalidCharsetException;
import org.easyframework.edi.standart.exception.InvalidInstanceException;
import org.easyframework.edi.standart.exception.InvalidOutputException;
import org.easyframework.edi.standart.exception.InvalidTypeClassException;

public class Support
{

	public String read(InputStream inputStream, Charset charset)
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset)))
		{
			return br.lines().collect(Collectors.joining(System.lineSeparator()));
		} catch (IOException e)
		{
			throw new SerializerException("An error occurred when read the input stream.", e);
		}
	}

	
	public void addInstance(Object instance) {
		
	}
	
	public void addClass(Class<?> clazz) {
		
	}
	void validateToWrite(Object instance, OutputStream out, Charset charset)
	{
		if (instance == null)
			throw new InvalidInstanceException("Isn't possible parser from a null instance.");

		if (out == null)
			throw new InvalidOutputException("Isn't possible write to a null outputF.");

		if (charset == null)
			throw new InvalidCharsetException("The charset chosen is null.");

	}

	void validateValidToRead(Class<?> type, InputStream input, Charset charset)
	{
		if (type == null)
			throw new InvalidTypeClassException("Isn't possible parser from a null class.");

		if (input == null)
			throw new InvalidOutputException("Isn't possible read from a null input.");

		if (charset == null)
			throw new InvalidCharsetException("The charset chosen is null.");


	}

}
