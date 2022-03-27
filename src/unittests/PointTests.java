/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import primitives.*;
import geometries.*;
import static primitives.Util.isZero;
/**
 * @author nogae
 *
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 */
	@Test
	void testAdd() {
		 // ============ Equivalence Partitions Tests ==============
		Point p1=new Point(2,4,6);
		Vector v1= new Vector(1,1,2);
		Point result=new Point(3,5,8);
		// TC01: Test that the result of adding vector to point is proper 
		//Point+Vector=Point
		assertEquals(p1.add(v1),result,"ERROR: Point.add() does not work correctly");
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	void testSubtract() {
		 // ============ Equivalence Partitions Tests ==============
		Point p1=new Point(2,4,6);
		Point p2= new Point(1,1,2);
		Vector result=new Vector(1,3,4);
		// TC01: Test that the result of subtracting Point from point is proper 
		//Point-Point=Vector
		assertEquals(p1.subtract(p2),result,"ERROR: Point.subtract() does not work correctly");
	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	void testDistanceSquared() {
		// ============ Equivalence Partitions Tests ==============
		Point p1=new Point(4,6,8);
		Point p2=new Point(3,2,-1);
		Double result=98.0;
		// TC01: Test that the calculation of the distance squared between two Points is proper 
		assertEquals(p1.distanceSquared(p2),result,"ERROR: Point.distanceSquared() wrong value");
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() {
		// ============ Equivalence Partitions Tests ==============
		Point p1=new Point(2,3,2);
		Point p2=new Point(2,1,-4);
		Double result=Math.sqrt(40);
		// TC01: Test that the calculation of the distance between two Points is proper 
		assertEquals(p1.distance(p2),result,"ERROR: Point.distance() wrong value");
	}

}
