package primitives;

public class Vector extends Point
{

	public Vector(double x, double y, double z) 
	{
		super(x, y, z);
		if(this.equals(Double3.ZERO))
			throw new IllegalArgumentException("Vector(0,0,0) is not allowed");	
		
	}
	public Vector(Double3 xyz) 
	{
		super(xyz);
		if(this.equals(Double3.ZERO))
			throw new IllegalArgumentException("Vector(0,0,0) is not allowed");	

	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (!(obj instanceof Point)) 
			return false;
		Point other = (Point)obj;
		return super.equals(other);
	}
	
	@Override
	public String toString() { return "->" + super.toString(); }
	
	public Vector add(Vector vector)
	{
		return new Vector(xyz.add(vector.xyz));
	}
	
	public Vector scale(double scaler)
	{
		try
		{
			return new Vector(xyz.scale(scaler));
		}
		cha
	}
	
}
