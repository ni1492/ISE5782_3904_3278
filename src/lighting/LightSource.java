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

}
