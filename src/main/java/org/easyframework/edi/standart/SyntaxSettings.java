package org.easyframework.edi.standart;

import org.easyframework.edi.standart.exception.SyntaxSettingsInvalidException;

public class SyntaxSettings
{

	private final String segmentTerminator;

	private final String segmentSeparator;

	private final String componentSeparator;

	private final String releaseCharacter;

	public SyntaxSettings()
	{
		this("'", "+", ":", "?");
	}

	public SyntaxSettings(final String segmentTerminator, final String segmentSeparator, final String componentSeparator, final String releaseCharacter)
	{
		this.segmentTerminator = segmentTerminator;
		this.segmentSeparator = segmentSeparator;
		this.componentSeparator = componentSeparator;
		this.releaseCharacter = releaseCharacter;
		validate();
	}

	void validate()
	{
		String templateIsEmpty = "The property '%s' is empty.";

		if (segmentTerminator == null || segmentTerminator.trim().length() == 0)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Segment Terminator");

		if (segmentSeparator == null || segmentSeparator.trim().length() == 0)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Segment Separator");

		if (componentSeparator == null || componentSeparator.trim().length() == 0)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Component Separator");

		if (releaseCharacter == null || releaseCharacter.trim().length() == 0)
			throw new SyntaxSettingsInvalidException(templateIsEmpty, "Release Character");

		String templateAreEquals = "The properties '%s' and '%s' are equals.";

		if (segmentTerminator.equals(segmentSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Segment Separator");

		if (segmentTerminator.equals(componentSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Component Separator");

		if (segmentTerminator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Release Character");

		if (segmentSeparator.equals(componentSeparator))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Terminator", "Component Separator");

		if (segmentSeparator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Segment Separator", "Release Character");

		if (componentSeparator.equals(releaseCharacter))
			throw new SyntaxSettingsInvalidException(templateAreEquals, "Component Separator", "Release Character");
	}

	public String getSegmentSeparator()
	{
		return segmentSeparator;
	}

	public String getComponentSeparator()
	{
		return componentSeparator;
	}

	public String getSegmentTerminator()
	{
		return segmentTerminator;
	}

	public String getReleaseCharacter()
	{
		return releaseCharacter;
	}

}
