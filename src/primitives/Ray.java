package primitives;

import geometries.Intersectable.GeoPoint;
import java.util.List;
import java.util.Objects;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * ray class - primitive
 */
public class Ray {
	private static final double DELTA = 0.1;// how much to move from he object so the object wont make shadow on the
											// point that's on it
	final Point p0;
	final Vector dir;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		return dir.equals(other.dir) && p0.equals(other.p0);
	}

	@Override
	public String toString() {
		return p0.toString() + dir.toString();
	}

	/**
	 * return the diraction of the ray
	 * @return vector diraction 
	 */
	public Vector getDir() {
		return dir;
	}

	/**
	 * return the starting point of the ray
	 * @return point P0
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * ray class constructor
	 * @param p0  receives a point
	 * @param dir receives a vector
	 */
	public Ray(Point p0, Vector dir) {
		this.p0 = new Point(p0.xyz.d1, p0.xyz.d2, p0.xyz.d3);
		this.dir = dir.normalize();
	}

	/**
	 * constructor that gets the strarting point, the vector and the normal' and
	 * create a new ray that raises the starting point
	 * @param point - origin starting point: Point
	 * @param v - the direction of the ray: Vector
	 * @param n - the normal to the point: Vector
	 */
	public Ray(Point point, Vector v, Vector n) {
		double nv = alignZero(n.dotProduct(v));
		Vector deltaVector = n.scale(nv > 0 ? DELTA : -DELTA);// the vector from the original point towards the normal
		this.p0 = point.add(deltaVector);// raises the point from the object
		this.dir = v.normalize();
	}

	/**
	 * return the point from multiplying the ray by delta and adding it to the current P0
	 * @param delta double number
	 * @return the new point
	 */
	public Point getPoint(double delta) {
		if (isZero(delta)) {
			return p0;
		}
		return p0.add(dir.scale(delta));
	}

	/**
	 * Deprecated function! no longer in use. gets a list of points and return the
	 * closest point to the starting point
	 * @param points list of points
	 * @return the closest point
	 */
	public Point findClosestPoint(List<Point> points) {
		if (points.size() == 0)
			return null;
		Point closest = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if (p0.distance(closest) > p0.distance(points.get(i)))
				closest = points.get(i);
		}
		return closest;
	}

	public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
		if (points.size() == 0)
			return null;
		GeoPoint closest = points.get(0);
		for (int i = 1; i < points.size(); i++) {
			if (p0.distance(closest.point) > p0.distance(points.get(i).point))
				closest = points.get(i);
		}
		return closest;
	}

}
