package renderer;

import java.util.List;

import primitives.*;
import scene.*;

/**
 * 
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
		List<Point> points=scene.geometries.findIntersections(r);
		if(points==null)
			return scene.background;
		return calcColor(r.findClosestPoint(points));
		}
	/**
	 * return the color of the point depends on the lightning around
	 * @param point Point: the point to check the color
	 * @return return the color of the point
	 */
	public Color calcColor(Point point)
	{
		return this.scene.ambientLight.getIntensity();
	}
}
