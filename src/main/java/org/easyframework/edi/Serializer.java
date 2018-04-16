package org.easyframework.edi;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.exception.SerializerException;

public interface Serializer
{
	public <T> T read(Class<? extends T> type, InputStream input, Charset charset) throws SerializerException;

	public void write(Object instance, OutputStream output, Charset charset) throws SerializerException;

}
