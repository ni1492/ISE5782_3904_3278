package geometries;
import java.util.List;

import primitives.*;
public class Tube extends Geometry
{
	final Ray axisRay;
	final double radius;
	public Vector getNormal(Point point)
	{
		
		Vector v=point.subtract(this.axisRay.getP0());
		
		if(v.dotProduct(this.axisRay.getDir())==0)
		{
			return v.normalize();
		}
		double t=this.axisRay.getDir().dotProduct(v);
		Point o=this.axisRay.getP0().add(this.axisRay.getDir().scale(t));
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
	@Override
	public List<Point> findIntersections(Ray ray) {
		return null;
	}
	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
