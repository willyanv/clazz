package sn.server.command;

import java.util.Date;

import sn.timeline.Post;
import sn.timeline.Timeline;
import sn.timeline.TimelineManager;
import sn.timeline.impl.SimplePost;
import xingu.container.Inject;


public class AppendPost
	implements Command
{
	@Inject
	private TimelineManager timelines;
	
	private String text;
	
	@Override
	public Object execute()
		throws Exception
	{
		System.out.println(text);

		long userId = -1;
		Post post = new SimplePost(userId, new Date(), text);
		Timeline timeline = timelines.timelineFor(userId);
		timeline.add(post);
		return new AppendPostReply(post.getPostId());
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}