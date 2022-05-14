package lighting;

import primitives.*;

/**
 *abstract class for the light object in the scene
 */
abstract class Light {
private Color intensity;

/**
 * constructor for Light class- gets intensity field
 * @param intensity
 */
protected Light(Color intensity) {
	this.intensity = intensity;
}

/**
 * getter for the intensity field
 * @return Color intensity
 */
public Color getIntensity() {
	return intensity;
}


}
