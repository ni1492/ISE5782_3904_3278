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
		return null;
	}
}
