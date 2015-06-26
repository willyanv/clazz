package clazz.designpatterns.pattern.visitor.impl;

import clazz.designpatterns.pattern.shape.Solid;
import clazz.designpatterns.pattern.visitor.Visitor;

public class GetAreaVisitor
	implements Visitor
{
	@Override
	public double visit(Solid shape)
	{
		return shape.getArea();
	}
}
