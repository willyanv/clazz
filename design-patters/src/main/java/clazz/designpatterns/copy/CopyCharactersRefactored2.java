package clazz.designpatterns.copy;

import java.io.IOException;
import java.util.Arrays;

public class CopyCharactersRefactored2
{
	private int	size;

	public CopyCharactersRefactored2(int size)
	{
		this.size = size;
	}

	public static void main(String[] args)
		throws Exception
	{
		Reader reader = null; // Could be any reader
		Writer writer = null; // Could be any writer
		
		new CopyCharactersRefactored2(100 /* buffer size */).copy(reader, writer);
	}

	public void copy(Reader reader, Writer writer)
		throws IOException
	{
		byte[] buffer = new byte[size];
		int count;
		while((count = reader.read(buffer)) != -1)
		{
			String input = new String(buffer);
			if(input.trim().equals("q"))
			{
				writer.writeln("Bye!");
				return;
			}
			writer.writeln(input.trim());
			Arrays.fill(buffer, (byte) 0);
		}
	}
}
