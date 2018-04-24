package org.easyframework.edi.schema;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.easyframework.edi.Resources;
import org.easyframework.edi.schema.Edifact.DataElement;
import org.easyframework.edi.schema.Edifact.Element;
import org.easyframework.edi.schema.Edifact.Segment;
import org.easyframework.edi.standart.syntax.Syntax;
import org.junit.Before;
import org.junit.Test;

public class SchemaConverterTest
{

	private Syntax defaultSyntax;

	@Before
	public void setupTest()
	{
		this.defaultSyntax = new Syntax();
	}

	@Test
	public void shouldConvertStringIntoEdifact()
	{
		Edifact expected = new Edifact(defaultSyntax);
		
		expected.getSegments().add(new Segment("UNB", 0, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "UNOA"), new DataElement(1, "1"))),
				new Element(1, Arrays.asList(new DataElement(0, "AAAAA"))),
				new Element(2, Arrays.asList(new DataElement(0, "BBBBB"))),
				new Element(3, Arrays.asList(new DataElement(0, "000001"), new DataElement(1, "0000"))),
				new Element(4, Arrays.asList(new DataElement(0, "1111111"))) 
		)));
		
		expected.getSegments().add(new Segment("UNH", 1, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1111111"))),
				new Element(1, Arrays.asList(new DataElement(0, "EDIFAC"), new DataElement(1, "D") , new DataElement(2, "95B") , new DataElement(3, "UN"), new DataElement(4, "ITG14")))
		)));
		
		expected.getSegments().add(new Segment("UNZ", 2, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1"))),
				new Element(1, Arrays.asList(new DataElement(0, "1111111")))
		)));
			
		String text = Resources.getFileResourceContent("edifact-samples/Sample 1.txt", Charset.defaultCharset());

		SchemaConverter converter = new DefaulSchemaConverter(defaultSyntax);
		
		Edifact actual = converter.convert(text);
		
		assertEquals(expected.toString(), actual.toString());
	}
}
