package scene;

import java.util.LinkedList;
import java.util.List;

import geometries.*;
import lighting.*;
import primitives.*;

public class Scene {
	public String name;
	public Color background;
	public AmbientLight ambientLight;
	public Geometries geometries;
	public List<LightSource> lights;

	/**
	 * constructor- create a new scene with the name given and an empty geometries list
	 * @param name string: the name of the new scene
	 */
	public Scene(String name) {
		this.name = name;
		background=Color.BLACK;
		ambientLight=new AmbientLight();
		geometries=new Geometries();
		lights=new LinkedList<>();
	}

	/**
	 * sets the background color and return the object Scene
	 * @param background Color: the color of the background
	 * @return the object itself
	 */
	public Scene setBackground(Color background) {
		this.background = background;
		return this;
	}

	/**
	 * sets the ambient light and return the object Scene
	 * @param ambLight AmbientLight: the ambient light
	 * @return the object itself 
	 */
	public Scene setAmbientLight(AmbientLight ambLight) {
		this.ambientLight = ambLight;
		return this;
	}

	/**
	 * sets the geometries list and return the object Scene
	 * @param geometries Geometries: the geometries objects on the scene
	 * @return the object itself 
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this;
	}
	
	/**
	 * 
	 * @param ambLight
	 * @return
	 */
	public Scene setLights(LightSource light) {
		this.lights.add(light);
		return this;
	}
}
