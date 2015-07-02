package clazz.designpatterns.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

import clazz.designpatterns.pattern.shape.Solid;
import clazz.designpatterns.pattern.shape.Cube;
import clazz.designpatterns.pattern.shape.Sphere;
import clazz.designpatterns.pattern.visitor.impl.GetAreaVisitor;
import clazz.designpatterns.pattern.visitor.impl.GetVolumeVisitor;

public class Scene
{
	private List<Solid>	objects = new ArrayList<>();

	private void add(Solid shape)
	{
		objects.add(shape);
	}

	public static void main(String[] args)
	{
		Scene scene = new Scene();
		scene.add(new Cube(2));
		scene.add(new Cube(5));
		//scene.add(new Sphere(3));
		
		Visitor visitor = new GetVolumeVisitor();
		double  result  = scene.apply(visitor);
		System.out.println(result);
	}

	private double apply(Visitor visitor)
	{
		double result = 0;
		for(Solid solid : objects)
		{
			result = result + solid.accept(visitor);
		}
		return result;
	}
}