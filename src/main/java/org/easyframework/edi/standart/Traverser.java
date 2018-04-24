package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.standart.syntax.Syntax;

public interface Traverser
{

	public <T> T read(Class<T> type, InputStream input, Charset charset);

	public <T> T read(Syntax syntax, Class<T> type, InputStream input, Charset charset);

	public <T> void write(T instance, OutputStream output, Charset charset);

	public <T> void write(Syntax syntax, T instance, OutputStream output, Charset charset);

}
