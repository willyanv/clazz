package clazz.designpatterns.pattern.shape;

import clazz.designpatterns.pattern.visitor.VisitorAcceptor;

public interface Shape
	extends VisitorAcceptor
{
	double getArea();
	
	double getVolume();
}
