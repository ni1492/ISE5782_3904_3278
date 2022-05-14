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
	private Material material=new Material();
	
	/**
	 * getter for the material of the geometry 
	 * @return Material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * setter for the material of the geometry
	 * @param material of the geometry
	 * @return this
	 */
	public Geometry setMaterial(Material material) {
		this.material = material;
		return this;
	}

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
