package geometries;
import primitives.*;
public class Plane implements Geometry 
{
	final Point q0;
	final Vector normal;
	public Plane(Point q0, Vector normal) 
	{
		this.q0 = q0;
		this.normal = normal;
	}
	
	public Plane(Point q0,Point q1,Point q2) 
	{
		this.q0 = q0;
		//Vector a=q1.subtract(q0);
		//Vector b=q2.subtract(q0);
		//this.normal =(a.crossProduct(b)).normalize();
		this.normal=null;
	}
	
	public Vector getNormal(Point point)
	{
		return null;
	}

	@Override
	public String toString() {
		return  q0.toString() + normal.toString();
	}

	public Point getQ0() {
		return q0;
	}

	public Vector getNormal() {
		return normal;
	}
 
}
