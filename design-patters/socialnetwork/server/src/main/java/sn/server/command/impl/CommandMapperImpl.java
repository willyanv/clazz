package sn.server.command.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.avalon.framework.activity.Initializable;

import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.server.command.UnknownCommand;
import sn.server.command.Validate;

public class CommandMapperImpl
	implements CommandMapper, Initializable
{
	private Map<String, Command> commandByPath = new HashMap<>();
	
	@Override
	public void initialize()
		throws Exception
	{}

	@Override
	public Command translate(String path)
	{
		//return commandByPath.get(path);
		if("/validate".equals(path))
		{
			return new Validate();
		}
		return new UnknownCommand();
	}
}
