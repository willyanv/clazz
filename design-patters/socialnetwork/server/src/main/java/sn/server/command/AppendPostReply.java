package sn.server.command;

public class AppendPostReply
{

	private String	postId;

	public AppendPostReply(String postId)
	{
		this.postId = postId;
	}

	public String getPostId()
	{
		return postId;
	}

	public void setPostId(String postId)
	{
		this.postId = postId;
	}
}
