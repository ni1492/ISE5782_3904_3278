package geometries;
import primitives.*;
/**
 * 
 * interface Geometry
 * contains getNormal function
 * implemented by - polygon, plane, sphere, triangle, tube, cylinder
 *
 */
public abstract class Geometry extends Intersectable
{
	protected Color emission=Color.BLACK;
	/**
	 * get normal for geometric shapes
	 * @param point point for the calculation
	 * @return normal vector
	 */
	public abstract Vector getNormal(Point point);
	
	/**
	 * getter for emission variable
	 * @return emission- Color type
	 */
	public Color getEmission() {
		return emission;
	}
	
	/**
	 * setter for the emission variable- builder pattern- return itself
	 * @param emission- Color type
	 */
	public Geometry setEmission(Color emission) {
		this.emission = emission;
		return this;
	}
	
	
}
