package unittests;

import org.junit.jupiter.api.Test;

import static java.awt.Color.*;

import java.util.List;

import lighting.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;

public class MiniPoroject1Test {

	private Scene scene = new Scene("MP1 scene");

	@Test
	public void space() {
//		Camera camera = new Camera(new Point(5000, -10000, 5000), new Vector(-2, 4, 10), new Vector(-1, 2,-1)) //
//				.setVPSize(150, 150).setVPDistance(1500);
//		scene.lights.add(new SpotLight(new Color(400, 400, 400), new Point(0, 0, 500), new Vector(0, 0, -1)) //
//				.setKl(0.00001).setKq(0.0000005));
//		scene.lights.add(new PointLight(new Color(YELLOW), new Vector(0,0,70)).setKl(0.0009));
//		scene.lights.add(new PointLight(new Color(YELLOW), new Point(0, 0, 0)).setKq(0.0002).setKl(0.00003));
//		scene.lights.add(new PointLight(new Color(YELLOW), new Vector(0,0,-70)).setKl(0.0009));

		//
//		 Material sunM = new Material().setKd(0.0).setKs(0.0).setShininess(3000).setKr(0.2).setKt(0.7);
//		 Material starM = new Material().setKd(1.0).setKs(0.3).setShininess(300).setKr(0.1).setKt(0.0);
//
//		scene.geometries.add(new Sphere(new Point(0,0,0),70).setEmission(new Color(YELLOW)).setMaterial(sunM));//the sun
//		scene.geometries.add(new Sphere(new Point(0,-90,0),15).setEmission(new Color(PINK)).setMaterial(starM));//the mercury
//		scene.geometries.add(new Sphere(new Point(0,-150,0),20).setEmission(new Color(GREEN)).setMaterial(starM));//the venus
//		scene.geometries.add(new Sphere(new Point(200,0,0),30).setEmission(new Color(GRAY)).setMaterial(starM));//the earth
//		scene.geometries.add(new Sphere(new Point(190,-200,0),35).setEmission(new Color(PINK)).setMaterial(starM));//the mars
//		scene.geometries.add(new Sphere(new Point(290,-420,0),50).setEmission(new Color(RED)).setMaterial(starM));//the jupiter
//		scene.geometries.add(new Sphere(new Point(560,-330,0),65).setEmission(new Color(GREEN)).setMaterial(starM));//the saturn
//		scene.geometries.add(new Sphere(new Point(-300,700,0),40).setEmission(new Color(GRAY)).setMaterial(starM));//the uranus
		
		//
//		 Material astroidM = new Material().setKd(0.2).setKs(0.1).setShininess(200).setKr(0.0).setKt(0.7);

//		scene.geometries.add(new Sphere(new Point(189,-374,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-42,-376,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-162,-350,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-219,-314,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-97,-386,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-121,-351,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(32,-380,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-18,-396,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(90,-383,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(146,-355,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(214,-328,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(253,-291,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(296,-259,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(376,-186,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(287,-284,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(220,-289,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(329,-224,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(308,-205,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(344,-173,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(266,-252,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(323,-179,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(373,-126,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(364,-54,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(391,-80,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(351,229,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-207,-338,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-147,-378,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-181,-323,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-264,-302,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-269,-262,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-249,-282,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-317,-246,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-336,-169,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-298,-222,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-339,-207,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-350,-108,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-376,-129,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-388,-76,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-397,-38,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-395,27,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-373,0,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-400,0,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-371,43,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-397,63,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-388,108,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-351,112,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(389,-33,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(389,17,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(362,14,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(395,62,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(378,98,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(349,146,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(322,191,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(357,184,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(329,227,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(297,255,0),10).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(250,296,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(261,254,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(221,299,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(164,328,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(169,354,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(116,373,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(199,335,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(85,356,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(92,394,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(44,388,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(30,365,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-19,385,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-61,384,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-32,418,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-102,366,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-179,337,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-136,345,0),9).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-223,310,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-122,401,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-244,287,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-300,261,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-299,199,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-362,212,0),8).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-346,180,0),7).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid
//		scene.geometries.add(new Sphere(new Point(-316,236,0),11).setEmission(new Color(50,50,50)).setMaterial(astroidM));//astroid

//		 Material planeM = new Material().setKd(0.1).setKs(0.0).setShininess(200).setKr(0.0).setKt(0.0);

//		scene.geometries.add(new Plane(new Point(1000,0,0),new Vector(1,1,-2)).setEmission(new Color(50,50,50)).setMaterial(planeM));//astroid
//		scene.geometries.add(new Plane(new Point(0,-2000,0),new Vector(1,1,1)).setEmission(new Color(50,50,50))).setMaterial(planeM));//astroid
//		scene.geometries.add(new Plane(new Point(0,1000,0),new Vector(-1,1,-1)).setEmission(new Color(150,150,150)).setMaterial(planeM));//astroid
//		scene.lights.add(new SpotLight( new Color(400, 0, 200), new Point(20, 20, -110), new Vector(-1, -3, -3)).setKl(0.001).setKq(0.0001));

		
//
//		ImageWriter imageWriter = new ImageWriter("space", 500, 500);
//		camera.setWriter(imageWriter) //
//				.setRayTracerBasic(new RayTracerBasic(scene)) //
//				.renderImage(); //
//				camera.writeToImage();
		
	}
	
