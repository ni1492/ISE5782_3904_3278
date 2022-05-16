package geometries;
//check
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import primitives.*;

public class Geometries extends Intersectable
{
private ArrayList<Intersectable> list;
	
	/**
	 * default constructor
	 */
	public Geometries() {
		list = new ArrayList<Intersectable>();
	}
	/**
	 * Constructor- initializes the list of Intersectable with the geometries given 
	 * @param collection of geometries which have the findIntersection func.
	 */
	public Geometries(Intersectable... geometries)
	{
		list = new ArrayList<Intersectable>();

		for(Intersectable inter: geometries)
		{
			list.add(inter);
		}
	}
	/**
	 * adds all the geometries receives to the list of Intersectable.
	 * @param collection of geometries which have the findIntersection func.
	 */
	public void add(Intersectable... geometries)
	{
		for(Intersectable inter: geometries)
		{
			list.add(inter);
		}
	}
	/**
	 * returns all the intersections points between the ray and the geometries objects.
	 */
	@Override 
	public List<Point> findIntersections(Ray ray)
	{ 
		List<Point> result= new ArrayList<Point>();
		List<Point> p;
		for (Intersectable i: list) {
			p = i.findIntersections(ray);
			if (p!=null)//if there were intersections 
			{
				for(Point point: p) {
					if(point!=null) 
					{
					result.add(point);
					}
				}
			}
		}
		if (result.size()==0)//if there were no intersections
		{
			return null;
		}
		return result;
	}
	
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
		List<GeoPoint> result= new ArrayList<GeoPoint>();
		List<GeoPoint> p;
		for (Intersectable i: list) {
			p = i.findGeoIntersections(ray, maxDistance);
			if (p!=null)//if there were intersections 
			{
				for(GeoPoint point: p) {
					if(point!=null) 
					{
					result.add(point);
					}
				}
			}
		}
		if (result.size()==0)//if there were no intersections
		{
			return null;
		}
		return result;
	}


}
