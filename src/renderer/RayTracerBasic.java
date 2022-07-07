package renderer;

import java.math.MathContext;
import java.util.List;
import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.*;

import static java.lang.System.out;
import static primitives.Util.alignZero;

/**
 * finding the color of the pixels
 */
public class RayTracerBasic extends RayTracerBase {
	private static final int MAX_CALC_COLOR_LEVEL =10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K=1.0;
	private static final double ACCURACY=3;
	private static final double RAYS=3;
	private static boolean improvement=true;

	/**
	 * constructor that receives a scene and construct the scene
	 * @param scene Scene
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}

	/**
	 * calculate the color of the intersection of the ray with the objects
	 * @param r Ray: the ray that intersects with objects
	 * @return the color of the intersection
	 */
	public Color traceRay(Ray r) {
		GeoPoint point = findClosestIntersection(r);
		return point==null ? scene.background: calcColor(point,r);
	}

	/**
	 * return the color of the point depends on the lightning around
	 * @param point Point: the point to check the color
	 * @return return the color of the point
	 */
	private Color calcColor(GeoPoint point,Ray ray)
	{
		return calcColor(point, ray, MAX_CALC_COLOR_LEVEL,new Double3(INITIAL_K)).add(scene.ambientLight.getIntensity());
	}
	
	/**
	 * return the color of the point depends on the lightning around
	 * @param point Point: the point to check the color
	 * @param ray: the ray that directed to the point
	 * @param level: the amount of times that left to continue the recoursion
	 * @param k: the intensity of the light 
	 * @return the color of the point
	 */
	private Color calcColor(GeoPoint point,Ray ray, int level, Double3 k)
	{
		Color color=calcLocalEffects(point,ray,k);
		return level==1? color: color.add(calcGlobalEffects(point,ray, level, k));
	}
	
	/**
	 * helper function for calcColor- calculate the effects of the reflection and the refraction on the point
	 * @param point Point: the point to check the color
	 * @param ray Ray: the ray that intersects with the point
	 * @param level: the times left to call calcColor again
	 * @param k: the intensity of light in the point
	 * @return the color effects from other objects in the scene
	 */
	private Color calcGlobalEffects(GeoPoint point, Ray ray, int level, Double3 k) {
		Color color=Color.BLACK;
		Vector n=point.geometry.getNormal(point.point);
		
		Double3 kr=point.geometry.getMaterial().kR;
		Double3 kkr=k.product(kr);
		if(!kkr.lowerThan(MIN_CALC_COLOR_K)) {
			color=calcGlobalEffect(constructReflectionRay(point.point, ray.getDir(),n),level, kr,kkr);
		}
		Double3 kt=point.geometry.getMaterial().kT;
		Double3 kkt=k.product(kt);
		if(!kkt.lowerThan(MIN_CALC_COLOR_K)) {
			color=color.add(calcGlobalEffect(constructRefractionRay(point.point,ray.getDir(),n),level,kt,kkt));
		}

		return color;
	}
	/**
	 * calls the calColor for the dipper level
	 * @param ray: the new ray from the last point- Ray
	 * @param level: the times left to call calcColor again- int
	 * @param kx: kr or kt, the k for this level- Double3
	 * @param kkx: kkr or kkt, the k for the next level- Double3
	 * @return the color of the point in this level
	 */
	private Color calcGlobalEffect(Ray ray, int level, Double3 kx, Double3 kkx) {
		GeoPoint p=findClosestIntersection(ray); // 
		if(p==null)
			return scene.background;
		if(improvement){//if we choose to use the improvement
			
			Color ans=calcColor(p,ray,level-1,kkx);//calc the color in the specific point
			int num=1;
			double gap=(double)ACCURACY/(RAYS);//the gap between each point in the grid
			Double3 d=ray.getDir().getXyz();
			//directions that orthogonal to the ray in the point (to create a plane that include the point- to find more point in the area)
			Vector dir1=new Vector(new Double3(-1,-1,((d.getD1()+d.getD3())/d.getD2()))).normalize();
			Vector dir2=ray.getDir().crossProduct(dir1).normalize();
			Point startGrid=p.point;
			Point temp;
			Color c;
			//to make the target a grid
			for(int i=0;i<RAYS/2d;i++){//goes over the points in the area of the original point to calc their color
				for(int j=0;j<RAYS/2d;j++){
					if(i==0 && j!=0) {//if the point is on one of the direction- we have 2 points +-direction for +-j
						temp=startGrid.add(dir2.scale(-j*gap));
						c=improvementHelper(startGrid,temp,ray, level,kkx);
						if(c!=Color.BLACK) {
							ans=ans.add(c);
							temp=startGrid.add(dir2.scale(j*gap));
							ans.add(improvementHelper(startGrid,temp,ray, level,kkx));
							num=num+2;
						}
					}
					else if(j==0 && i!=0) {//if the point is on one of the direction- we have 2 points +-direction for +-i
						temp=startGrid.add(dir1.scale(-i*gap));
						c=improvementHelper(startGrid,temp,ray, level,kkx);
						if(c!=Color.BLACK) {
							ans=ans.add(c);
							temp=startGrid.add(dir1.scale(i*gap));
							ans.add(improvementHelper(startGrid,temp,ray, level,kkx));
							num=num+2;
						}
		 			}
					else if(j!=0 && i!=0){//else there is 4 points- in each quarter for +-i,+-j
						temp=startGrid.add(dir1.scale(i*gap)).add(dir2.scale(j*gap));
						c=improvementHelper(startGrid,temp,ray, level,kkx);
						if(c!=Color.BLACK) {
							ans=ans.add(c);
							temp=startGrid.add(dir1.scale(-i*gap)).add(dir2.scale(j*gap));
							ans=ans.add(improvementHelper(startGrid,temp,ray, level,kkx));
							temp=startGrid.add(dir1.scale(i*gap)).add(dir2.scale(-j*gap));
							ans=ans.add(improvementHelper(startGrid,temp,ray, level,kkx));
							temp=startGrid.add(dir1.scale(-i*gap)).add(dir2.scale(-j*gap));
							ans=ans.add(improvementHelper(startGrid,temp,ray, level,kkx));
							num=num+4;
						}
					}
				}
			}
			return ans.scale(kx).reduce(num);
		}
		else
			return calcColor(p,ray,level-1,kkx).scale(kx);
	}
	
