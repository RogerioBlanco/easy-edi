package org.easyframework.edi.schema.converter;

import java.util.ArrayList;
import java.util.List;

import org.easyframework.edi.schema.model.Edifact;
import org.easyframework.edi.schema.model.Edifact.DataElement;
import org.easyframework.edi.schema.model.Edifact.Element;
import org.easyframework.edi.schema.model.Edifact.Segment;
import org.easyframework.edi.standart.syntax.Syntax;

public class EdifactReader
{

	protected final Syntax syntax;

	protected static final int INDEX_NOT_FOUND = -1;

	public EdifactReader(final Syntax syntax)
	{
		this.syntax = syntax;
	}

	public Edifact read(String text)
	{
		Edifact edifact = new Edifact(syntax);

		for (Segment segment : fetchSegments(text))
			edifact.getSegments().add(segment);

		return edifact;
	}

	private List<Segment> fetchSegments(String text)
	{
		List<Segment> segments = new ArrayList<>();

		int startSegment = 0;
		int endSegment = 0;

		int lines = 0;

		while (INDEX_NOT_FOUND != endSegment)
		{
			endSegment = nextSegmentTerminator(text, startSegment);

			if (INDEX_NOT_FOUND != endSegment)
				segments.add(new Segment(fetchName(text, startSegment), lines++, fetchElements(text, startSegment, endSegment)));

			startSegment = endSegment;

		}

		return segments;
	}

	private String fetchName(String text, int startSegment)
	{
		return text.substring(startSegment, nextElementSeparator(text, startSegment));
	}

	private List<Element> fetchElements(String text, int startSegment, int endSegment)
	{
		List<Element> elements = new ArrayList<>();

		int startElement = startSegment;

		int endElement = startSegment;

		int group = 0;

		startElement = nextElementSeparator(text, endElement);

		while (!(endElement == INDEX_NOT_FOUND || endSegment <= endElement))
		{
			endElement = nextElementSeparator(text, startElement);

			endElement = endElement == INDEX_NOT_FOUND || endSegment <= endElement ? endSegment : endElement;

			if (0 < endElement && endElement <= endSegment)
				elements.add(new Element(group++, fetchDataComponents(text, startElement, endElement)));

			startElement = endElement;

		}

		return elements;

	}

	private List<DataElement> fetchDataComponents(String text, int startElement, int endElement)
	{
		List<DataElement> components = new ArrayList<>();

		int startComponentElement = startElement;
		int endComponentElement = startElement;

		int positions = 0;

		while (!(endComponentElement == INDEX_NOT_FOUND || endElement <= endComponentElement))
		{
			endComponentElement = nextComponentSeparator(text, startComponentElement);

			endComponentElement = endComponentElement == INDEX_NOT_FOUND || endElement <= endComponentElement ? endElement : endComponentElement;

			if (0 < endComponentElement && endComponentElement <= endElement)
				components.add(new DataElement(positions++, text.substring(startComponentElement + 1, endComponentElement)));

			startComponentElement = endComponentElement;
		}

		return components;
	}

	private int nextComponentSeparator(String text, int start)
	{
		return next(syntax.getReleaseCharacter(), syntax.getDataElementSeparator(), text, start);
	}

	private int nextElementSeparator(String text, int start)
	{
		return next(syntax.getReleaseCharacter(), syntax.getElementSeparator(), text, start);
	}

	private int nextSegmentTerminator(String text, int start)
	{
		return next(syntax.getReleaseCharacter(), syntax.getSegmentTerminator(), text, start);
	}

	private int next(Character release, Character tag, String text, int fromIndex)
	{
		int tempFromIndex = fromIndex;
		
		do
		{
			tempFromIndex = text.indexOf(tag.toString(), ++tempFromIndex);
		} while (tempFromIndex != INDEX_NOT_FOUND && text.charAt(tempFromIndex - 1) == release);

		return tempFromIndex;
	}

}
