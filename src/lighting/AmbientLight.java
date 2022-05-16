package lighting;

import renderer.*;
import primitives.*;

/**
 * ambient light class
 * extends light
 */
public class AmbientLight extends Light {

	/**
	 * default constructor for the class- sets the intensity color to be black.
	 */
	public AmbientLight() {
		super(Color.BLACK);
	}

	/**
	 * constructor for the class- sets the intensity color with Ia and Ka.
	 * @param ia- Color of the light
	 * @param ka- Double3 intensity
	 */
	public AmbientLight(Color Ia, Double3 Ka) {
		super(Ia.scale(Ka));
	}
	
	/**
	 * constructor for the class- sets the intensity color with Ia and Ka.
	 * @param ia- Color of the light
	 * @param ka- Double intensity
	 */
	public AmbientLight(Color Ia, double Ka) {
		super(Ia.scale(Ka));
	}

	

}