	/**
	 * checks that the point is in the radius of the accuracy and finds the new ray to the new point and calls calcColor for that point 
	 * @param p0 the original point
	 * @param p the new point
	 * @param ray the ray to the original point
	 * @param level the level of recursion
	 * @param kkx kkr or kkt, the k for the next level- Double3
	 * @return the color of the points around the original point
	 */
	private Color improvementHelper(Point p0,Point p,Ray ray ,int level, Double3 kkx) {
		if(p0.distance(p)<=ACCURACY){// to make the target a circle
			Ray newRay=new Ray(ray.getP0(),p.subtract(ray.getP0()).normalize());
			GeoPoint newP=findClosestIntersection(newRay);
			if(newP!=null){
				return calcColor(newP,newRay,level-1,kkx);
			}
		}
		return Color.BLACK;
	}

	/**
	 * helper function for calcColor- calculate the lights effects on the point
	 * @param point Point: the point to check the color
	 * @param ray Ray: the ray that intersects with the point
	 * @return the color that the lights adds to the point
	 */
	private Color calcLocalEffects(GeoPoint point,Ray ray, Double3 k) {
		Color color=point.geometry.getEmission();
		Vector v=ray.getDir();
		Vector n=point.geometry.getNormal(point.point).normalize();
		double nv=alignZero(n.dotProduct(v));
		if(nv==0)
			return color;
		Material material=point.geometry.getMaterial();
		
		for(LightSource light:scene.lights)
		{
			Vector l=light.getL(point.point);
			double nl=alignZero(n.dotProduct(l));
			if(nl*nv>0)//sign(nl)==sign(nv)
			{
//				if(unshaded(point, l, n, light, nv)) {
				Double3 ktr=transparency(point,light,l,n);
				if(!ktr.product(k).lowerThan(MIN_CALC_COLOR_K)) {
				Color iL=light.getIntensity(point.point).scale(ktr);
					color=color.add(iL.scale(calcDiffusive(material,nl)),iL.scale(calcSpecular(material,n,l,nl,v)));
				}
				}
		}
		return color;
	}

