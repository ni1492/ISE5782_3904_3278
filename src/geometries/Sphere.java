package geometries;
import java.util.List;

import primitives.*;
/**
 * 
 * sphere class - geometric shape, implements geometry interface.
 *
 */
public class Sphere extends Geometry
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
		return point.subtract(this.getCenter()).normalize();
}

	@Override
	public List<Point> findIntersections(Ray ray) {
		
		if(this.center.equals(ray.getP0()))
			return List.of(ray.getP0().add(ray.getDir().scale(this.radius)));
		Vector u=this.center.subtract(ray.getP0());
		double tm=ray.getDir().dotProduct(u);
		double d=Math.sqrt(u.lengthSquared()-(tm*tm));
		if(d>=radius)
			return null;
		double th=Math.sqrt(radius*radius-d*d);
		if(ray.getP0().distance(center)==radius && tm<0)
			return null;
		Point p1=ray.getPoint(tm+th);
		if(ray.getP0().distance(center)<=radius)
			return List.of(p1);
		if(tm+th<0 &&th-th<0 ||tm<0)
			return null;
		Point p2=ray.getPoint(tm-th);
		
		
		return List.of(p2,p1);

		
		
	}

	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
		if(this.center.equals(ray.getP0()))
		{
			GeoPoint p=new GeoPoint(this,ray.getP0().add(ray.getDir().scale(this.radius)));
			if(p.point.distance(ray.getP0())<=maxDistance) {
				return List.of(p);
			}
			return null;
		}
		Vector u=this.center.subtract(ray.getP0());
		double tm=ray.getDir().dotProduct(u);
		double d=Math.sqrt(u.lengthSquared()-(tm*tm));
		if(d>=radius)
			return null;
		double th=Math.sqrt(radius*radius-d*d);
		if(ray.getP0().distance(center)==radius && tm<0)
			return null;
		Point p1=ray.getPoint(tm+th);
		if(ray.getP0().distance(center)<=radius)
		{
			GeoPoint p=new GeoPoint(this,p1);
			if(p.point.distance(ray.getP0())<=maxDistance) {
				return List.of(p);
			}
			return null;
		}
		if(tm+th<0 &&th-th<0 ||tm<0)
			return null;
		Point p2=ray.getPoint(tm-th);
		
		//bonus- checks if the points are close enough to the ray's starting point
		if(p1.distance(ray.getP0())<=maxDistance && p2.distance(ray.getP0())<=maxDistance ) {
			return List.of(new GeoPoint(this,p2),new GeoPoint(this,p1));
		}
		if(p2.distance(ray.getP0())<=maxDistance ) {
			return List.of(new GeoPoint(this,p2));
		}
		if(p1.distance(ray.getP0())<=maxDistance ) {
			return List.of(new GeoPoint(this,p1));
		}
		return null;

	}
	
	
}
