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
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		 // ============ Equivalence Partitions Tests ==============
		Sphere s=new Sphere(new Point(0,0,0),4);
		Point p=new Point(0,0,4);
		Vector normal=new Vector(0,0,1);
		// TC01: Test that the result of the normal vector of the point is proper 
		assertEquals(s.getNormal(p),normal,"ERROR: Sphere.getNormal() does not work correctly");

}

}
