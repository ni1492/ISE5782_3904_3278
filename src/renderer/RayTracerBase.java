package renderer;

import primitives.*;
import scene.*;
/**
 * finding the color of the pixels
 * @author nogae
 *
 */
public abstract class RayTracerBase {
	protected Scene scene;

	/**
	 * constructor that receives a scene and construct the scene
	 * @param scene Scene
	 */
	public RayTracerBase(Scene scene) {
		this.scene = scene;
	}
	/**
	 * calculate the color of the intersection of the ray with the objects
	 * @param r Ray: the ray that intersects with objects
	 * @return the color of the intersection
	 */
	public abstract Color traceRay(Ray r);
	
}
