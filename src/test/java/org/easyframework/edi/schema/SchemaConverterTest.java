package org.easyframework.edi.schema;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.easyframework.edi.Resources;
import org.easyframework.edi.schema.model.Edifact;
import org.easyframework.edi.schema.model.Edifact.DataElement;
import org.easyframework.edi.schema.model.Edifact.Element;
import org.easyframework.edi.schema.model.Edifact.Segment;
import org.easyframework.edi.standart.syntax.Syntax;
import org.junit.Test;

public class SchemaConverterTest
{

	@Test
	public void shouldConvertEdifactPOJOIntoString()
	{
		Syntax defaultSyntax = new Syntax();

		String expected = Resources.getFileResourceContent("edifact-samples/Sample 1.txt", Charset.defaultCharset());

		Edifact edifact = new Edifact(defaultSyntax);
		
		edifact.addSegment(new Segment("UNB", 0, Arrays.asList(
			new Element(0, Arrays.asList(new DataElement(0, "UNOA"), new DataElement(1, "1"))),
			new Element(1, Arrays.asList(new DataElement(0, "AAAAA"))),
			new Element(2, Arrays.asList(new DataElement(0, "BBBBB"))),
			new Element(3, Arrays.asList(new DataElement(0, "000001"), new DataElement(1, "0000"))),
			new Element(4, Arrays.asList(new DataElement(0, "1111111"))) 
		)));
		
		edifact.addSegment(new Segment("UNH", 1, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1111111"))),
				new Element(1, Arrays.asList(new DataElement(0, "EDIFAC"), new DataElement(1, "D") , new DataElement(2, "95B") , new DataElement(3, "UN"), new DataElement(4, "ITG14")))
		)));
		
		edifact.addSegment(new Segment("UNZ", 2, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1"))),
				new Element(1, Arrays.asList(new DataElement(0, "1111111")))
		)));
			
		
		String actual = edifact.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldConvertEdifactPOJOIntoStringUnsorted() 
	{
		Syntax defaultSyntax = new Syntax();

		String expected = Resources.getFileResourceContent("edifact-samples/Sample 1.txt", Charset.defaultCharset());

		Edifact edifact = new Edifact(defaultSyntax);
		
		edifact.addSegment(new Segment("UNB", 0, Arrays.asList(
			new Element(4, Arrays.asList(new DataElement(0, "1111111"))),	
			new Element(1, Arrays.asList(new DataElement(0, "AAAAA"))),
			new Element(3, Arrays.asList(new DataElement(0, "000001"), new DataElement(1, "0000"))),
			new Element(2, Arrays.asList(new DataElement(0, "BBBBB"))),
			new Element(0, Arrays.asList(new DataElement(0, "UNOA"), new DataElement(1, "1")))
		)));
		
		edifact.addSegment(new Segment("UNZ", 2, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1"))),
				new Element(1, Arrays.asList(new DataElement(0, "1111111")))
		)));
		
		edifact.addSegment(new Segment("UNH", 1, Arrays.asList(
				new Element(0, Arrays.asList(new DataElement(0, "1111111"))),
				new Element(1, Arrays.asList(new DataElement(2, "95B"), new DataElement(0, "EDIFAC"), new DataElement(4, "ITG14"), new DataElement(1, "D"), new DataElement(3, "UN")))
		)));
		
		
		String actual = edifact.toString();
		
		assertEquals(expected, actual);
	}
}
