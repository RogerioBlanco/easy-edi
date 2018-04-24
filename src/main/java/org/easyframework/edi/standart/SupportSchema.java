package org.easyframework.edi.standart;

import java.util.concurrent.ConcurrentHashMap;

import org.easyframework.edi.schema.Schema;

public class SupportSchema
{

	private final ConcurrentHashMap<Class<?>, Schema> cache;

	public SupportSchema()
	{
		this.cache = new ConcurrentHashMap<>();
	}

	public <T> Schema fetch(Class<T> type)
	{
		return null;
	}

}
