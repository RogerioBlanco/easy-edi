package org.easyframework.edi.standart;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DefaultTraverser implements Traverser
{

	@Override
	public <T> T read(Class<T> type, InputStreamReader inputStream)
	{
		return null;
	}

	@Override
	public <T> boolean write(T instance, OutputStreamWriter outputStream)
	{
		return false;
	}

}
