package geometries;
import primitives.*;
public class Tube implements Geometry
{
	final Ray axisRay;
	final double radius;
	public Vector getNormal(Point point)
	{
		
		Vector v=point.subtract(this.axisRay.getPoint());
		
		if(v.dotProduct(this.axisRay.getDir())==0)
		{
			throw new IllegalArgumentException("The point is parallel to the starting point of the ray");

			//return v.normalize();
		}
		double t=this.axisRay.getDir().dotProduct(v);
		Point o=this.axisRay.getPoint().add(this.axisRay.getDir().scale(t));
		Vector normal=(point.subtract(o)).normalize();
		return normal;
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
