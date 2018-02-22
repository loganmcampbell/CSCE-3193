import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car
{
	private  int xRatio = 0;
	private  int yRatio = 0;
	
	RobberCar () 
	{
	    super ("RANDOM FAST CAR ", 20, new Engine("V8", 20, 200), "red-car.jpg");
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
		drive(40, xRatio, yRatio);
		super.update(g);
	}
	
}
