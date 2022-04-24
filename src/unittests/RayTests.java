package unittests;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import primitives.*;

public class RayTests {

	@Test
	void testfindClosestPoint() {
		// ============ Equivalence Partitions Tests ==============
		Ray ray=new Ray(new Point(1,0,0),new Vector(1,0,0));
	    // TC01: the point in the middle of the list is closest to the starting point of the ray
		 List<Point> points=new ArrayList<Point>();
		 points.add(new Point(3,0,0));
		 points.add(new Point(2,0,0));
		 points.add(new Point(4,0,0));
		 
		 assertEquals(new Point(2,0,0), ray.findClosestPoint(points), "ERROR: findClosestPoint() does not work correctly");
		 // =============== Boundary Values Tests ==================
		// TC02: the list of points is empty and the function returns null
		points.clear();
		
		assertEquals(null,ray.findClosestPoint(points),"ERROR: findClosestPoint() does not work correctly");
		// TC03: the first point in the list is the closest one to the starting point of the ray 
		points.add(new Point(2,0,0));
		points.add(new Point(3,0,0));
		points.add(new Point(4,0,0));
		
		assertEquals(new Point(2,0,0),ray.findClosestPoint(points),"ERROR: findClosestPoint() does not work correctly");
		// TC04: the last point in the list is the closest one to the starting point of the ray 
		points.clear();
		points.add(new Point(4,0,0));
		points.add(new Point(3,0,0));
		points.add(new Point(2,0,0));
		
		 assertEquals(new Point(2,0,0), ray.findClosestPoint(points), "ERROR: findClosestPoint() does not work correctly");
	}
}
