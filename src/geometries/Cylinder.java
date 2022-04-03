package geometries;
import java.util.List;

import primitives.*;
/**
 * class Cylinder - geometric shape. inherits from class tube. 
 */
public class Cylinder extends Tube
{
	final double height;
	/**
	 * Cylinder class constructor
	 * @param axisRay Ray Param for cylinder
	 * @param radius Radius Param of the cylinder
	 * @param height Height Param of the cylinder
	 */
	public Cylinder(Ray axisRay, double radius, double height) 
	{
		super(axisRay, radius);
		this.height=height;
	}
	
	
	@Override
	public String toString() {
		return height +  axisRay.toString() + radius;
	}
	
	/**
	 * get height function
	 * @return returns the height of the cylinder
	 */
	public double getHeight() {
		return height;
	}
	
	@Override
	public Vector getNormal(Point point)
	{
		Vector v=point.subtract(this.axisRay.getP0());
		double t=this.axisRay.getDir().dotProduct(v);
		if(v.dotProduct(this.axisRay.getDir())==0)//the point is on the bottom		
		{
			return this.axisRay.getDir();
		}
		Point o=this.axisRay.getP0().add(this.axisRay.getDir().scale(t));
		Vector test=o.subtract(this.axisRay.getP0()).normalize();
		if((t==this.getHeight()) && (test.equals(this.axisRay.getDir())))//the point is on the top- need to check the direction to confirm that its not on the opposite side
		{
			return this.axisRay.getDir();
		}
		Vector normal=(point.subtract(o)).normalize();
		return normal;	
		}
	@Override
	public List<Point> findIntersections(Ray ray) {
		return null;
	}
	
}
