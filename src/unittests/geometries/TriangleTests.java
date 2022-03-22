/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import geometries.*;
import primitives.*;


/**
 * @author nogae
 *
 */
class TriangleTests {

	/**
	 * Test method for {@link geometries.Triangle#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
		Triangle t=new Triangle(new Point(0,0,0),new Point(0,0,1),new Point(0,1,0));
		Point p=new Point(0,0,0);
		Vector normal=new Vector(1,0,0);
		// TC01: Test that the result of the normal vector of the point is proper 
		assertEquals(t.getNormal(p),normal,"ERROR: Triangle.getNormal() does not work correctly");

}

}
