package unittests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.*;
import primitives.*;

class GeometriesTests {

	@Test
	void test() {

		// ============ Equivalence Partitions Tests ==============

		// TC01: Some shapes intersects but not all of them
		Geometries lst1 = new Geometries();
		Plane p1 = new Plane(new Point(1,0,0), new Vector(0,0,1));
		lst1.add(p1);
		Plane p2 = new Plane(new Point(0,0,3), new Vector(0,0,1));
		lst1.add(p2);
		Triangle t = new Triangle(new Point(3,0,3), new Point(0,3,3), new Point(-3,-3,3));
		lst1.add(t);
		List<Point> result = lst1.findIntersections(new Ray(new Point(0, 0, 2), new Vector(0,0,1)));
		assertEquals(2, result.size(), "Some shapes intsersects but not all of them");

		// =============== Boundary Values Tests ==================

		// TC10: Empty shapes collection
		Geometries lst2 = new Geometries();
		assertEquals(null, lst1, "Empty shapes collection");

		// TC11: None of the shapes intersects
		p1 = new Plane(new Point(1,0,0), new Vector(0,0,1));
		lst2.add(p1);
		p2 = new Plane(new Point(0,0,1), new Vector(0,0,1));
		lst2.add(p2);
		t = new Triangle(new Point(3,0,1), new Point(0,3,1), new Point(-3,-3,1));
		lst2.add(t);
		result = lst2.findIntersections(new Ray(new Point(0, 0, 2), new Vector(0,0,1)));
		assertEquals(null, result, "None of the shapes intsersects");

		// TC12: Only one shape intersects
		Geometries lst3 = new Geometries();
		p1 = new Plane(new Point(1,0,0), new Vector(0,0,1));
		lst3.add(p1);
		p2 = new Plane(new Point(0,0,1), new Vector(0,0,1));
		lst3.add(p2);
		t = new Triangle(new Point(3,0,3), new Point(0,3,3), new Point(-3,-3,3));
		//p2 = new Plane(new Point(0,0,3), new Vector(0,0,1));
		lst3.add(p2);
		result = lst3.findIntersections(new Ray(new Point(0, 0, 2), new Vector(0,0,1)));
		assertEquals(1, result.size(), "Only one shape intsersects");
		//List<Point> check = new ArrayList<Point>();
		//check.add(new Point(1,1,0));
		//assertEquals(check, result, "None of the shapes intersects");

		// TC13: All of the shapes intersects
		Geometries lst4 = new Geometries();
		p1 = new Plane(new Point(0,0,4), new Vector(0,0,1));
		lst4.add(p1);
		p2 = new Plane(new Point(0,0,3), new Vector(0,0,1));
		lst4.add(p2);
		t = new Triangle(new Point(3,0,3), new Point(0,3,3), new Point(-3,-3,3));
		lst4.add(p2);
		result = lst4.findIntersections(new Ray(new Point(0, 0, 2), new Vector(0,0,1)));
		assertEquals(2, result.size(), "All of the shapes intsersects");


	
	}
}
