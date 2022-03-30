package geometries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import primitives.*;

public class Geometries implements Intersectable
{
    private List<Intersectable> intersectables;

	public Geometries() 
	{
		this.intersectables = new ArrayList();
	}
    
	public Geometries(Intersectable... intersectables) 
	{
        this();
        add(intersectables);
    }
	
	 public void add(Intersectable... intersectables) 
	 {
		 Collections.addAll(this.intersectables, intersectables);
	 }
    
	 @Override
	 public List<Point> findIntersections(Ray ray) 
	 {
		 return null;
	 }

}
