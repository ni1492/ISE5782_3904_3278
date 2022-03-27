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

}
