package geometries;
import java.util.ArrayList;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.*;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;
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
	@Override
	public List<Point> findIntersections(Ray ray) 
	{
		
		//check if the ray intersects with the plane the triangle is on
		if(super.plane.findIntersections(ray)!=null)
		{
			Point p0=ray.getP0();
			Point p1=this.vertices.get(0);
			Point p2=this.vertices.get(1);
			Point p3=this.vertices.get(2);
			Vector v1=p1.subtract(p0);
			Vector v2=p2.subtract(p0);
			Vector v3=p3.subtract(p0);
			Vector n1=v1.crossProduct(v2).normalize();
			Vector n2=v2.crossProduct(v3).normalize();
			Vector n3=v3.crossProduct(v1).normalize();
			
			//check if the ray intersects at a point within the triangle
			if((alignZero(ray.getDir().dotProduct(n1))>0)&&(alignZero(ray.getDir().dotProduct(n2))>0)&&(alignZero(ray.getDir().dotProduct(n3))>0)||((alignZero(ray.getDir().dotProduct(n1))<0)&&(alignZero(ray.getDir().dotProduct(n2))<0)&&(alignZero(ray.getDir().dotProduct(n3))<0)))
				return this.plane.findIntersections(ray);
		}
		return null;
	}
	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
		List<GeoPoint> list=null;
		List<GeoPoint> result = new ArrayList<GeoPoint>();
		//check if the ray intersects with the plane the triangle is on
				if(super.plane.findGeoIntersections(ray)!=null)
				{
					Point p0=ray.getP0();
					Point p1=this.vertices.get(0);
					Point p2=this.vertices.get(1);
					Point p3=this.vertices.get(2);
					Vector v1=p1.subtract(p0);
					Vector v2=p2.subtract(p0);
					Vector v3=p3.subtract(p0);
					Vector n1=v1.crossProduct(v2).normalize();
					Vector n2=v2.crossProduct(v3).normalize();
					Vector n3=v3.crossProduct(v1).normalize();
					
					//check if the ray intersects at a point within the triangle
					if((alignZero(ray.getDir().dotProduct(n1))>0)&&(alignZero(ray.getDir().dotProduct(n2))>0)&&(alignZero(ray.getDir().dotProduct(n3))>0)||((alignZero(ray.getDir().dotProduct(n1))<0)&&(alignZero(ray.getDir().dotProduct(n2))<0)&&(alignZero(ray.getDir().dotProduct(n3))<0)))
						list= this.plane.findGeoIntersections(ray);
						if (list==null)
							return null;
						else {
							for(GeoPoint point: list)
							{
								result.add(new GeoPoint(this,point.point));
							}
						}
						return result;
				}
				return null;
	}
}
