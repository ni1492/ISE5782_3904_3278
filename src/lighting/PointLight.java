package lighting;

import primitives.*;

/***
 * 
 * point light class
 * extends light
 * implements lightSource
 */
public class PointLight extends Light implements LightSource  {
private Point position;
private double kC;
private double kQ;
private double kL;


/**
 * constructor
 * @param intensity - color
 * @param position - point
 * @param kC - double constant attenuation factor
 * @param kQ - double quadratic attenuation factor
 * @param kL - double linear attenuation factor
 */
public PointLight(Color intensity, Point position, double kC, double kQ, double kL) {
	super(intensity);
	this.position = position;
	this.kC = kC;
	this.kQ = kQ;
	this.kL = kL;
}

/**
 * default constructor
 * @param intensity and position
 */
public PointLight(Color intensity,Point position) {
	super(intensity);
	this.kC = 1;
	this.kQ = 0;
	this.kL = 0;
	this.position=position;
}

/**
 * setKc function 
 * @param kC - double constant attenuation factor
 * @return this 
 */
public PointLight setKc(double kC) {
	this.kC = kC;
	return this;
}
/**
 * setKq function 
 * @param kQ - double quadratic attenuation factor
 * @return this 
 */
public PointLight setKq(double kQ) {
	this.kQ = kQ;
	return this;

}
/**
 * setKl function 
 * @param kL - double linear attenuation factor
 * @return this 
 */
public PointLight setKl(double kL) {
	this.kL = kL;
	return this;

}

/**
 * get intensity of a point from the light source according to the distance from the light source
 * @param point p
 */
public Color getIntensity(Point p) {
	double factors=1/(this.kC+this.kL*this.position.distance(p)+this.kQ*this.position.distanceSquared(p));
	return this.getIntensity().scale(factors);

}

/**
 * gets the vector from the light source to the point
 * @param point p
 */
public Vector getL(Point p) {
	return p.subtract(this.position).normalize();
	
}

public double getDistance(Point p) {
	return this.position.distance(p);
}
	
}
