package org.easyframework.edi.standart;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface Traverser
{

	<T> T read(Class<T> type, InputStreamReader inputStream);

	<T> boolean write(T instance, OutputStreamWriter outputStream);

}
