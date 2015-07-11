package sn.server.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.server.command.Command;
import sn.server.command.CommandMapper;
import xingu.container.Inject;
import xingu.lang.NotImplementedYet;
import xingu.lang.SorryException;

public class ApiServlet
	extends SocialNetworkServletSupport
{
	@Inject
	private CommandMapper mapper;
	
	@Override
	protected Object process(HttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		Command command = mapper.translate(request);
		return command.execute();
	}
}