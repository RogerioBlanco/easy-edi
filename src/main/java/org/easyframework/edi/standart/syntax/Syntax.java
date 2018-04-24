package org.easyframework.edi.standart.syntax;

import org.easyframework.edi.standart.syntax.exception.SyntaxSettingsInvalidException;

public class Syntax
{

	private final Character segmentTerminator;

	private final Character elementSeparator;

	private final Character dataElementSeparator;

	private final Character releaseCharacter;

	public Syntax()
	{
		this(new Character('\''), new Character('+'), new Character(':'), new Character('?'));
	}

	public Syntax(final Character segmentTerminator, final Character segmentSeparator, final Character dataElementSeparator, final Character releaseCharacter)
	{
		this.segmentTerminator = segmentTerminator;
		this.elementSeparator = segmentSeparator;
		this.dataElementSeparator = dataElementSeparator;
		this.releaseCharacter = releaseCharacter;
		validate();
	}

	void validate()
	{
		String templateIsEmpty = "The property '%s' is empty.";

		if (segmentTerminator == null)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Segment Terminator");

		if (elementSeparator == null)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Element Separator");

		if (dataElementSeparator == null)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Data Element Separator");

		if (releaseCharacter == null)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Release Character");

		String templateAreEquals = "The properties '%s' and '%s' are equals.";

		if (segmentTerminator.equals(elementSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Element Separator");

		if (segmentTerminator.equals(dataElementSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Data Element Separator");

		if (segmentTerminator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Release Character");

		if (elementSeparator.equals(dataElementSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Data Element Separator");

		if (elementSeparator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Element Separator", "Release Character");

		if (dataElementSeparator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Data Element Separator", "Release Character");
	}

	public Character getSegmentTerminator()
	{
		return segmentTerminator;
	}

	public Character getElementSeparator()
	{
		return elementSeparator;
	}

	public Character getDataElementSeparator()
	{
		return dataElementSeparator;
	}

	public Character getReleaseCharacter()
	{
		return releaseCharacter;
	}

	public String getStringElementSeparator()
	{
		return getElementSeparator().toString();
	}

	public String getStringDataElementSeparator()
	{
		return getDataElementSeparator().toString();
	}
}
