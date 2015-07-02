package clazz.designpatterns.pattern.shape;

import clazz.designpatterns.pattern.visitor.Visitor;

public class Cube
	implements Solid
{
	private double	len;

	public Cube(double len)
	{
		this.len = len;
	}

	@Override
	public double getArea()
	{
		return Math.pow(len, 2);
	}

	@Override
	public double getVolume()
	{
		return Math.pow(len, 3);
	}

	@Override
	public double accept(Visitor visitor)
	{
		return visitor.visit(this);
	}
}