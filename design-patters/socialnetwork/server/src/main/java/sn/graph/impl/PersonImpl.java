package sn.graph.impl;

import sn.graph.Person;

public class PersonImpl
	implements Person
{

	private long	userId;

	private String	name;

	private double	affinity;

	public PersonImpl(long userId, String name, double affinity)
	{
		this.userId = userId;
		this.name = name;
		this.affinity = affinity;
	}

	@Override
	public long getUserId()
	{
		return userId;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public double getAffinity()
	{
		return affinity;
	}
}
