package sn.server.command;

public class AuthReply
{

	private String	token;

	public AuthReply(String token)
	{
		this.token = token;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}
}
