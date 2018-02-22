import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car
{
	private static int xRatio;
	private static int yRatio;
	
	public CopCar ()
	{
	    super ("RANDOM COP CAR ", 5000, new Engine("v12", 30, 100), "cop-car.jpg");

	    
	    Random rand = new Random ();
	    xRatio = 0;
	    yRatio = 0;
	    
	    while ((xRatio == 0) && (yRatio == 0))
	    {
	   	//xRatio = rand.nextInt(((5 - (-5)) + 1 ) + (- 5));
		xRatio = rand.nextInt(5+5) - 5;
	   	yRatio = rand.nextInt(5+5) - 5;
	   	//yRatio = rand.nextInt(((5 - (-5)) + 1 ) + (- 5));

	    }
		super.fillUp();
	}
	

	
	public void updateState(int width, int height)
	{
		super.drive(2,xRatio  ,yRatio);
		if ( super.getX() > width || super.getX() < 0)
		{
			xRatio = -(xRatio);
		}
		if (super.getY() > height || super.getY() < 0)
		{
			yRatio = -(yRatio);
		}
	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
	
	
	
}
