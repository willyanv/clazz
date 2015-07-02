package clazz.designpatterns.pattern.visitor;

import clazz.designpatterns.pattern.shape.Solid;

public interface Visitor
{
	double visit(Solid shape);
}
