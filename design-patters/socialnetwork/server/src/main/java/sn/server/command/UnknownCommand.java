package sn.server.command;

public class UnknownCommand
	implements Command
{
	@Override
	public Object execute()
		throws Exception
	{
		return "Unknown Command";
	}
}
