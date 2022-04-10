package renderer;

import primitives.*;
import static primitives.Util.isZero;

public class Camera {
	private Point location;
	private Vector vRight;
	private Vector vUp;
	private Vector vTo;
	private double height;
	private double width;
	private double distance;

	/**
	 * 
	 * @param location
	 * @param vUp
	 * @param vTo
	 */
	public Camera(Point location, Vector vUp, Vector vTo) {
		if (!isZero(vUp.dotProduct(vTo))) {
			throw new IllegalArgumentException("vUp and vTo are not orthogonals");	
		}
		this.location = location;
		this.vUp = vUp.normalize();
		this.vTo = vTo.normalize();
		this.vRight=vUp.crossProduct(vTo).normalize();
	}
	/**
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public Camera setVPSize(double width, double height)
	{
		this.height=height;
		this.width=width;
		return this;
	}
	/**
	 * 
	 * @param distance
	 * @return
	 */
	public Camera setVPDistance(double distance)
	{
		this.distance=distance;
		return this;
	}
	/**
	 * 
	 * @param nX number of columns(width of rows)-resolution
	 * @param nY number of rows(height of columns)-resolution
	 * @param j index of column-plane
	 * @param i index of row-plane
	 * @return
	 */
	public Ray constructRay(int nX, int nY, int j, int i)
	{
		return null;
	}
}
