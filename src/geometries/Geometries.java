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
		if(BVH)
			createBoundingBox();
		list = new ArrayList<Intersectable>();
	}
	/**
	 * Constructor- initializes the list of Intersectable with the geometries given 
	 * @param collection of geometries which have the findIntersection func.
	 */
	public Geometries(Intersectable... geometries)
	{
		if(BVH)
		createBoundingBox();
		
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
	@Override
	public void createBoundingBox() {
		if (list == null)
            return;
        double minX = Double.POSITIVE_INFINITY;//Initialize
        double minY = Double.POSITIVE_INFINITY;//Initialize
        double minZ = Double.POSITIVE_INFINITY;//Initialize
        double maxX = Double.NEGATIVE_INFINITY;//Initialize
        double maxY = Double.NEGATIVE_INFINITY;//Initialize
        double maxZ = Double.NEGATIVE_INFINITY;//Initialize
        for (Intersectable geo : list) {
            if (geo.box != null) {
                minX = Math.min(minX, geo.box._minimums.getXyz().getD1());
                minY = Math.min(minY, geo.box._minimums.getXyz().getD2());
                minZ = Math.min(minZ, geo.box._minimums.getXyz().getD3());
                maxX = Math.max(maxX, geo.box._maximums.getXyz().getD1());
                maxY = Math.max(maxY, geo.box._maximums.getXyz().getD2());
                maxZ = Math.max(maxZ, geo.box._maximums.getXyz().getD3());
            }
        }
        box = new BoundingBox(new Point(minX, minY, minZ), new Point(maxX, maxY, maxZ));		
	}


}
