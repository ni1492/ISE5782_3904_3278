package primitives;

import java.util.Objects;

/**
 * ray class - primitive
 *
 */
public class Ray 
{
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
		return  p0.toString() + dir.toString();
	}
	public Vector getDir()
	{
		return dir;
	}
	public Point getPoint()
	{
		return p0;
	}
	/**
	 * ray class constructor
	 * @param p0 receives a point
	 * @param dir receives a vector
	 */
	public Ray(Point p0, Vector dir) 
	{
		this.p0 = p0;
		this.dir = dir.normalize();
	}
}
