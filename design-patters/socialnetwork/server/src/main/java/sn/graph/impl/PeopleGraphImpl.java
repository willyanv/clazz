package sn.graph.impl;

import sn.graph.Graph;
import sn.graph.PeopleGraph;

public class PeopleGraphImpl
	implements PeopleGraph
{

	public Graph graphFor(long userId)
	{
		return new GraphImpl();
	}

}
