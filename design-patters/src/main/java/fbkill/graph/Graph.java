package fbkill.graph;

import java.util.List;

public interface Graph
{
	List<Person> getClosestFriends(int count);

	void add(Person person);
}
