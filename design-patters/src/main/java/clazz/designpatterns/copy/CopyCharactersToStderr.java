package clazz.designpatterns.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CopyCharactersToStderr
{
	private static final boolean useStderr = true;

	public static void main(String[] args)
		throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = reader.readLine()) != null)
		{
			if("q".equals(input))
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
				System.err.println(input);
			}
			else
			{
				System.out.println(input);
			}
		}
	}
}
