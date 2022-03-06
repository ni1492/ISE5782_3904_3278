package primitives;

import java.util.Objects;

/**
 * 
 * point class - primitive.
 *
 */
public class Point 
{
	final Double3 xyz;
	/**
	 * point class constructor
	 * @param xyz xyz point of Double3
	 */
	public Point(Double3 xyz) 
	{
		this.xyz = xyz;
	}
	/**
	 * point class constructor - receives three points and creates 
	 * a new Double3 point with those values
	 * @param x - point x
	 * @param y - point y
	 * @param z - point z
	 */
	public Point(double x, double y, double z) 
	{
		this.xyz= new Double3(x,y,z);
	}

	/**
	 * equals function
	 * @param receives another object to compare to
	 * @return returns true if equals and false if not equals
	 */
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

	/**
	 * add function
	 * @param vector receives a vector
	 * @return returns the addition of the point and the vector given
	 */
	public Point add(Vector vector)
	{
		return new Point (this.xyz.add(vector.xyz));
	}
	
	/**
	 * subtract function
	 * @param point receives a point
	 * @return returns the subtraction of the point and the vector
	 */
	public Vector subtract(Point point)
	{
		return new Vector (this.xyz.subtract(point.xyz));
	}
	
	/**
	 * distance squared calculator function
	 * @param other receives a point to calculate the squared distance between 
	 * the current point and the given one
	 * @return returns the squared distance between the current point and the point received
	 */
	public double distanceSquared(Point other)
	{
		double d1=other.xyz.d1;
		double d2=other.xyz.d2;
		double d3=other.xyz.d3;
		return (d1-xyz.d1)*(d1-xyz.d1)+(d2-xyz.d2)*(d2-xyz.d2)+(d3-xyz.d3)*(d3-xyz.d3);
	}
	
	/**
	 * distance calculator function
	 * @param other receives a point to calculate the distance between the current point and the given one
	 * @return returns the squared distance between the current point and the point received
	 */
	public double distance(Point other)
	{
		return Math.sqrt(this.distanceSquared(other));
	}
}
