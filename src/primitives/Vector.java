package primitives;

public class Vector extends Point
{

	public Vector(double x, double y, double z) 
	{
		super(x, y, z);
		if(this.xyz.equals(Double3.ZERO))
			throw new IllegalArgumentException("Vector(0,0,0) is not allowed");	
		
	}
	public Vector(Double3 xyz) 
	{
		super(xyz);
		if(this.xyz.equals(Double3.ZERO))
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
		catch(IllegalArgumentException Execption)
		{
			throw new IllegalArgumentException("Vector(0,0,0) is not allowed");	
		}
	}
	
	public double dotProduct (Vector other)
	{
		double d1=other.xyz.d1;
		double d2=other.xyz.d2;
		double d3=other.xyz.d3;

		return (xyz.d1*d1+xyz.d2*d2+xyz.d3*d3);
	}
	
	public Vector crossProduct(Vector other)
	{
		double x1 = xyz.d1;
        double x2 = other.xyz.d1;
        double y1 = xyz.d2;
        double y2 = other.xyz.d2;
        double z1 = xyz.d3;
        double z2 = other.xyz.d3;
        double i = y1 * z2 - z1 * y2;
        double j = z1 * x2 - x1 * z2;
        double k = x1 * y2 - y1 * x2;
        return new Vector(i, j, k);
	}
	
	public double lengthSquared()
	{
		return (xyz.d1)*(xyz.d1)+(xyz.d2)*(xyz.d2)+(xyz.d3)*(xyz.d3);
	}
	
	public double length()
	{
		return Math.sqrt(this.lengthSquared());
	}
	
	public Vector normalize()
	{
		return new Vector(this.xyz.reduce(this.length()));
	}
}
