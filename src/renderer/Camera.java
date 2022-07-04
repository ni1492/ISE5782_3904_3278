
package renderer;

import primitives.*;
import static primitives.Util.isZero;
import java.util.stream.*;
import java.util.MissingResourceException;

public class Camera {
	private Point location;
	private Vector vRight;
	private Vector vUp;
	private Vector vTo;
	private double height;
	private double width;
	private double distance;
	private ImageWriter writer;
	private RayTracerBasic rayTracer;
	private static boolean multiThreading=true;
	private static boolean glossy=true;

	/**
	 * constructor (calculate the vector vRight
	 * 
	 * @param location: starting point of the camera
	 * @param vUp:      the vector vUp
	 * @param vTo:      the vector vTo
	 */
	public Camera(Point location, Vector vUp, Vector vTo) {
		if (!isZero(vUp.dotProduct(vTo))) {
			throw new IllegalArgumentException("vUp and vTo are not orthogonals");
		}
		this.location = location;
		this.vUp = vUp.normalize();
		this.vTo = vTo.normalize();
		this.vRight = vTo.crossProduct(vUp).normalize();
	}

	/**
	 * setting the size of the view plane for the camera
	 * 
	 * @param width:  double width
	 * @param height: double height
	 * @return the camera with the view plane setting
	 */
	public Camera setVPSize(double width, double height) {
		this.height = height;
		this.width = width;
		return this;
	}

	/**
	 * setting the distance between the view plane and the camera
	 * 
	 * @param distance: double distance
	 * @return the camera with the distance size
	 */
	public Camera setVPDistance(double distance) {
		this.distance = distance;
		return this;
	}

	/**
	 * find the ray that pass through the pixel [i,j]
	 * 
	 * @param nX number of columns(width of rows)-resolution
	 * @param nY number of rows(height of columns)-resolution
	 * @param j  index of column-plane
	 * @param i  index of row-plane
	 * @return the ray that pass through the pixel given
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {
		// image center
		Point Pc = location.add(vTo.scale(distance));

		// ratios for the pixels
		double Rx = width / nX;
		double Ry = height / nY;

		// calculate how much to move from center
		double Xj = (j - ((nX - 1) / 2d)) * Rx;
		double Yi = -(i - ((nY - 1) / 2d)) * Ry;

		// the point represent the pixel
		Point Pij = Pc;
		if (Xj != 0)
			Pij = Pij.add(vRight.scale(Xj));
		if (Yi != 0)
			Pij = Pij.add(vUp.scale(Yi));

		// direction of the ray - from the location of the camera towards the pixel
		// point
		// the ray constructed by the camera
		return new Ray(location, Pij.subtract(location));
	}

	/**
	 * setting the writer image to create an image
	 * 
	 * @param writer ImageWriter: the writer which create the picture
	 * @return the camera with the new details
	 */
	public Camera setWriter(ImageWriter writer) {
		this.writer = writer;
		return this;
	}

	/**
	 * setting the ray tracer for the camera
	 * 
	 * @param ray RayTracerBase: the ray to trace the objects???????????
	 * @return the camera with the new details
	 */
	public Camera setRayTracerBasic(RayTracerBasic ray) {
		this.rayTracer = ray;
		rayTracer.setImprovement(glossy);
		return this;
	}

	/**
	 * check if all he fields are set
	 * creating the image in the writer
	 */ 
	public void renderImage() {
		if (location == null || vRight == null || vUp == null || vTo == null || writer == null || rayTracer == null
				|| Double.isNaN(height) || Double.isNaN(width) || Double.isNaN(distance))
			throw new MissingResourceException("not all the fields are set", null, null);
		Color color;
		if(multiThreading)
		{
			
			Pixel.initialize(writer.getNy(), writer.getNx(), 60);
			IntStream.range(0, writer.getNy()).parallel().forEach(i->{
				IntStream.range(0, writer.getNx()).parallel().forEach(j->{
					writer.writePixel(j,i,rayTracer.traceRay(this.constructRay(writer.getNx(), writer.getNy(), j, i)));					Pixel.pixelDone();
					Pixel.printPixel();
				});
			});
		}
		else
		{
			for (int i = 0; i < writer.getNx(); i++) {
				for (int j = 0; j < writer.getNy(); j++) {
					color = rayTracer.traceRay(this.constructRay(writer.getNx(), writer.getNy(), j, i));
					writer.writePixel(j, i, color);
					if(j%100==0)
						writer.writeToImage();
				}
			}
	
		}
	}
	
	/**
	 * create a grid for the image
	 * 
	 * @param interval int: the height and the width of every square in the grid
	 * @param color    Color: the color of the grid
	 */
	public void printGrid(int interval, Color color) {
		if (writer == null)
			throw new MissingResourceException("the writer isn't set yet", null, null);
		for (int i = 0; i < writer.getNx(); i++) {
			for (int j = 0; j < writer.getNy(); j++) {
				if (i % interval == 0 || j % interval == 0) {
					writer.writePixel(i, j, color); 
				}
			}
		}
	}

	/**
	 * create an image
	 */
	public void writeToImage() {
		if (writer == null)
			throw new MissingResourceException("the writer isn't set yet", null, null);
		writer.writeToImage();
	}
	
	public Camera setImprovments( boolean multiThreading, boolean glossy) {
		this.glossy=glossy;
		this.multiThreading=multiThreading;
		return this;
	}
}
