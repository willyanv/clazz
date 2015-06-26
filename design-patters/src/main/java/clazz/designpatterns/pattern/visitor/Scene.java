package clazz.designpatterns.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

import clazz.designpatterns.pattern.shape.Shape;
import clazz.designpatterns.pattern.shape.Cube;
import clazz.designpatterns.pattern.shape.Sphere;
import clazz.designpatterns.pattern.visitor.impl.GetAreaVisitor;
import clazz.designpatterns.pattern.visitor.impl.GetVolumeVisitor;

public class Scene
{
	private List<Shape>	shapes = new ArrayList<>();

	private void add(Shape shape)
	{
		shapes.add(shape);
	}

	public static void main(String[] args)
	{
		Scene scene = new Scene();
		scene.add(new Cube(2));
		scene.add(new Cube(5));
		//scene.add(new Sphere(3));
		
		Visitor visitor = true ? new GetAreaVisitor() : new GetVolumeVisitor();
		double  result  = scene.apply(visitor);
		System.out.println(result);
	}

	private double apply(Visitor visitor)
	{
		double result = 0;
		for(Shape shape : shapes)
		{
			result = result + shape.accept(visitor);
		}
		return result;
	}
}