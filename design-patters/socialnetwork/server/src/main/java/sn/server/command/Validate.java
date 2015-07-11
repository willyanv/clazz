package sn.server.command;

public class Validate
	implements Command
{
	@Override
	public Object execute()
		throws Exception
	{
		return "Oi, eu sou o validate";
	}
}
