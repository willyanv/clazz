package fbkill.graph.impl;

import fbkill.graph.Graph;
import fbkill.graph.PeopleGraph;

public class PeopleGraphImpl
	implements PeopleGraph
{

	public Graph graphFor(long userId)
	{
		return new GraphImpl();
	}

}
