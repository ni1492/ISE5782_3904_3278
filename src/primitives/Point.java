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

	public Double3 getXyz() 
	{
		return xyz;
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

	
}
