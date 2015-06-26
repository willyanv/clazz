package clazz.designpatterns.pattern.shape;

import clazz.designpatterns.pattern.visitor.VisitorAcceptor;

public interface Solid
	extends VisitorAcceptor
{
	double getArea();
	
	double getVolume();
}
