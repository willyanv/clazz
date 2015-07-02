package sn.timeline.impl;

import sn.timeline.Timeline;
import sn.timeline.TimelineManager;

public class SimpleTimelineManager
	implements TimelineManager
{

	@Override
	public Timeline timelineFor(long userId)
	{
		return new SimpleTimeline(userId);
	}

}
