package clazz.designpatterns.pattern.visitor.impl;

import clazz.designpatterns.pattern.shape.Shape;
import clazz.designpatterns.pattern.visitor.Visitor;

public class GetAreaVisitor
	implements Visitor
{
	@Override
	public double visit(Shape shape)
	{
		return shape.getArea();
	}
}
