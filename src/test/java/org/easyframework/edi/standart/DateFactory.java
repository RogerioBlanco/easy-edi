package org.easyframework.edi.standart;

import java.util.Date;

import org.easyframework.edi.schema.factory.Factory;

public class DateFactory extends Factory.ElementFactory<Date>
{

	public DateFactory(Class<Date> type)
	{
		super(type);
	}

	@Override
	public Date build(String... args)
	{
		return null;
	}

	public static void main(String[] args)
	{
		new DateFactory(Date.class).build(args);
	}
}
