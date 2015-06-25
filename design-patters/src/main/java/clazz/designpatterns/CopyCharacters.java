package clazz.designpatterns;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CopyCharacters
{
	public static void main(String[] args)
		throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = reader.readLine()) != null)
		{
			if("q".equals(input))
			{
				System.out.println("Bye!");
				return;
			}
			System.out.println(input);
		}
	}

}
