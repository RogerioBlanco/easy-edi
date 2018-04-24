package org.easyframework.edi.schema;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.easyframework.edi.standart.syntax.Syntax;

public class Edifact
{
	private final List<Segment> segments;

	private final Syntax syntax;

	public Edifact(final Syntax syntax)
	{
		this.syntax = syntax;

		this.segments = new ArrayList<>();
	}

	public List<Segment> getSegments()
	{
		return segments;
	}

	public String toString()
	{
		return this.segments.stream()
				.sorted()
				.map(s -> s.name 
						+ syntax.getStringElementSeparator()
						+ s.elements.stream()
							.sorted()
							.map(e -> e.dataElements.stream()
									.sorted()
									.map(DataElement::getRawValue)
									.collect(Collectors.joining(syntax.getStringDataElementSeparator())))
							.collect(Collectors.joining(syntax.getStringElementSeparator()))
						+ syntax.getSegmentTerminator())
				.collect(Collectors.joining(System.lineSeparator()));
	}

	public static class Segment implements Comparable<Segment>
	{
		private final String name;

		private final Integer line;

		private List<Element> elements;

		public Segment(final String name, final Integer line, List<Element> elements)
		{
			this.line = line;
			this.name = name;
			this.elements = elements;
		}

		public String getName()
		{
			return name;
		}

		public Integer getLine()
		{
			return line;
		}

		public List<Element> getElements()
		{
			return elements;
		}

		@Override
		public String toString()
		{
			return line + " - " + name +" - " + elements.toString();
		}

		@Override
		public int compareTo(Segment o)
		{
			return line.compareTo(o.line);
		}

	}

	public static class Element implements Comparable<Element>
	{
		private final Integer group;

		private final List<DataElement> dataElements;

		public Element(final Integer group, List<DataElement> components)
		{
			this.group = group;
			this.dataElements = components;
		}

		public Integer getGroup()
		{
			return group;
		}

		public List<DataElement> getDataElements()
		{
			return dataElements;
		}

		@Override
		public String toString()
		{
			return dataElements.toString();
		}
		
		@Override
		public int compareTo(Element o)
		{
			return group.compareTo(o.group);
		}

	}

	public static class DataElement implements Comparable<DataElement>
	{

		private final Integer position;

		private final String rawValue;

		public DataElement(final Integer position, final String rawValue)
		{
			this.position = position;
			this.rawValue = rawValue;
		}

		public Integer getPosition()
		{
			return position;
		}

		public String getRawValue()
		{
			return rawValue;
		}

		@Override
		public String toString()
		{
			return getRawValue();
		}

		@Override
		public int compareTo(DataElement o)
		{
			return position.compareTo(o.position);
		}
	}

}
