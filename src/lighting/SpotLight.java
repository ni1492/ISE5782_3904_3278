package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/***
 * spot light class
 * extends pointLight
 */
public class SpotLight extends PointLight {
private Vector direction;

/**
 * constructor
 * @param intensity - color
 * @param position - point
 * @param kC - double constant attenuation factor
 * @param kQ - double quadratic attenuation factor
 * @param kL - double linear attenuation factor
 * @param direction - vector
 */
public SpotLight(Color intensity, Point position, double kC, double kQ, double kL, Vector direction) {
	super(intensity, position, kC, kQ, kL);
	this.direction = direction.normalize();
}
/**
 * default constructor
 * @param intensity - color
 * @param position - point
 * @param direction - vector
 */
public SpotLight(Color intensity, Point position, Vector direction) {
	super(intensity, position);
	this.direction = direction.normalize();
	
}
	@Override
	public Color getIntensity(Point p) {
		Color c=super.getIntensity(p);
		double dL=direction.normalize().dotProduct(this.getL(p));
		if(dL<0)
		{
			dL=0;
		}
		return c.scale(dL);
}
}
