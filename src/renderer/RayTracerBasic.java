package renderer;

import java.util.List;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.*;

/**
 * finding the color of the pixels
 * @author nogae
 *
 */
public class RayTracerBasic extends RayTracerBase {
	
	/**
	 * constructor that receives a scene and construct the scene
	 * @param scene Scene
	 */
	public RayTracerBasic(Scene scene){
		super(scene);
	}
	
	/**
	 * calculate the color of the intersection of the ray with the objects
	 * @param r Ray: the ray that intersects with objects
	 * @return the color of the intersection
	 */
	public Color traceRay(Ray r)
	{
		List<GeoPoint> points=scene.geometries.findGeoIntersections(r);
		if(points==null)
			return scene.background;
		return calcColor(r.findClosestGeoPoint(points));
		}
	/**
	 * return the color of the point depends on the lightning around
	 * @param point Point: the point to check the color
	 * @return return the color of the point
	 */
	public Color calcColor(GeoPoint point)
	{
		return point.geometry.getEmission().add(this.scene.ambientLight.getIntensity());
	}
}
