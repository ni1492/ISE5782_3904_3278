package primitives;

/**
 * class vector - primitive.
 *
 */
public class Vector extends Point
{
	/**
	 * vector class constructor - receives three points
	 * @param x - point x
	 * @param y - point y
	 * @param z - point z
	 */
	public Vector(double x, double y, double z) 
	{
		super(x, y, z);
		if(this.xyz.equals(Double3.ZERO))
			throw new IllegalArgumentException("Vector(0,0,0) is not allowed");	
		
	}
	
	/**
	 * vector class constructor - receives three points
	 * @param xyz - Double3 point
	 */
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
	
	/**
	 * add function - receives a vector and returns the addition of the current vector and the new vector.
	 */
	public Vector add(Vector vector)
	{
		return new Vector(xyz.add(vector.xyz));
	}
	
	/**
	 * scale function
	 * @param scaler receives a number
	 * @return returns the vector after multiplying each of the values in it with the number received
	 */
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
	
	/**
	 * dot product function
	 * @param other receives another vector
	 * @return returns a number - the dot product of the two vectors
	 */
	public double dotProduct (Vector other)
	{
		double d1=other.xyz.d1;
		double d2=other.xyz.d2;
		double d3=other.xyz.d3;

		return (xyz.d1*d1+xyz.d2*d2+xyz.d3*d3);
	}
	
	/**
	 * cross product function
	 * @param other receives another vector
	 * @return returns a vector - the cross product of the two vectors
	 */
	public Vector crossProduct(Vector other)
	{
		if(((this.xyz.d1/other.xyz.d1)==(this.xyz.d2/other.xyz.d2))&&((this.xyz.d1/other.xyz.d1)==(this.xyz.d3/other.xyz.d3)))
			throw new IllegalArgumentException("the vectors are parallel- cannot calculate crossProduct");
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
	
	/**
	 * length squared function
	 * @return returns the squared length of the vector
	 */
	public double lengthSquared()
	{
		return (xyz.d1)*(xyz.d1)+(xyz.d2)*(xyz.d2)+(xyz.d3)*(xyz.d3);
	}
	
	/**
	 * length function
	 * @return returns the length of the vector
	 */
	public double length()
	{
		return Math.sqrt(this.lengthSquared());
	}
	
	/**
	 * normalize function 
	 * @return returns the normalized vector (length=1)
	 */
	public Vector normalize()
	{
		double scale=1/this.length();
		return this.scale(scale);
		//return new Vector(this.xyz.reduce(this.length())); 
	}
}
