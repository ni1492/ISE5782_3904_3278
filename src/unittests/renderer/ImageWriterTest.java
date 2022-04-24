package unittests.renderer;
import renderer.*;

import org.junit.jupiter.api.Test;

import primitives.*;

public class ImageWriterTest { 

	/**
	 * test to check that creating an image is working 
	 */
	@Test
	void createImageTest() {
	Color RED=new Color(255d,0d,0d);
	Color YELLOW=new Color(255d,256d,0d);
	ImageWriter imageWriter=new ImageWriter("testImageCreation",800,500);
	//painting all the pixels in red and yellow
	for( int i=0; i<800;i++)
	{
		for(int j=0;j<500;j++)
		{
			if(i%50==0||j%50==0)//500X800, 10X16 -> every square is 50X50 pixels
			{
				imageWriter.writePixel(i, j, RED);
			}
			else
			{
				imageWriter.writePixel(i, j, YELLOW);
			}
		}
	}
	imageWriter.writeToImage();//saving the image
}
}
