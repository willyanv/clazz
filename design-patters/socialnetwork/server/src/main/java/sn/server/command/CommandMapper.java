package sn.server.command;

import javax.servlet.http.HttpServletRequest;

public interface CommandMapper
{
	Command translate(HttpServletRequest request)
		throws Exception;
}
