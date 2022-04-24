package lighting;

import renderer.*;
import primitives.*;

public class AmbientLight {
	private Color intensity;
	
	public AmbientLight() {
		intensity=Color.BLACK; 
	}

	/**
	 * 
	 * @param ia
	 * @param ka
	 */
	public AmbientLight(Color Ia, Double3 Ka) {
		intensity=Ia.scale(Ka);
	}
	/**
	 * 
	 * @return
	 */
	public Color getIntensity() {
		return intensity;
	}

	

}
