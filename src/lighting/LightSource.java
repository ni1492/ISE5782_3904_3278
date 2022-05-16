package lighting;

import primitives.*;

/**
 * interface light source
 *
 */
public interface LightSource {
	/**
	 * gets a point and return the intensity in the point
	 * @param p- point
	 * @return the intensity color
	 */
	public Color getIntensity(Point p);
	/**
	 * gets a point and return the ???? in the point
	 * @param p- point
	 * @return vector ?
	 */
	public Vector getL(Point p);
	
	/**
	 * return the length from the light to the point 
	 * @param p - Point
	 * @return the distance from the light to the point
	 */
	public double getDistance(Point p);

}
