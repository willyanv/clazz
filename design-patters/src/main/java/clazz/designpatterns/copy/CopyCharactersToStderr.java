package clazz.designpatterns.copy;

import java.util.Arrays;

public class CopyCharactersToStderr
{
	private static final int SIZE = 100;

	private static final boolean useStderr = true;

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
				if(useStderr)
				{
					System.err.println("Bye!");
				}
				else
				{
					System.out.println("Bye!");
				}
				return;
			}
			if(useStderr)
			{
				System.err.println(input.trim());
			}
			else
			{
				System.out.println(input.trim());
			}

			Arrays.fill(buffer, (byte) 0);
		}

	}
}
