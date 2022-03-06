package geometries;
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
		return null;
	}
	
}
