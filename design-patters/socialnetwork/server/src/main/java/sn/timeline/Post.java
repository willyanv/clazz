package sn.timeline;

import java.util.Date;

public interface Post
{
	long getUserId();

	String getText();

	Date getDate();

	String getPostId();
	void setPostId(String id);
}
