package geometries;
import primitives.*;
/**
 * 
 * interface Geometry
 * contains getNormal function
 * implemented by - polygon, plane, sphere, triangle, tube, cylinder
 *
 */
public interface Geometry 
{
	/**
	 * get normal for geometric shapes
	 * @param point point for the calculation
	 * @return normal vector
	 */
	public Vector getNormal(Point point);
	
}
