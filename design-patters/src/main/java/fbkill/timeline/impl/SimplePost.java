package fbkill.timeline.impl;

import java.util.Date;

import fbkill.timeline.Post;

public class SimplePost
	implements Post
{

	private long	userId;
	private Date	date;
	private String	text;

	public SimplePost(long userId, Date date, String text)
	{
		this.userId = userId;
		this.date = date;
		this.text = text;
	}

	@Override
	public long getUserId()
	{
		return userId;
	}

	@Override
	public String getText()
	{
		return text;
	}

	@Override
	public Date getDate()
	{
		return date;
	}

}
