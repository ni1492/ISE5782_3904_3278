package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.*;
import static primitives.Util.alignZero;

/**
 * finding the color of the pixels
 * 
 * @author nogae
 *
 */
public class RayTracerBasic extends RayTracerBase {

	/**
	 * constructor that receives a scene and construct the scene
	 * 
	 * @param scene Scene
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}

	/**
	 * calculate the color of the intersection of the ray with the objects
	 * 
	 * @param r Ray: the ray that intersects with objects
	 * @return the color of the intersection
	 */
	public Color traceRay(Ray r) {
		List<GeoPoint> points = scene.geometries.findGeoIntersections(r);
		if (points == null)
			return scene.background;
		return calcColor(r.findClosestGeoPoint(points),r);
	}

	/**
	 * return the color of the point depends on the lightning around
	 * @param point Point: the point to check the color
	 * @return return the color of the point
	 */
	public Color calcColor(GeoPoint point,Ray ray)
	{
		return this.scene.ambientLight.getIntensity().add((calcLocalEffects(point,ray)));
		
	}
	/**
	 * helper function for calcColor- calculate the lights effects on the point
	 * @param point Point: the point to check the color
	 * @param ray Ray: the ray that intersects with the point
	 * @return the color that the lights adds to the point
	 */
	private Color calcLocalEffects(GeoPoint point,Ray ray) {
		Color color=point.geometry.getEmission();
		Vector v=ray.getDir();
		Vector n=point.geometry.getNormal(point.point);
		double nv=alignZero(n.dotProduct(v));
		if(nv==0)
			return color;
		Material material=point.geometry.getMaterial();
		
		for(LightSource light:scene.lights)
		{
			Vector l=light.getL(point.point);
			double nl=alignZero(n.dotProduct(l));
			if(nl*nv>0)//sign(nl)==sign(nv)
			{
				Color iL=light.getIntensity(point.point);
				color=color.add(iL.scale(calcDiffusive(material,nl)),iL.scale(calcSpecular(material,n,l,nl,v)));
			}
		}
		return color;
	}

	/**
	 * 
	 * @param material
	 * @param n
	 * @param l
	 * @param nl
	 * @param v
	 * @return
	 */
	private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
		Vector r=l.add(n.scale(nl).scale(-2));
		double vr=alignZero(r.dotProduct(v.scale(-1)));
		if(vr<=0)
		{
			return Double3.ZERO;
		}
		return material.kS.scale(Math.pow(vr, material.nShininess));
	}

	/**
	 * 
	 * @param material
	 * @param nl
	 * @return
	 */
	private Double3 calcDiffusive(Material material, double nl) {
		return material.kD.scale(Math.abs(nl));
	}
}
