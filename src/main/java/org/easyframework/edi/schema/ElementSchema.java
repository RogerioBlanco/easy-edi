package org.easyframework.edi.schema;

import java.lang.reflect.Field;

import org.easyframework.edi.annotation.Element;
import org.easyframework.edi.schema.factory.Factory.ElementFactory;

public class ElementSchema extends Schema
{

	private final Field field;

	private final ElementFactory<?> factory;

	private final Element element;

	public ElementSchema(final Element element, final Field field, final ElementFactory<?> factory)
	{
		this.element = element;
		this.field = field;
		this.factory = factory;
	}

}
