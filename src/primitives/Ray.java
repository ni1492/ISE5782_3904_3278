package primitives;

import java.util.Objects;

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

	public Ray(Point p0, Vector dir) 
	{
		this.p0 = p0;
		this.dir = dir.normalize();
	}
}