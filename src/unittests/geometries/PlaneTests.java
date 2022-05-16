/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.*;
import geometries.Intersectable.GeoPoint;
import primitives.*;

/**
 *
 */
class PlaneTests {
	@Test
	public void testConstructor()
	{
        // =============== Boundary Values Tests ==================
		// TC01: Test that the points of the Plane are all different 
		assertThrows(IllegalArgumentException.class,()->new Plane(new Point(0,0,1)
				,new Point(0,0,1),new Point(0,1,0)),"ERROR: Plane.constructor() cannot create plane with only two different points");
		// TC02: Test that the result of the normal vector of the point is proper 
		assertThrows(IllegalArgumentException.class,()->new Plane(new Point(0,0,1)
				,new Point(0,0,2),new Point(0,0,3)),"ERROR: Plane.constructor() cannot create plane with three points on the same ray");

	}
	
	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormalPoint() {
		// ============ Equivalence Partitions Tests ==============
		Plane plane=new Plane(new Point(0,0,0),new Point(0,0,1),new Point(0,1,0));
		Point p=new Point(0,0,0);
		Vector normal1=new Vector(1,0,0);
		Vector normal2=new Vector(-1,0,0);
		Vector result=plane.getNormal(p);
		 //TC01: Test that the result of the normal vector of the point is proper 
		assertTrue(result.equals(normal1) || result.equals(normal2),"ERROR: Plane.getNormal() does not work correctly");
	
		//Vector normal=plane.getNormal(p);
		// TC01: Test that the normal vector is a unit vector 
		//assertEquals(normal.length(),1,"ERROR: Plane.getNormal() the normalized vector is not a unit vector");
		// TC02: Test that the normal vector is parallel to the expected normal
		//assertThrows(IllegalArgumentException.class, () -> normal.crossProduct(new Vector(1,0,0)),"ERROR: Plane.getNormal() the normalized vector is not parallel to the original one");
		
	}
	@Test
	void testFindIntersections() {
        Plane plane = new Plane(new Point(2, 0, 0), new Vector(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray intersects the plane
        List<Point> result = plane.findIntersections(new Ray(new Point(1,0,0), new Vector(1,-2,0)));
        List<Point> check = new ArrayList<Point>();
        check.add(new Point(2,-2,0));
        assertEquals(check, result, "Ray crosses plane, and the function didn't find the croos point");
             
        // TC02: Ray does not intersect the plane
        result = plane.findIntersections(new Ray(new Point(1,0,0), new Vector(-1,0,1)));
        assertEquals(null, result, "Ray does not crosses plane, and the function think it does, and i don't know why, my partner did this part :)");

        // =============== Boundary Values Tests ==================

        // TC3: Ray is parallel to the plane and included in it
        result = plane.findIntersections(new Ray(new Point(2,0,0), new Vector(0,0,1)));
        assertEquals(null, result, "Ray is parallel to the plane and included in it");

        // TC4: Ray is parallel to the plane and not included in it
        result = plane.findIntersections(new Ray(new Point(1,0,0), new Vector(0,0,1)));
        assertEquals(null, result, "Ray parallel to the plane and not included in it, but the function think it does");

        // TC5: Ray is orthogonal to the plane and P0 is before the plane
        result = plane.findIntersections(new Ray(new Point(1,0,0), new Vector(1,0,0)));
        check = new ArrayList<Point>();
        check.add(new Point(2,0,0));
        assertEquals(check, result, "Ray is orthogonal to the plane and P0 is before the plane - one intsersection point");

        // TC6: Ray is orthogonal to the plane and P0 is in the plane
        result = plane.findIntersections(new Ray(new Point(2,0,1), new Vector(1,0,0)));
        check = new ArrayList<Point>();
        check.add(new Point(2,0,1));
        assertEquals(check, result, "Ray is orthogonal to the plane and P0 is in the plane - p0 is intsersection point");

        // TC7: Ray is orthogonal to the plane and P0 is after the plane
        result = plane.findIntersections(new Ray(new Point(3,0,0), new Vector(1,0,0)));
        assertEquals(null, result, "Ray is orthogonal to the plane and P0 is after the plane - no intsersection point");

        // TC8: Ray is neither orthogonal nor parallel to the plane and begins at the plane
        List<Point> result1 = plane.findIntersections(new Ray(new Point(2,1,1), new Vector(1,-2,-2)));
        List<Point> check1 = new ArrayList<Point>();
        check1.add(new Point(2,1,1));
        assertEquals(check1, result1, "Ray is neither orthogonal nor parallel to the plane and begins at the plane");

        // TC9: Ray is neither orthogonal nor parallel to the plane and begins in
        //the same point which appears as reference point in the plane
        List<Point> result2 = plane.findIntersections(new Ray(new Point(2,0,0), new Vector(1,-2,-2)));
        List<Point> check2 = new ArrayList<Point>();
        check2.add(new Point(2,0,0));
        assertEquals(check2, result2, "Ray is neither orthogonal nor parallel to the plane and begins in " +
                "the same point which appears as reference point in the plane");

    }
/*
	void testFindGeoIntersections() {
        Plane plane = new Plane(new Point(2, 0, 0), new Vector(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray intersects the plane
        List<GeoPoint> result = plane.findGeoIntersections(new Ray(new Point(1,0,0), new Vector(1,-2,0)),3);
        List<GeoPoint> check = new ArrayList<GeoPoint>();
        check.add(new GeoPoint(plane,new Point(2,-2,0)));
        assertEquals(check, result, "Ray crosses plane, and the function didn't find the croos point");
             
        result = plane.findGeoIntersections(new Ray(new Point(1,0,0), new Vector(1,-2,0)),1);
        assertEquals(null, result, "Ray crosses plane, but the distance is too far");

        // =============== Boundary Values Tests ==================

        // TC5: Ray is orthogonal to the plane and P0 is before the plane
        result = plane.findGeoIntersections(new Ray(new Point(1,0,0), new Vector(1,0,0)),3);
        check = new ArrayList<GeoPoint>();
        check.add(new GeoPoint(plane,new Point(2,0,0)));
        assertEquals(check, result, "Ray is orthogonal to the plane and P0 is before the plane - one intsersection point");
       
        result = plane.findGeoIntersections(new Ray(new Point(1,0,0), new Vector(1,0,0)),1);
        assertEquals(null, result, "Ray is orthogonal to the plane and P0 is before the plane - but the distance is too far");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // TC6: Ray is orthogonal to the plane and P0 is in the plane
        result = plane.findGeoIntersections(new Ray(new Point(2,0,1), new Vector(1,0,0)));
        check = new ArrayList<GeoPoint>();
        check.add(new GeoPoint(plane,new Point(2,0,1)));
        assertEquals(check, result, "Ray is orthogonal to the plane and P0 is in the plane - p0 is intsersection point");

        // TC8: Ray is neither orthogonal nor parallel to the plane and begins at the plane
        List<Point> result1 = plane.findIntersections(new Ray(new Point(2,1,1), new Vector(1,-2,-2)));
        List<Point> check1 = new ArrayList<Point>();
        check1.add(new Point(2,1,1));
        assertEquals(check1, result1, "Ray is neither orthogonal nor parallel to the plane and begins at the plane");

        // TC9: Ray is neither orthogonal nor parallel to the plane and begins in
        //the same point which appears as reference point in the plane
        List<Point> result2 = plane.findIntersections(new Ray(new Point(2,0,0), new Vector(1,-2,-2)));
        List<Point> check2 = new ArrayList<Point>();
        check2.add(new Point(2,0,0));
        assertEquals(check2, result2, "Ray is neither orthogonal nor parallel to the plane and begins in " +
                "the same point which appears as reference point in the plane");

    }
*/
}
