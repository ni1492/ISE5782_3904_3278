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
		return findGeoIntersectionsHelper(ray, Double.POSITIVE_INFINITY);
	}
	/**
	 * 
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


