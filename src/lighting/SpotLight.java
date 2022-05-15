package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class SpotLight extends PointLight {
private Vector direction;

/**
 * 
 * @param intensity
 * @param position
 * @param kC
 * @param kQ
 * @param kL
 * @param direction
 */
public SpotLight(Color intensity, Point position, double kC, double kQ, double kL, Vector direction) {
	super(intensity, position, kC, kQ, kL);
	this.direction = direction;
}
/**
 * 
 * @param intensity
 * @param position
 * @param direction
 */
public SpotLight(Color intensity, Point position, Vector direction) {
	super(intensity, position);
	this.direction = direction;
	
}
	@Override
	public Color getIntensity(Point p) {
		Color c=super.getIntensity(p);
		double d=this.getL(p).dotProduct(direction);
		if(d<0)
		{
			c=c.scale(0);
		}
		return c;
}

}
