/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.*;
import geometries.*;

/**
 * @author nogae
 *
 */
class CylinderTests {

	/**
	 * Test method for {@link geometries.Cylinder#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		Cylinder cyl=new Cylinder(new Ray(new Point(0,0,0),new Vector(0,0,1)),5,5);
		 // ============ Equivalence Partitions Tests ==============
		// TC01: point is on the side (like in tube): Test that the result of the normal vector of the point is proper 
		assertEquals(cyl.getNormal(new Point(0,-5,2)),new Vector(0,-1,0),"ERROR: Cylinder.getNormal() does not work correctly");
		// TC02: point is on the top: Test that the result of the normal vector of the point is proper 
		assertEquals(cyl.getNormal(new Point(0,2,5)),new Vector(0,0,1),"ERROR: Cylinder.getNormal() does not work correctly");
		// TC03: point is on the bottom: Test that the result of the normal vector of the point is proper 
		assertEquals(cyl.getNormal(new Point(0,2,0)),new Vector(1,0,0),"ERROR: Cylinder.getNormal() does not work correctly");

		// =============== Boundary Values Tests ==================
		// TC04: point is on the edge between the side and the top: Test that the points of the Plane are all different 
		assertThrows(IllegalArgumentException.class,
				() -> cyl.getNormal(new Point(0,5,5)), "ERROR: Cylinder.getNormal() does not work correctly");
		// TC05: point is on the edge between the side and the bottom: Test that the points of the Plane are all different 
		assertThrows(IllegalArgumentException.class,
				() -> cyl.getNormal(new Point(-5,0,0)), "ERROR: Cylinder.getNormal() does not work correctly");
	}

}