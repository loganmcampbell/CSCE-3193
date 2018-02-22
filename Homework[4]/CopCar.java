import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car
{
	private static int xRatio;
	private static int yRatio;

	public CopCar ()
	{
		
	    super ("RANDOM COP CAR ", 30, new Engine("v12", 30, 100), "cop-car.jpg");
	    Random rand = new Random ();
	    xRatio = 0;
	    yRatio = 0;
	    
	    while ((xRatio == 0) && (yRatio == 0))
	    {
	   	xRatio = rand.nextInt(5+5) - 5;
	   	yRatio = rand.nextInt(5+5) - 5;
	    }
		fillUp();
	}
	
	public void update (Graphics g)
	{
		drive(20, xRatio,yRatio);
		super.update(g);
	}
	
	
	
}
