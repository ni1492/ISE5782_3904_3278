package geometries;
import primitives.*;
/**
 * 
 * sphere class - geometric shape, implements geometry interface.
 *
 */
public class Sphere implements Geometry
{
	final Point center;
	final double radius;
	/**
	 * sphere class constructor
	 * @param center center param - center of the sphere
	 * @param radius radius param - radius of the sphere
	 */
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
	
	/**
	 * get center function
	 * @return returns the center parameter of the sphere
	 */
	public Point getCenter() {
		return center;
	}
	
	/**
	 * get radius function
	 * @return returns the radius parameter of the sphere
	 */
	public double getRadius() {
		return radius;
	}
	
	/**
	 * get normal function - implements geometry getNormal function
	 */
	public Vector getNormal(Point point)
	{
		return null;
	}
	
	
}
