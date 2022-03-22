package geometries;
import primitives.*;
/**
 * class plane - geometric shape, implements geometry interface.
 */
public class Plane implements Geometry 
{
	final Point q0;
	final Vector normal;
	/**
	 * plane class constructor
	 * @param q0 point param that in on the plane 
	 * @param normal normal vector, normal of the plane
	 */
	public Plane(Point q0, Vector normal) 
	{
		this.q0 = q0;
		this.normal = normal;
	}
	/**
	 * plane class constructor - gets three points that are on the plane
	 * @param q0 - point 1 on the plane
	 * @param q1 - point 2 on the plane
	 * @param q2 - point 3 on the plane
	 */
	public Plane(Point q0,Point q1,Point q2) 
	{
		this.q0 = q0;
		Vector a=q1.subtract(q0);
		Vector b=q2.subtract(q0);
		if(q0==q1 ||q0==q2 ||q1==q2)
			throw new IllegalArgumentException("A plane can't be created because there are only two different points");

		try
		{
			a.crossProduct(b);//check if the points can create a plane
		}
		catch(IllegalArgumentException e)
		{
			throw new IllegalArgumentException("A plane can't be created because all the points are on the same ray");
		}
		this.normal =(a.crossProduct(b)).normalize();
		//this.normal=null;
	}
	/**
	 * get normal function -implements geometry getNormal function
	 * @return returns the normal of the plane
	 */
	public Vector getNormal(Point point)
	{
		return this.getNormal();
	}

	@Override
	public String toString() {
		return  q0.toString() + normal.toString();
	}
	
	/**
	 * get point q0 function 
	 * @return returns the point q0
	 */
	public Point getQ0() {
		return q0;
	}
	
	/**
	 * get normal function
	 * @return returns the normal vector of the class
	 */
	public Vector getNormal() {
		return normal;
	}
 
}
