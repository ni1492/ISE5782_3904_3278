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
	 * constructor (calculate the vector vRight
	 * @param location: starting point of the camera
	 * @param vUp: the vector vUp 
	 * @param vTo: the vector vTo
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
	 * setting the size of the view plane for the camera
	 * @param width: double width
	 * @param height: double height
	 * @return the camera with the view plane setting
	 */
	public Camera setVPSize(double width, double height)
	{
		this.height=height;
		this.width=width;
		return this;
	}
	/**
	 * setting the distance between the view plane and the camera
	 * @param distance: double distance
	 * @return the camera with the distance size
	 */
	public Camera setVPDistance(double distance)
	{
		this.distance=distance;
		return this;
	}
	/**
	 * find the ray that pass through the pixel [i,j]
	 * @param nX number of columns(width of rows)-resolution
	 * @param nY number of rows(height of columns)-resolution
	 * @param j index of column-plane
	 * @param i index of row-plane
	 * @return the ray that pass through the pixel given
	 */
	public Ray constructRay(int nX, int nY, int j, int i)
	{
		// image center
        Point Pc = location.add(vTo.scale(distance));

        // ratios for the pixels
        double Rx = width / nX;
        double Ry = height / nY;

        // pixel center
        double Xj = (j - ((nX - 1) / 2d)) * Rx;
        double Yi = -(i - ((nY - 1) / 2d)) * Ry;

        // the point represent the pixel
        Point Pij = Pc;
        if(Xj != 0)
            Pij = Pij.add(vRight.scale(Xj));
        if(Yi != 0)
            Pij = Pij.add(vUp.scale(Yi));

        // direction of the ray - from the location of the camera towards the pixel point
        // the ray constructed by the camera
        return new Ray(location, Pij.subtract(location));
	}
}
