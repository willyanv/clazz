package fbkill.graph.impl;

import java.util.ArrayList;
import java.util.List;

import fbkill.graph.Graph;
import fbkill.graph.Person;

public class GraphImpl
	implements Graph
{
	private List<Person> persons = new ArrayList<>();

	@Override
	public List<Person> getClosestFriends(int count)
	{
		//TODO:
		return null;
	}

	@Override
	public void add(Person person)
	{
		persons.add(person);
	}
}
