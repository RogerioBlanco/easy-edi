package org.easyframework.edi.standart;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.easyframework.edi.helper.StreamHelper;
import org.easyframework.edi.schema.DefaultEdifactConverter;
import org.easyframework.edi.schema.Edifact;
import org.easyframework.edi.schema.EdifactConverter;
import org.easyframework.edi.schema.SchemaRoot;
import org.easyframework.edi.schema.SupportSchema;
import org.easyframework.edi.standart.syntax.Syntax;

public class DefaultTraverser implements Traverser
{

	private final Syntax defaultSyntax;

	private final StreamHelper streamHelper;

	private final SupportSchema support;

	private final EdifactConverter converter;

	public DefaultTraverser(final Syntax syntax)
	{
		this.defaultSyntax = syntax;
		this.support = new SupportSchema();
		this.streamHelper = new StreamHelper();
		this.converter = new DefaultEdifactConverter();
	}

	@Override
	public <T> T read(Class<T> type, InputStream input, Charset charset)
	{
		return read(defaultSyntax, type, input, charset);
	}

	public <T> T read(Syntax syntax, Class<T> type, InputStream input, Charset charset)
	{
		String text = streamHelper.read(input, charset);

		return converter.from(text).toEdifact(syntax).toPOJO(support.fetch(type));
	}

	@Override
	public <T> void write(T instance, OutputStream output, Charset charset)
	{
		write(defaultSyntax, instance, output, charset);
	}

	public <T> void write(Syntax syntax, T instance, OutputStream output, Charset charset)
	{
		Edifact edifact = converter.from(support.fetch(instance.getClass()), instance).toEdifact(syntax).get();

		streamHelper.write(edifact.toString(), output, charset);
	}

}
