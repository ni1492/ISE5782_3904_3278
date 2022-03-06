package geometries;
import primitives.*;
public class Cylinder extends Tube
{
	final double height;
	public Cylinder(Ray axisRay, double radius, double height) 
	{
		super(axisRay, radius);
		this.height=height;
	}
	
	@Override
	public String toString() {
		return height +  axisRay.toString() + radius;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
	public Vector getNormal(Point point)
	{
		return null;
	}
	
}
