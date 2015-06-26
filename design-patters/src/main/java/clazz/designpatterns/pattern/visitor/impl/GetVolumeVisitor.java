package clazz.designpatterns.pattern.visitor.impl;

import clazz.designpatterns.pattern.shape.Shape;
import clazz.designpatterns.pattern.visitor.Visitor;

public class GetVolumeVisitor
	implements Visitor
{
	@Override
	public double visit(Shape shape)
	{
		return shape.getVolume();
	}
}
