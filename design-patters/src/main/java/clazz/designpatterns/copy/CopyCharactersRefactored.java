package clazz.designpatterns.copy;

import java.util.Arrays;

public class CopyCharactersRefactored
{
	private static final int SIZE = 100;
	
	public static void main(String[] args)
		throws Exception
	{
		Reader reader = null; // Could be any reader
		Writer writer = null; // Could be any writer
		
		byte[] buffer = new byte[SIZE];
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
