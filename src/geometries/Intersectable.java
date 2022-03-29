package geometries;

import java.util.List;
import primitives.*;

public interface Intersectable 
{
	/**
	 * the func gets ray and returns list of intersections with the geometry
	 * @param ray type- the ray that intersects with the shape 
	 * @return List of intersections points with the shape
	 */
	public List<Point> findIntersections(Ray ray);
}
