package geometries;
import primitives.*;
/**
 * 
 * triangle class - inherits from polygon class
 *
 */
public class Triangle extends Polygon
{
	/**
	 * triangle class constructor - receives three points of the triangle
	 * @param a - point a of the triangle
	 * @param b - point b of the triangle
	 * @param c - point c of the triangle
	 */
	public Triangle(Point a,Point b, Point c)
	{
		super(a,b,c);
	}
	@Override
	public String toString() {
		return "" ;
	}
	@Override
	public Vector getNormal(Point point)
	{
		//there must be a normal way to do it... that what we thought about tonight
		Point a=this.vertices.get(0);
		Point b=this.vertices.get(1);
		Point c=this.vertices.get(2);
		Vector v1;
		Vector v2;
		if(point.equals(a))
		{
			v1=a.subtract(b);
			v2=a.subtract(c);
		}
		else if(point.equals(b))
		{
			v1=b.subtract(a);
			v2=b.subtract(c);
		}
		else if(point.equals(c))
		{
			v1=c.subtract(a);
			v2=c.subtract(b);
		}
		else
		{
			v1=point.subtract(b);
			v2=point.subtract(c);
		}
return v1.crossProduct(v2);

		

}
}
