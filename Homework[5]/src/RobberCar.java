import java.awt.Graphics;
import java.util.Random;



public class RobberCar extends Car
{
	private  int xRatio = 0;
	private  int yRatio = 0;
	boolean capturedRob;
	boolean escapedRob;
	static int capNum = 0;
	static int escNum = 0;
	
	RobberCar () 
	{
		// 20 to 5000
	    super ("RANDOM FAST CAR ", 5000, new Engine("V8", 20, 200), "red-car.jpg");
	    //initial fill up 
	    super.fillUp();
	    
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

	
	public void updateState(int width, int height)
	{
		if (!capturedRob)
		{
		
			drive(4,xRatio ,yRatio);
			
			if (((super.getX() > width || super.getY() > height) || (super.getX() <= -1 || super.getY() <=-1)) && (escapedRob == false))
			{
					
				escapedRob = true;

				hasEscaped();

			}
		}
		


	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
	
	public void captured()
	{
		if (escapedRob == false)
		{
			isCaptured();
			capturedRob = true;
			String jail;
			jail = "jail.jpg";
			super.setImage(jail);
			final int x = super.getX();
			final int y = super.getY();
			super.setX(x);
			super.setY(y);
		}

			
	}
	
	public boolean isCaptured()
	{
		
		
		if (capturedRob == false)
		{
			capNum = capNum + 1;
			return true;	
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasEscaped()
	{
		if (escapedRob == true)
		{
			escNum = escNum + 1;
			return true;
		}
		else
		{
			return false;
		}
	}

}
