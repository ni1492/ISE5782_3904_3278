/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import primitives.*;
import geometries.*;
/**
 *
 */
class TubeTests {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Tube tube=new Tube(new Ray(new Point(0,0,0),new Vector(0,0,1)),5);
		 //TC01: Test that the result of the normal vector of the point is proper 
		assertEquals(tube.getNormal(new Point(5,0,1)),new Vector(1,0,0),"ERROR: Tube.getNormal() does not work correctly");
        // =============== Boundary Values Tests ==================
		 //TC02: Test that the result of the normal vector of the point is proper when the point is parallel to the starting point of the ray
		assertEquals(tube.getNormal(new Point(5,0,0)),new Vector(1,0,0),"ERROR: Tube.getNormal() does not work correctly");

	}
	@Test
	void testFindIntersections()
	{
		
	}

}
