package unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import geometries.*;
import primitives.*;
import renderer.*;


public class IntegrationTests 
{
	/**
	 * the function sums the numbers of intersections the camera has with the objects in every pixel in the view plane. 
	 * @param objects: the geometries we need calculate intersections with
	 * @param cam: the camera
	 * @param nX: number of columns(width of rows)-resolution
	 * @param nY: number of rows(height of columns)-resolution
	 * @return the amount of intersections 
	 */
    public int sumIntersections(Intersectable objects, Camera cam, int nX, int nY)
{
        int sum = 0;
        for (int i=0;i<nX;i++)
        {
            for (int j=0; j<nY;j++)
            {
                List<Point> intsersections = objects.findIntersections(cam.constructRay(nX,nY,j,i));
                if (intsersections != null)
                    sum += intsersections.size();
            }
        }
        return sum;
    }

    /**
	 * Test method for {@link renderer.Camera#CameraSphereIntersections()}.
	 */
	@Test
	public void CameraSphereIntersections()
	{
		Camera cam1= new Camera(new Point(0,0,0),new Vector(0,-1,0), new Vector(0,0,1)).setVPDistance(1).setVPSize(3, 3);
		Camera cam2= new Camera(new Point(0,0,-0.5),new Vector(0,-1,0), new Vector(0,0,1)).setVPDistance(1).setVPSize(3, 3);
		Sphere sphere=new Sphere(new Point(0,0,3),1);
		//Test that the sum of intersections from the camera is proper when:
		
		// TC01: the sphere is in front of the camera and only the middle pixel intersects with the sphere twice
		assertEquals(2,sumIntersections(sphere,cam1,3,3),"ERROR: sumIntersections() does not work correctly");
		sphere=new Sphere(new Point(0,0,2.5),2.5);
		// TC02: the sphere is in front of the camera and all the pixels intersects with the sphere twice
		assertEquals(18,sumIntersections(sphere,cam2,3,3),"ERROR: sumIntersections() does not work correctly");
		sphere=new Sphere(new Point(0,0,2),2);
		// TC03: the sphere is in front of the camera and all the pixels except the corners intersects with the sphere twice
		assertEquals(10,sumIntersections(sphere,cam2,3,3),"ERROR: sumIntersections() does not work correctly");
		sphere=new Sphere(new Point(0,0,3),4);
		// TC04: the sphere is in the camera and all the pixels intersects with the sphere once
		assertEquals(9,sumIntersections(sphere,cam1,3,3),"ERROR: sumIntersections() does not work correctly");
		sphere=new Sphere(new Point(0,0,-1),0.5);
		// TC05: the sphere is behind the camera and none of the pixels intersects with the sphere
		assertEquals(0,sumIntersections(sphere,cam1,3,3),"ERROR: sumIntersections() does not work correctly");
				
	
	}
	/**
	 * Test method for {@link renderer.Camera#CameraPlaneIntersections()}.
	 */
	@Test
	public void CameraPlaneIntersections()
	{
		Camera cam= new Camera(new Point(0,0,0),new Vector(0,-1,0), new Vector(0,0,1)).setVPDistance(1).setVPSize(3, 3);
	     // TC01 plane is parallel to the view plane
        Plane plane1 = new Plane(new Point(0,1,2),new Vector(0,0,1));
        assertEquals(9, sumIntersections(plane1,cam,3,3), "ERROR: sumIntersections() does not work correctly");

        // TC02 plane isn't parallel nor orthogonal to the view plane
        Plane plane2 = new Plane(new Point(0,1,2), new Vector(0,-1,3));
        assertEquals(9, sumIntersections(plane2,cam,3,3),"ERROR: sumIntersections() does not work correctly");

        // TC03 the third row doesn't intersect with the plane
        Plane plane3 = new Plane(new Point(0,2,0),new Vector(0,-1,-0.5));
        assertEquals(6, sumIntersections(plane3,cam,3,3),"ERROR: sumIntersections() does not work correctly");

	}
	/**
	 * Test method for {@link renderer.Camera#CameraTriangleIntersections()}.
	 */
	@Test
	public void CameraTriangleIntersections()
	{
		Camera cam= new Camera(new Point(0,0,0),new Vector(0,-1,0), new Vector(0,0,1)).setVPDistance(1).setVPSize(3, 3);
 
		//TC01 triangle is smaller or as the size of the center pixel of the view plane
        Triangle triangle1 = new Triangle(new Point(1,1,2),new Point(0,-1,2),new Point(-1,1,2));
        assertEquals(1, sumIntersections(triangle1,cam,3,3),"ERROR: sumIntersections() does not work correctly");

        // TC02 triangle is intersecting with two rays from the view plane
        Triangle triangle2 = new Triangle(new Point(1,1,2),new Point(0,-20,2),new Point(-1,1,2));
        assertEquals(2, sumIntersections(triangle2,cam,3,3),"ERROR: sumIntersections() does not work correctly"); 

}

}
