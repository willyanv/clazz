package fbkill.timeline;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import fbkill.timeline.impl.SimplePost;
import fbkill.timeline.impl.SimpleTimelineManager;

public class TimelineManagerTest
{
	@Test
	public void testGetTimelineForUser()
		throws Exception
	{
		TimelineManager tm = new SimpleTimelineManager();
		Timeline posts = tm.timelineFor(1);
		assertEquals(0, posts.size());

		posts.add(new SimplePost(1, new Date(), "Fui ao banheiro"));
		assertEquals(1, posts.size());
		
		List<Post> all = posts.getAll();
		Post post = all.get(0);
		assertEquals(1, post.getUserId());
		assertEquals("Fui ao banheiro", post.getText());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testClearTimeline()
		throws Exception
	{
		TimelineManager tm = new SimpleTimelineManager();
		Timeline posts = tm.timelineFor(1);
		posts.add(new SimplePost(1, new Date(), ""));
		assertEquals(1, posts.size());
		
		List<Post> all = posts.getAll();
		all.clear();
	}	
	
}

