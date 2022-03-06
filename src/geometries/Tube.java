package geometries;
import primitives.*;
public class Tube implements Geometry
{
	final Ray axisRay;
	final double radius;
	public Vector getNormal(Point point)
	{
		return null;
	}
	public Tube(Ray axisRay, double radius) 
	{
		this.axisRay = axisRay;
		this.radius = radius;
	}
	@Override
	public String toString() {
		return axisRay.toString() + radius;
	}
	public Ray getAxisRay() {
		return axisRay;
	}
	public double getRadius() {
		return radius;
	}
	
	
}
