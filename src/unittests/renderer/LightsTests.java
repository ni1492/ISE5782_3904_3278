package unittests.renderer;

import org.junit.jupiter.api.Test;

import lighting.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;
import static java.awt.Color.*;

/**
 * Test rendering a basic image
 * 
 * @author Dan 
 */
public class LightsTests {
	private Scene scene1 = new Scene("Test scene");
	private Scene scene2 = new Scene("Test scene") //
			.setAmbientLight(new AmbientLight(new Color(WHITE), new Double3(0.15)));
	private Camera camera1 = new Camera(new Point(0, 0, 1000), new Vector(0, 1,0), new Vector(0, 0,-1)) //
			.setVPSize(150, 150) //
			.setVPDistance(1000);
	private Camera camera2 = new Camera(new Point(0, 0, 1000), new Vector(0, 1,0), new Vector(0,0,-1)) //
			.setVPSize(200, 200) //
			.setVPDistance(1000);

	private Point[] p = { // The Triangles' vertices:
			new Point(-110, -110, -150), // the shared left-bottom
			new Point(95, 100, -150), // the shared right-top
			new Point(110, -110, -150), // the right-bottom
			new Point(-75, 78, 100) }; // the left-top
	private Point trPL = new Point(30, 10, -100); // Triangles test Position of Light
	private Point spPL = new Point(-50, -50, 25); // Sphere test Position of Light
	private Color trCL = new Color(800, 500, 250); // Triangles test Color of Light
	private Color spCL = new Color(800, 500, 0); // Sphere test Color of Light
	private Vector trDL = new Vector(-2, -2, -2); // Triangles test Direction of Light
	private Material material = new Material().setKd(0.5).setKs(0.5).setShininess(300);
	private Geometry triangle1 = new Triangle(p[0], p[1], p[2]).setMaterial(material);
	private Geometry triangle2 = new Triangle(p[0], p[1], p[3]).setMaterial(material);
	private Geometry sphere = new Sphere(new Point(0, 0, -50), 50d) //
			.setEmission(new Color(BLUE).reduce(2)) //
			.setMaterial(new Material().setKd(0.5).setKs(0.5).setShininess(300));

 
	/**
	 * Produce a picture of a sphere lighted by a directional light
	 */
	@Test
	public void sphereDirectional() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new DirectionalLight(spCL, new Vector(1, 1, -0.5)));

		ImageWriter imageWriter = new ImageWriter("lightSphereDirectional", 500, 500);
		camera1.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene1)) //
				.renderImage(); //
				camera1.writeToImage(); //
	}

	/**
	 * Produce a picture of a sphere lighted by a point light
	 */
	@Test
	public void spherePoint() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new PointLight(spCL, spPL).setKl(0.001).setKq(0.0002));

		ImageWriter imageWriter = new ImageWriter("lightSpherePoint", 500, 500);
		camera1.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene1)) //
				.renderImage(); //
				camera1.writeToImage(); //
	}

	/**
	 * Produce a picture of a sphere lighted by a spot light
	 */
	@Test
	public void sphereSpot() {
		scene1.geometries.add(sphere);
		scene1.lights.add(new SpotLight(spCL, spPL, new Vector(1, 1, -0.5)).setKl(0.001).setKq(0.0001));
		
		ImageWriter imageWriter = new ImageWriter("lightSphereSpot", 500, 500);
		camera1.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene1)) //
				.renderImage(); //
				camera1.writeToImage(); //
	}

	/**
	 * Produce a picture of a sphere lighted by all kind of lights
	 */
	@Test
	public void sphereMultiLight() {
		Geometry sphereM = new Sphere(new Point(0, 0, -50), 50d) //
				.setEmission(new Color(BLUE).reduce(2)) //
				.setMaterial(new Material().setKd(0.9).setKs(0.5).setShininess(300));
		scene1.geometries.add(sphereM);
		scene1.lights.add(new SpotLight(new Color(800, 0, 0), new Point(-100, -100, 25), new Vector(1, 1, -0.5)).setKl(0.01).setKq(0.00001));
		scene1.lights.add(new PointLight(new Color(0, 500, 100), new Point(-20, -10, 100)).setKl(0.001).setKq(0.00002));
		scene1.lights.add(new DirectionalLight(new Color(0, 0, 1000), new Vector(1, 1, -0.5)));

		//	spPL = new Point(-50, -50, 25); 
		// spCL = new Color(800, 500, 0);
		ImageWriter imageWriter = new ImageWriter("multiLightSphere", 500, 500);
		camera1.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene1)) //
				.renderImage(); //
				camera1.writeToImage(); //
	}
	/**
	 * Produce a picture of a two triangles lighted by a directional light
	 */
	@Test
	public void trianglesDirectional() {
		scene2.geometries.add(triangle1, triangle2);
		scene2.lights.add(new DirectionalLight(trCL, trDL));

		ImageWriter imageWriter = new ImageWriter("lightTrianglesDirectional", 500, 500);
		camera2.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene2)) //
				.renderImage(); //
				camera2.writeToImage(); //
	}

	/**
	 * Produce a picture of a two triangles lighted by a point light
	 */
	@Test
	public void trianglesPoint() {
		scene2.geometries.add(triangle1, triangle2);
		scene2.lights.add(new PointLight(trCL, trPL).setKl(0.001).setKq(0.0002));

		ImageWriter imageWriter = new ImageWriter("lightTrianglesPoint", 500, 500);
		camera2.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene2)) //
				.renderImage(); //
				camera2.writeToImage(); //
	}
	
	/**
	 * Produce a picture of a two triangles lighted by a spot light
	 */
	@Test
	public void trianglesSpot() {
		scene2.geometries.add(triangle1, triangle2);
		scene2.lights.add(new SpotLight(trCL, trPL, trDL).setKl(0.001).setKq(0.0001));

		ImageWriter imageWriter = new ImageWriter("lightTrianglesSpot", 500, 500);
		camera2.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene2)) //
				.renderImage(); //
				camera2.writeToImage(); //
	}

	/**
	 * Produce a picture of a two triangles lighted by all kind of lights
	 */
	@Test
	public void trianglesMultiLight() {
		 Material materialM = new Material().setKd(0.7).setKs(0.7).setShininess(400);
		 Geometry triangleM1 = new Triangle(p[0], p[1], p[2]).setMaterial(materialM);
		 Geometry triangleM2 = new Triangle(p[0], p[1], p[3]).setMaterial(materialM);

		 
		 
		scene2.geometries.add(triangleM1, triangleM2);
		scene2.lights.add(new PointLight( new Color(0, 50, 300), new Point(40, 0, -50)).setKl(0.01).setKq(0.00005));
		scene2.lights.add(new SpotLight( new Color(400, 0, 200), new Point(20, 20, -110), new Vector(-1, -3, -3)).setKl(0.001).setKq(0.0001));
		scene2.lights.add(new DirectionalLight( new Color(0, 200, 250), new Vector(-2, -2, -2)));

		//Point trPL = new Point(30, 10, -100);
	//	trCL = new Color(800, 500, 250);
	//	Vector trDL = new Vector(-2, -2, -2);
		ImageWriter imageWriter = new ImageWriter("multiLightTriangles", 500, 500);
		camera2.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene2)) //
				.renderImage(); //
				camera2.writeToImage(); //
	}

	/**
	 * Produce a picture of a sphere lighted by a narrow spot light
	 */
//	@Test
	/*
	 *public void sphereSpotSharp() {
		scene1.geometries.add(sphere);
		scene1.lights
				.add(new SpotLight(spCL, spPL, new Vector(1, 1, -0.5)).setNarrowBeam(10).setKl(0.001).setKq(0.00004));

		ImageWriter imageWriter = new ImageWriter("lightSphereSpotSharp", 500, 500);
		camera1.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene1)) //
				.renderImage(); //
				camera1.writeToImage(); //
	}
 
	 */
	
	/**
	 * Produce a picture of a two triangles lighted by a narrow spot light
	 */
	//@Test
	/*
	 * public void trianglesSpotSharp() {
		scene2.geometries.add(triangle1, triangle2);
		scene2.lights.add(new SpotLight(trCL, trPL, trDL).setNarrowBeam(10).setKl(0.001).setKq(0.00004));

		ImageWriter imageWriter = new ImageWriter("lightTrianglesSpotSharp", 500, 500);
		camera2.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene2)) //
				.renderImage(); //
				camera2.writeToImage(); //
	}
	 */
	

}

