package primitives;

import java.util.Objects;

public class Point 
{
	final Double3 xyz;

	public Point(Double3 xyz) 
	{
		this.xyz = xyz;
	}

	public Point(double x, double y, double z) 
	{
		this.xyz= new Double3(x,y,z);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return this.xyz.equals(other.xyz);
	}

	@Override
	public String toString()
	{
		return  xyz.toString();
	}

	public Point add(Vector vector)
	{
		return new Point (this.xyz.add(vector.xyz));
	}
	
	public Vector subtract(Point point)
	{
		return new Vector (this.xyz.subtract(point.xyz));
	}
	public double distanceSquared(Point other)
	{
		double d1=other.xyz.d1;
		double d2=other.xyz.d2;
		double d3=other.xyz.d3;
		return (d1-xyz.d1)*(d1-xyz.d1)+(d2-xyz.d2)*(d2-xyz.d2)+(d3-xyz.d3)*(d3-xyz.d3);
	}
	public double distance(Point other)
	{
		return Math.sqrt(this.distanceSquared(other));
	}
}
