package clazz.designpatterns.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class CopyCharactersFromFileToStderr
{
	private static final int SIZE = 100;

	private static final boolean useStderr = true;
	
	private static final boolean copyFromFile = true;

	public static void main(String[] args)
		throws Exception
	{
		byte[] buffer = new byte[SIZE];
		int count;
		InputStream is = null;
		if(copyFromFile)
		{
			is = new FileInputStream(new File("/tmp/file.txt"));
		}
		while((count = copyFromFile ? is.read(buffer) : System.in.read(buffer)) != -1)
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