	/**
	 * returns the specular calculation of the material
	 * @param material - material
	 * @param n - vector normal
	 * @param l - vector from the light source to the point
	 * @param nl - double - dot product of l and n
	 * @param v - vector direction of the ray
	 * @return the specular calculation of the material - double3
	 */
	private Double3 calcSpecular(Material material, Vector n, Vector l, double nl, Vector v) {
		Vector r=l.add(n.scale(nl).scale(-2));
		double vr=alignZero(r.dotProduct(v.scale(-1)));
		if(vr<0)
		{
			vr=0;
		}
		return material.kS.scale(Math.pow(vr, material.nShininess));
	}

	/**
	 * returns the diffusive calculation of the material
	 * @param material - material
	 * @param nl - double - dot product of vector between the lightsource and point and vector normal of the point
	 * @return the diffusive calculation of the material - double3
	 */
	private Double3 calcDiffusive(Material material, double nl) {
		return material.kD.scale(Math.abs(nl));
	}
	
	/**
	 * Deprecated function! no longer in use.
	 * checks if there is an object that make shadow on the point
	 * @param gp - the point on the geometry: GeoPoint
	 * @param l - the vector from the light to the point: Vector
	 * @param n - the normal to the point: Vector 
	 * @return if there is an object between the point to the source light
	 */
	private boolean unshaded(GeoPoint gp, Vector l, Vector n, LightSource light, double nv) {
		Ray lightRay=new Ray(gp.point,l.scale(-1),n);//new ray from the new point to the light source
		//turn the vector l- from the point to the light  of te vector from the light to the point
		double length=light.getDistance(lightRay.getP0());//helper function to find the distance from the light to the point 

		List<GeoPoint> intersections=this.scene.geometries.findGeoIntersections(lightRay,length);
		if(intersections==null)
			return true;
		for(GeoPoint p: intersections)
		{
			if(p.geometry.getMaterial().kT.equals(Double3.ZERO))
				return false;
				
		}
		/* non bonus solution
		 for(GeoPoint p: intersections) {
			if(p.point.distance(point)<length)
				return false;
		}
		*/
		
		return true;
	}
	
	/**
	 * the function find the intensity of the light that affect the object- if there are other objects that might stop some of the light
	 * @param gp - the point on the geometry: GeoPoint
	 * @param light - the source light that affect the object: LightSource
	 * @param l - the vector from the light to the point: Vector
	 * @param n - the normal to the point: Vector 
	 * @return the intensity of the light on the point
	 */
	private Double3 transparency(GeoPoint gp, LightSource light, Vector l, Vector n) {
		Ray lightRay=new Ray(gp.point,l.scale(-1),n);//new ray from the new point to the light source
		//turn the vector l- from the point to the light  of te vector from the light to the point
		double length=light.getDistance(lightRay.getP0());//helper function to find the distance from the light to the point 
		List<GeoPoint> intersections=this.scene.geometries.findGeoIntersections(lightRay,length);
		if(intersections==null)
			return Double3.ONE;
		Double3 ktr=Double3.ONE;
		for(GeoPoint p: intersections)
		{
			ktr=ktr.product(p.geometry.getMaterial().kT);
		}
		return ktr;
	}
	
	/**
	 * find the closest intersection to the ray 
	 * @param ray - Ray
	 * @return closest point
	 */
	protected GeoPoint findClosestIntersection(Ray ray) {
		List<GeoPoint> points=scene.geometries.findGeoIntersections(ray);
		if(points==null)
			return null;
		return ray.findClosestGeoPoint(points);
	}
	
	/**
	 * construct the reflected ray 
	 * @param point - Point
	 * @param v - vector direction of the ray
	 * @param n - vector normal
	 * @return the reflection ray
	 */
	private Ray constructReflectionRay(Point point, Vector v, Vector n) {
		Ray ray= new Ray(point,v,n);
		return new Ray(point,v.subtract(n.scale(2*n.dotProduct(v))),n);
	}
	/**
	 * construct the refracted ray 
	 * @param point - Point
	 * @param v - vector direction of the ray
	 * @param n - vector normal
	 * @return the refraction ray
	 */
	private Ray constructRefractionRay(Point point, Vector v, Vector n) { 
		return new Ray(point,v,n); 
	}
	
	public void setImprovement(boolean glossy) {
		this.improvement=glossy;
	}
}