package fbkill.timeline;

import java.util.List;

public interface Timeline
{
	int size();

	void add(Post post);

	List<Post> getAll();
}
