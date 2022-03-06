package geometries;
import primitives.*;
public class Sphere implements Geometry
{
	final Point center;
	final double radius;

	public Sphere(Point center, double radius) 
	{
		this.center = center;
		this.radius = radius;
	}
	
	@Override
	public String toString() 
	{
		return  center.toString() +radius;
	}
	
	public Point getCenter() {
		return center;
	}
	public double getRadius() {
		return radius;
	}
	
	public Vector getNormal(Point point)
	{
		return null;
	}
	
	
}
