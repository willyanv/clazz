package sn.server.command;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import sn.server.command.Command;
import sn.server.command.CommandMapper;
import sn.server.command.UnknownCommand;
import sn.server.command.Validate;
import xingu.container.Inject;
import xingu.container.XinguTestCase;

public class CommandMapperTest
	extends XinguTestCase
{
	@Inject
	private CommandMapper mapper;

	@Test
	public void testUnkonwCommand()
		throws Exception
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getPathInfo()).thenReturn("/xxx");
		Command cmd = mapper.translate(request);
		assertTrue(cmd instanceof UnknownCommand);
	}

	@Test
	public void testCommandMapping()
		throws Exception
	{
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getPathInfo()).thenReturn("/validate");
		Command cmd = mapper.translate(request);
		assertTrue(cmd instanceof Validate);
	}
}