	@Test
	public void mounten() {
		Camera camera = new Camera(new Point(10000, -30000, 10000), new Vector(-1,3, 10), new Vector(-1, 3,-1)) //
				.setVPSize(150, 150).setVPDistance(10000);
	scene.setBackground(new Color(174,234,255));
	
	scene.lights.add(new DirectionalLight(new Color(200,200,0), new Vector(0,0,-1)));
	scene.lights.add(new SpotLight(new Color(100,0,100),new Point(10,-30,40), new Vector(-1, 3,7)));

	//sun
	Material sunM = new Material().setKd(0.2).setKs(0.2).setShininess(200).setKt(0.2);
	scene.geometries.add(new Sphere(new Point(-100, 140, 100), 30d).setEmission(new Color(YELLOW)).setMaterial(sunM));
	scene.lights.add(new PointLight(new Color(YELLOW),new Point(-100, 140, 100)).setKc(0.9));
	
	//mountians
	Material mountianM = new Material().setKd(0.6).setKs(0.3).setShininess(200);

		//triangle 2
		scene.geometries.add(new Triangle(new Point(-75,0,100), new Point(-75, -40, 0), //
				new Point(-150, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-75,0,100), new Point(-75, -40, 0), //
				new Point(0, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-75,0,100), new Point(-75, 30,0), //
				new Point(-150, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-75,0,100), new Point(-75, 30, 0), //
				new Point(0, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		
		//triangle 3
		scene.geometries.add(new Triangle(new Point(0,0,80), new Point(0, -40, 0), //
				new Point(-50, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,0,80), new Point(0, -40, 0), //
				new Point(50, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,0,80), new Point(0, 30,0), //
				new Point(-50, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,0,80), new Point(0, 30, 0), //
				new Point(50, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		
		// triangle 4
		scene.geometries.add(new Triangle(new Point(75,0,100), new Point(75, -40, 0), //
				new Point(150, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(75,0,100), new Point(75, -40, 0), //
				new Point(0, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(75,0,100), new Point(75, 30,0), //
				new Point(150, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(75,0,100), new Point(75, 30, 0), //
				new Point(0, 0, 0)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		
		//triangle 8 
		scene.geometries.add(new Triangle(new Point(50,50,120), new Point(40, 10, 0), //
				new Point(100, 50, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(50,50,120), new Point(40, 10, 0), //
				new Point(0, 50, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(50,50,120), new Point(40, 70,0), //
				new Point(100, 50, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(50,50,120), new Point(40, 70, 0), //
				new Point(0, 50, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		
		//triangle 7
		scene.geometries.add(new Triangle(new Point(-50,50,120), new Point(-50, 70, 0), //
				new Point(-120, 40, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-50,50,120), new Point(-50, 70, 0), //
				new Point(0, 40, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-50,50,120), new Point(-40, 20,0), //
				new Point(-120, 40, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-50,50,120), new Point(-40, 20, 0), //
				new Point(0, 40, 0)).setEmission(new Color(101,67,33)).setMaterial(mountianM));
		
		//center triangle 10 
		scene.geometries.add(new Triangle(new Point(0,80,160), new Point(0, 100, 0), //
				new Point(90, 80, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,80,160), new Point(0, 100, 0), //
				new Point(-90, 80, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,80,160), new Point(0, 50,0), //
				new Point(90, 80, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,80,160), new Point(0, 50, 0), //
				new Point(-90, 80, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		
		//triangle 11 
		scene.geometries.add(new Triangle(new Point(0,150,100), new Point(0, 200, 0), //
				new Point(160, 130, 0)).setEmission(new Color(76,65,40)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,150,100), new Point(0, 200, 0), //
				new Point(-160, 130, 0)).setEmission(new Color(76,65,40)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,150,100), new Point(0, 100, 0), //
				new Point(160, 130, 0)).setEmission(new Color(76,65,40)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(0,150,100), new Point(0, 100, 0), //
				new Point(-160, 130, 0)).setEmission(new Color(76,65,40)).setMaterial(mountianM));
		
		//triangle 6 
		scene.geometries.add(new Triangle(new Point(-150,80,160), new Point(-160, 130, 0), //
				new Point(-250, 70, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-150,80,160), new Point(-160, 130, 0), //
				new Point(-30, 60, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-150,80,160), new Point(-130, 20, 0), //
				new Point(-250, 70, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-150,80,160), new Point(-130, 20, 0), //
				new Point(-30, 60, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		
		//triangle 9
		scene.geometries.add(new Triangle(new Point(150,80,160), new Point(160, 130, 0), //
				new Point(250, 70, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(150,80,160), new Point(160, 130, 0), //
				new Point(30, 60, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(150,80,160), new Point(130, 20, 0), //
				new Point(250, 70, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(150,80,160), new Point(130, 20, 0), //
				new Point(30, 60, 0)).setEmission(new Color(92,72,39)).setMaterial(mountianM));
		//triangle 1
		scene.geometries.add(new Triangle(new Point(-120,10,0), new Point(-200, -45, 0), //
				new Point(-200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-120,10,0), new Point(-200, 45, 0), //
				new Point(-200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-260,10,0), new Point(-200, -45, 0), //
				new Point(-200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(-260,10,0), new Point(-200, 45, 0), //
				new Point(-200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		//triangle 5
		scene.geometries.add(new Triangle(new Point(120,10,0), new Point(200, 45, 0), //
				new Point(200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(120,10,0), new Point(200, -45, 0), //
				new Point(200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(260,10,0), new Point(200, -45, 0), //
				new Point(200, 0, 80)).setEmission(new Color(117,68,35)).setMaterial(mountianM));
		scene.geometries.add(new Triangle(new Point(260,10,0), new Point(200, 40, 0), //
				new Point(200, 0, 80)).setEmission(new Color(90,39,41)).setMaterial(mountianM));
		
		//earth- triangle
		scene.geometries.add(new Triangle(new Point(0,140,0), new Point(-600, -45, 0), //
				new Point(600, -45, 0)).setEmission(new Color(92,73,57)));	
		
		//sea- triangle
		Material seaM = new Material().setKd(0.2).setKs(0.2).setShininess(300).setKr(0.6);
		scene.geometries.add(new Triangle(new Point(100000,0,0), new Point(-100000, 0, 0), //
				new Point(0, -100000, 0)).setEmission(new Color(0,50,100)).setMaterial(seaM));
		
		//clouds
		Material cloudM = new Material().setKd(0.5).setKs(0.6).setShininess(300);

		//cloud 1
		scene.geometries.add(new Sphere(new Point(165, 165, 115), 30d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(140, 165, 105), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(190, 165, 105), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		//cloud 2
		scene.geometries.add(new Sphere(new Point(-255, 225, 135), 30d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(-230, 225, 125), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(-280, 225, 125), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		//cloud 3
		scene.geometries.add(new Sphere(new Point(35, 165, 165), 30d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(10, 165, 155), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));
		scene.geometries.add(new Sphere(new Point(60, 165, 155), 20d).setEmission(new Color(248,245,245)).setMaterial(cloudM));

		

		ImageWriter imageWriter = new ImageWriter("mounten", 500, 500);
		camera.setWriter(imageWriter) //
				.setRayTracerBasic(new RayTracerBasic(scene)) //
				.renderImage(); //
				camera.writeToImage();
	}
}
