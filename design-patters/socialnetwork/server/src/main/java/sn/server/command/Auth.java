package sn.server.command;

import org.apache.commons.lang3.RandomStringUtils;

public class Auth
	implements Command
{
	private String username;
	
	private String password;
	
	@Override
	public Object execute()
		throws Exception
	{
		boolean valid = "zzz".equals(username) && "zzz".equals(password);
		if(valid)
		{
			String token = RandomStringUtils.randomAlphanumeric(32);
			return new AuthReply(token);
		}
		return new AuthReply(null);
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}