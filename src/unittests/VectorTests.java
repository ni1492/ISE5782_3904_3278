/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import primitives.*;
import geometries.*;
import static primitives.Util.isZero;
import primitives.Vector;
/**
 * @author nogae
 *
 */
class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}.
	 */
	@Test
	void testAddVector() {
        // ============ Equivalence Partitions Tests ==============
		Vector v1= new Vector(1,1,2);
		Vector v2=new Vector(2,4,6);
		Vector result=new Vector(3,5,8);
		// TC01: Test that the result of adding vectors is proper 
		assertEquals(v1.add(v2),result,"ERROR: Vector.add() does not work correctly");
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	void testScale() {
        // ============ Equivalence Partitions Tests ==============
		Vector v1=new Vector(4,6,8);
		double scalar=4.5;
		Vector result=new Vector(18,27,36);
		// TC01: Test that the result of multiplying vector by scalar is proper 
		assertEquals(v1.scale(scalar),result,"ERROR: Vector.scale() does not work correctly");

	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	// !!!!
	@Test
	void testDotProduct() {
		// ============ Equivalence Partitions Tests ==============
		Vector v1=new Vector(4,6,8);
		Vector v2=new Vector(2,-2,3);
		Vector v3=new Vector(2,0,-1);
		// TC01: Test that the dot product of two vectors is proper 
		assertTrue(isZero(v1.dotProduct(v2)-20),"ERROR: Vector.dotProduct() does not work correctly");
        // =============== Boundary Values Tests ==================
		// TC02: Test that the dot product of orthogonal vectors is proper and that the result is zero 
		assertTrue(isZero(v1.dotProduct(v3)),"ERROR: Vector.dotProduct() for orthogonal vectors is not zero");
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);

        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals(v1.length() * v2.length(), vr.length(), 0.00001, "crossProduct() wrong result length");

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue(isZero(vr.dotProduct(v1)), "crossProduct() result is not orthogonal to 1st operand");
        assertTrue(isZero(vr.dotProduct(v2)), "crossProduct() result is not orthogonal to 2nd operand");

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-productof co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v3),
                     "crossProduct() for parallel vectors does not throw an exception");
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	void testLengthSquared() {
		// ============ Equivalence Partitions Tests ==============
		Vector v1=new Vector(4,6,8);
		Double result=116.0;
		// TC01: Test that the calculation of the Vector length squared is proper 
		assertEquals(v1.lengthSquared(),result,"ERROR: Vector.lengthSquared() wrong value");
		}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	void testLength() {
		// ============ Equivalence Partitions Tests ==============
		Vector v1=new Vector(4,4,2);
		Double result=6.0;
		// TC01: Test that the calculation of the Vector length is proper 
		assertEquals(v1.length(),result,"ERROR: Vector.length() wrong value");
			}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	void testNormalize() {
		// ============ Equivalence Partitions Tests ==============
		Vector v1=new Vector(4,6,8);
		Vector normal=v1.normalize();
		// TC01: Test that the normal vector is a unit vector 
		assertEquals(normal.length(),1,"ERROR: Vector.normalize() the normalized vector is not a unit vector");
		// TC02: Test that the normal vector is parallel to the original one
		assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(normal),"ERROR: Vector.normalize() the normalized vector is not parallel to the original one");
		// TC03: Test that the normal vector is not opposite to the original one
		assertTrue(v1.dotProduct(normal)>0,"ERROR: Vector.normalize() the normalized vector is opposite to the original one");

	}
		}
