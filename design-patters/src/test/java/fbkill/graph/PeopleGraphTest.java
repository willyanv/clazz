package fbkill.graph;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fbkill.graph.impl.PeopleGraphImpl;
import fbkill.graph.impl.PersonImpl;

public class PeopleGraphTest
{
	@Test
	public void testGraph()
		throws Exception
	{
		Graph graph = new PeopleGraphImpl().graphFor(1);
		graph.add(new PersonImpl(1, "Zequinha", 10.0));
		graph.add(new PersonImpl(2, "Barbosa", 20.0));
		List<Person> closest = graph.getClosestFriends(5);
		assertEquals(2, closest.size());
	}
}
