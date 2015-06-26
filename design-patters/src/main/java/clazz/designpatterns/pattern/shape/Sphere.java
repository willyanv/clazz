package clazz.designpatterns.pattern.shape;

import clazz.designpatterns.pattern.visitor.Visitor;

public class Sphere
	implements Shape
{
	private double	radius;

	public Sphere(double radius)
	{
		this.radius = radius;
	}
	
	@Override
	public double getArea()
	{
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getVolume()
	{
		return 4 * Math.PI * Math.pow(radius, 3) / 3;
	}

	@Override
	public double accept(Visitor visitor)
	{
		return visitor.visit(this);
	}
}
