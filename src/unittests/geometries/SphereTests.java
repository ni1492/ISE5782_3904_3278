/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;

import geometries.*;
import primitives.*;
/**
 *
 */
class SphereTests 
{

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
		assertEquals(normal,s.getNormal(p),"ERROR: Sphere.getNormal() does not work correctly");
	}
	/**
     * Test method for {@link geometries.Sphere#findIntersections(primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
    	Sphere sphere = new Sphere(new Point (1, 0, 0),1d);

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(1, 1, 0))),
                   "TC1: Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        Point p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0),
                                                                new Vector(3, 1, 0)));
        assertEquals(2, result.size(), "TC2: Wrong number of points");        
        assertEquals(result,List.of(p1, p2),"TC2: Ray crosses sphere");
        
        // TC03: Ray starts inside the sphere (1 point)
        Point p3=new Point(2,0,0);
        List<Point> result3 = sphere.findIntersections(new Ray(new Point(1.1, 0.1, 0.1),
                new Vector(0.9,-0.1,-0.1)));
        assertEquals(1, result3.size(), "TC3: Wrong number of points");        
        assertEquals(result3,List.of(p3),"TC3: Ray crosses sphere");  
        
        // TC04: Ray starts after the sphere (0 points)
        p1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        p2 = new Point(1.53484692283495, 0.844948974278318, 0);
        result = sphere.findIntersections(new Ray(new Point(-1, 0, 0),
                                                                new Vector(-3, -1, 0)));
        assertNull(result,"TC4: Ray's line out of sphere");   
 
        
      

        // =============== Boundary Values Tests ==================

        // ** Group: Ray's line crosses the sphere (but not the center)
        // TC5: Ray starts at sphere and goes inside (1 points)
        p1=new Point(1,0,1);
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(-1, 0, 1)));
        assertEquals(1, result.size(), "TC5: Wrong number of points");        
        assertEquals(result,List.of(p1),"TC5: Ray crosses sphere");

        // TC6: Ray starts at sphere and goes outside (0 points)
        p1=new Point(1,0,1);
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(1, 0, -1)));
        assertNull(result,"TC6: Ray's line out of sphere");  
        
        //check opposite direction to check if the ray intersects with the sphere
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(-1, 0, 1)));
        assertEquals(1, result.size(), "TC6: Wrong number of points in the opposite direction");        
        assertEquals(result,List.of(p1),"TC6: Opposite ray crosses sphere");
        
        
        // ** Group: Ray's line goes through the center
        // TC7: Ray starts before the sphere (2 points)
        p1=new Point(2,0,0);
        p2=new Point(0,0,0);
        result = sphere.findIntersections(new Ray(new Point(3, 0, 0),
                        new Vector(-1, 0, 0)));
        assertEquals(2, result.size(), "TC7: Wrong number of points");        
        assertEquals(result,List.of(p1, p2),"TC7: Ray crosses sphere");
        
        // TC8: Ray starts at sphere and goes inside (1 points)
        p1=new Point(0,0,0);
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                        new Vector(-1, 0, 0)));
        assertEquals(1, result.size(), "TC8: Wrong number of points");        
        assertEquals(result,List.of(p1),"TC8: Ray crosses sphere");
        //check that the ray in the opposite direction has no intersections with the sphere
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(1, 0, 0)));
        assertNull(result,"TC8: Ray's line out of sphere");  

        // TC9: Ray starts inside (1 points)
        p1=new Point(0,0,0);        
        result = sphere.findIntersections(new Ray(new Point(0.5, 0, 0),
                        new Vector(-1, 0, 0)));
        assertEquals(1, result.size(), "TC9: Wrong number of points");        
        assertEquals(result,List.of(p1),"TC9: Ray crosses sphere");
      
        
        // TC10: Ray starts at the center (1 points)
        result = sphere.findIntersections(new Ray(new Point(1, 0, 0), new Vector(2, 0, 0)));
        Point po=new Point(2,0,0);  
        assertEquals(1, result.size(), "TC10: Wrong number of points"); 
        assertEquals(result,List.of(po),"TC10: Ray crosses sphere");
        
        
        
        // TC11: Ray starts at sphere and goes outside (0 points)
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(1, 0, 0)));
        assertNull(result,"TC11: Ray's line out of sphere");
        
     
        
        
        // TC12: Ray starts after sphere (0 points)
        result = sphere.findIntersections(new Ray(new Point(3, 0, 0),
                new Vector(1, 0, 0)));
        assertNull(result,"TC12: Ray's line out of sphere");
        
        // ** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC13: Ray starts before the tangent point
        result = sphere.findIntersections(new Ray(new Point(2, 1, 0),
                new Vector(0, -1, 0)));
        assertNull(result,"TC13: Ray's line out of sphere");
        
        // TC14: Ray starts at the tangent point
        result = sphere.findIntersections(new Ray(new Point(2, 0, 0),
                new Vector(0, -1, 0)));
        assertNull(result,"TC14: Ray's line out of sphere");
        
        // TC15: Ray starts after the tangent point
        result = sphere.findIntersections(new Ray(new Point(2, 1, 0),
                new Vector(0, 1, 0)));
        assertNull(result,"TC15: Ray's line out of sphere");
        
     
        // ** Group: Special cases
        // TC16: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        result = sphere.findIntersections(new Ray(new Point(3, 0, 0),
                new Vector(0, 1, 0)));
        assertNull(result,"TC16: Ray's line out of sphere");
}
}