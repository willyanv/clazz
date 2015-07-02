package sn.server.servlet;

public class SystemError
{
	private String	message;

	private String	trace;

	public SystemError(String message, String trace)
	{
		this.message = message;
		this.trace = trace;
	}

	public String getMessage()
	{
		return message;
	}

	public String getTrace()
	{
		return trace;
	}
}
