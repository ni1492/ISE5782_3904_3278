package lighting;

import java.util.*;

import primitives.Color;
import primitives.Point;
import primitives.Vector;
/**
 * directional light class
 * implements lightSource and extends Light
 */
public class DirectionalLight extends Light implements LightSource {
private Vector direction;

/**
 * constructor
 * @param intensity - color
 * @param direction - vector
 */
public DirectionalLight(Color intensity, Vector direction) {
	super(intensity);
	this.direction = direction.normalize();
}

/**
 * get intensity of a point from the light source 
 * @param point p
 */
public Color getIntensity(Point p) {
	return super.getIntensity();
}

/**
 * gets the vector from the light source to the point
 * @param point p
 */
public Vector getL(Point p) {
	return this.direction.normalize();
}
/**
 * no position- the distance is infinity	
 */
public double getDistance(Point p) {
	return Double.POSITIVE_INFINITY;
}
}
