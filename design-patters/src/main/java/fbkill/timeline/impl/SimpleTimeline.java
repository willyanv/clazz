package fbkill.timeline.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fbkill.timeline.Post;
import fbkill.timeline.Timeline;

public class SimpleTimeline
	implements Timeline
{

	private List<Post> posts = new ArrayList<>();

	private long	userId;

	public SimpleTimeline(long userId)
	{
		this.userId = userId;
	}

	@Override
	public int size()
	{
		return posts.size();
	}

	@Override
	public void add(Post post)
	{
		posts.add(post);
	}

	@Override
	public List<Post> getAll()
	{
		return Collections.unmodifiableList(posts);
	}
}
