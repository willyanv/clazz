package clazz.designpatterns.copy;

import java.io.IOException;

public interface Reader
{
	int read(byte[] buffer)
		throws IOException;
}
