package fbkill.timeline.impl;

import fbkill.timeline.Timeline;
import fbkill.timeline.TimelineManager;

public class SimpleTimelineManager
	implements TimelineManager
{

	@Override
	public Timeline timelineFor(long userId)
	{
		return new SimpleTimeline(userId);
	}

}
