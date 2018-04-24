package org.easyframework.edi.helper;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class StreamHelperTest
{

	private static final String TEMP_PATH = System.getProperty("java.io.tmpdir");

	private StreamHelper helper;
	
	private Charset defaultCharset;

	@Before
	public void setupTest()
	{
		defaultCharset = Charset.defaultCharset();
		helper = new StreamHelper();
	}

	@Test
	public void shouldConvertInputStreamToString()
	{
		String expected = UUID.randomUUID().toString();

		String actual = helper.read(new ByteArrayInputStream(expected.getBytes(defaultCharset)), defaultCharset);

		assertEquals(expected, actual);
	}

	@Test
	public void shouldConvertStringIntoFile() throws FileNotFoundException
	{
		String expected = UUID.randomUUID().toString();

		File tempFile = new File(TEMP_PATH.concat("StreamHelperTest.Test-1"));

		helper.write(expected, new FileOutputStream(tempFile), defaultCharset);

		String actual = helper.read(new FileInputStream(tempFile), defaultCharset);

		assertEquals(expected, actual);

		tempFile.delete();
	}

}
