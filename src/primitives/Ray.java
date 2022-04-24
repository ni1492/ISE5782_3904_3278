package primitives;

import java.util.List;
import java.util.Objects;
import static primitives.Util.isZero;

/**
 * ray class - primitive
 */
public class Ray {
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
	 * 
	 * @param p0  receives a point
	 * @param dir receives a vector
	 */
	public Ray(Point p0, Vector dir) {
		this.p0 = p0;
		this.dir = dir.normalize();
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
	 * gets a list of points and return the closest point to the starting point
	 * @param points list of points
	 * @return the closest point
	 */
	public Point findClosestPoint(List<Point> points)
	{
		if(points.size()==0)
			return null;
		Point closest=points.get(0);
		for(int i=1;i<points.size();i++)
		{
			if(p0.distance(closest)>p0.distance(points.get(i)))
				closest=points.get(i);	
		}
		return closest;
	}

}
