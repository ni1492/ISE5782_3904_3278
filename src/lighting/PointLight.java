package lighting;

import primitives.*;

public class PointLight extends Light implements LightSource  {
private Point position;
private double kC;
private double kQ;
private double kL;


/**
 * 
 * @param intensity
 * @param position
 * @param kC
 * @param kQ
 * @param kL
 */
public PointLight(Color intensity, Point position, double kC, double kQ, double kL) {
	super(intensity);
	this.position = position;
	this.kC = kC;
	this.kQ = kQ;
	this.kL = kL;
}

/**
 * 
 * @param intensity
 */
public PointLight(Color intensity,Point position) {
	super(intensity);
	this.kC = 0;
	this.kQ = 0;
	this.kL = 0;
	this.position=position;
}

/**
 * 
 * @param kC
 * @return
 */
public PointLight setKc(double kC) {
	this.kC = kC;
	return this;
}
/**
 * 
 * @param kQ
 * @return
 */
public PointLight setKq(double kQ) {
	this.kQ = kQ;
	return this;

}
/**
 * 
 * @param kL
 * @return
 */
public PointLight setKl(double kL) {
	this.kL = kL;
	return this;

}
public Color getIntensity(Point p) {
	double distance=this.position.distance(p);
	double factors=this.kC+this.kL*distance+this.kQ*distance*distance;
	return this.getIntensity().scale(1/factors);

}
public Vector getL(Point p) {
	return this.position.subtract(p).normalize();
	
}

	
}
