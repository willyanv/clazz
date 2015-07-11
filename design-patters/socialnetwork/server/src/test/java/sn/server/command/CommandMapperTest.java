package sn.server.command;

import static org.junit.Assert.*;

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
		Command cmd = mapper.translate("/xxx");
		assertTrue(cmd instanceof UnknownCommand);
	}

	@Test
	public void testCommandMapping()
		throws Exception
	{
		Command cmd = mapper.translate("/validate");
		assertTrue(cmd instanceof Validate);
	}
}
