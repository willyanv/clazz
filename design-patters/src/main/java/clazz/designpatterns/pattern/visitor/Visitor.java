package clazz.designpatterns.pattern.visitor;

import clazz.designpatterns.pattern.shape.Shape;

public interface Visitor
{
	double visit(Shape shape);
}
