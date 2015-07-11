package sn.server.command.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.avalon.framework.activity.Initializable;
import org.apache.commons.beanutils.BeanUtils;

import sn.server.command.Auth;
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
	public Command translate(HttpServletRequest request)
		throws Exception
	{
		String path = request.getPathInfo();
		Map params = request.getParameterMap();
		
		Command cmd = null;
		//return commandByPath.get(path);
		switch(path)
		{
			case "/validate":
				cmd = new Validate();
				break;
				
			case "/auth":
				cmd = new Auth();
				break;

			default:
				cmd = new UnknownCommand();
				break;
		}
		BeanUtils.populate(cmd, params);
		return cmd;
	}
}