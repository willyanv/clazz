package clazz.designpatterns.copy;

import java.util.Arrays;

public class CopyCharacters
{
	private static final int SIZE = 100;
	
	public static void main(String[] args)
		throws Exception
	{
		byte[] buffer = new byte[SIZE];
		int count;
		while((count = System.in.read(buffer)) != -1)
		{
			String input = new String(buffer);
			if(input.trim().equals("q"))
			{
				System.out.println("Bye!");
				return;
			}
			System.out.println(input.trim());
			Arrays.fill(buffer, (byte) 0);
		}
	}
}
