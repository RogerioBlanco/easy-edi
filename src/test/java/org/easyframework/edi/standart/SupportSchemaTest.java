package org.easyframework.edi.standart;

import java.util.Date;

import org.easyframework.edi.annotation.Element;
import org.easyframework.edi.annotation.Root;
import org.easyframework.edi.annotation.Segment;
import org.easyframework.edi.constant.Usage;
import org.easyframework.edi.schema.Schema;
import org.junit.Test;

public class SupportSchemaTest
{
	static class Header
	{
		@Element(group = 1, position = 1, max = 4, usage = Usage.MANDATORY)
		private String type;
		
		@Element(group = 1, position = 2, max = 1, usage = Usage.MANDATORY)
		private String version;
		
		@Element(group = 2, position = {1, 2}, max = 1,  usage = Usage.MANDATORY, factory = DateFactory.class)
		private Date date;
	}

	static class SampleSuperClazz
	{
		@Segment(value = "UNB", position = 1)
		private Header header;
	}

	@Root
	static class SampleClazz extends SampleSuperClazz
	{

	}

	@Test
	public void shouldScanAllFields()
	{
		Schema schema = new SupportSchema().fetch(SampleClazz.class);
	}
}
