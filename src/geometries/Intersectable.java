package geometries;

import java.util.List;
import java.util.Objects;

import primitives.*;
/**
 * the class that represent the classes Geometries and Geometry
 * @author nogae
 *
 */
public abstract class Intersectable 
{
	public static final boolean BVH=true;

	/**
	* class representing boundary box
	*/
	public class BoundingBox {
		public Point _minimums;
		public Point _maximums;
		public BoundingBox(Point minimums, Point maximums) {
			_minimums = minimums;
			_maximums = maximums;
			}
	}
	
	public BoundingBox box;
	
	/**
	* return true if ray intersects object
	*
	* @param ray ray to check
	* @return whether ray intersects box
	* code taken from scratchapixel.com
	* https://www.scratchapixel.com/lessons/3d-basic-rendering/introductionacceleration-structure/bounding-volume-hierarchy-BVH-part1
	*/
	public boolean intersectingBoundingBox(Ray ray) {
	 if (!BVH || box == null)
		 return true;
	 Vector dir = ray.getDir();
	 Point p0 = ray.getP0();
	 
	 double xMin = (box._minimums.getXyz().getD1() - p0.getXyz().getD1()) / dir.getXyz().getD1();
	 double xMax = (box._maximums.getXyz().getD1() - p0.getXyz().getD1()) / dir.getXyz().getD1();
	
	if (xMin > xMax) {
		double temp = xMin;
		xMin = xMax;
		xMax = temp;
	 }
	 double yMin = (box._minimums.getXyz().getD2() - p0.getXyz().getD2()) / dir.getXyz().getD2();
	 double yMax = (box._maximums.getXyz().getD2() - p0.getXyz().getD2()) / dir.getXyz().getD2();
	
	 if (yMin > yMax) {
		 double temp = yMin;
		 yMin = yMax;
		 yMax = temp;
	 }
	 
	 if ((xMin > yMax) || (yMin > xMax))
		 return false;
	
	 if (yMin > xMin)
		 xMin = yMin;
	
	 if (yMax < xMax)
		 xMax = yMax;
	
	 double zMin = (box._minimums.getXyz().getD3() - p0.getXyz().getD3()) / dir.getXyz().getD3();
	 double zMax = (box._maximums.getXyz().getD3() - p0.getXyz().getD3()) / dir.getXyz().getD3();
	 if (zMin > zMax) {
		 double temp = zMin;
		 zMin = zMax;
		 zMax = temp;
	 }
	 
	 if ((xMin > zMax) || (zMin > xMax))
		 return false;
	 
	 if (zMin > xMin)
		 xMin = zMin;
	
	 if (zMax < xMax)
		 xMax = zMax;
	
	 return true;
	}

	/**
	 * create the boundary box for the objects
	 */
	public abstract void createBoundingBox();
	
	/**
	 * Deprecated function! no longer in use.
	 * the func gets ray and returns list of intersections with the geometry
	 * @param ray type- the ray that intersects with the shape 
	 * @return List of intersections points with the shape
	 */
	public abstract List<Point> findIntersections(Ray ray);
	
	/**
	 * new representation for a Point thats on a geometry object.
	 *
	 */
	public class GeoPoint{
		public Geometry geometry;
		public Point point;
		/**
		 * constructor that build a new  GeoPoint object
		 * @param geometry: Geometry object that the point is on
		 * @param point: Point object which define the location of the point in space
		 */
		public GeoPoint(Geometry geometry, Point point) {
			this.geometry = geometry;
			this.point = point;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(geometry, point);
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeoPoint other = (GeoPoint) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(geometry, other.geometry) && Objects.equals(point, other.point);
		}
		/**
		 * help function for equals function
		 * @return this 
		 */
		private Intersectable getEnclosingInstance() {
			return Intersectable.this;
		}

		@Override
		public String toString() {
			return "GeoPoint: geometry=" + geometry + ", point=" + point;
		}
		
		
		
		
	}
	/**
	 * the func gets ray and returns list of intersections with the geometry NVI pattern
	 * @param ray type- the ray that intersects with the shape
	 * @return List of intersections GeoPoints with the shape
	 */
	public final  List<GeoPoint> findGeoIntersections(Ray ray){
		if(BVH && !intersectingBoundingBox(ray))
			return null;
		return findGeoIntersectionsHelper(ray, Double.POSITIVE_INFINITY);
	}
	/**
	 * BONUS: max distance
	 * the func gets ray and returns list of intersections with the geometry NVI pattern
	 * @param ray type- the ray that intersects with the shape
	 * @param maxDistance - double distance
	 * @return List of intersections GeoPoints with the shape in the given distance
	 * 	 */
	public final  List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance){
		return findGeoIntersectionsHelper(ray, maxDistance);
	}

	/**
	 * helper function for findGeoIntersections
	 * @param ray type- the ray that intersects with the shape
	 * @param maxDistance - double distance
	 * @return List of intersections GeoPoints with the shape in the given distance
	 */
	protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance);

	
	
}


