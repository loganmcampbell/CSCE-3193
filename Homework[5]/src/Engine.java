
public class Engine 
{
	// D E C L A R E
	//private instance
	private String 	name;
	private int		mpg;
	private int		max;
	
	// C O N S T R U C T O R S
 public Engine (String nameX, int mpgX, int maxX )
	{

	 	this.name = nameX;
	 	//this.mpg = mpgX;
	 	//this.max = maxX;
	 	
		// C O N D I T I O N A L (S)
		if (nameX.length() == 0)
		{
			this.name = "Generic Engine";
			
		}
		else
		{
		 	this.name = nameX;
		}
		// I N I T I A L I Z E
		if (mpgX  < 0 )
		{
			this.mpg = 0;
		}
		else
		{
		 	this.mpg = mpgX;
		}
		
		if (maxX < 0)
		{
			this.max = 0;
		}
		else
		{
		 	this.max = maxX;

		}
	}
	// G E T T E R S
 
 	public String getName()
 	{
 		return name;
 	}
 
	public int	getMpg()
	{
		return mpg;
	}
	public int	getMax()
	{
		return max;
	}
	
	
	public String getDescription()
	{
		String data;
		data = getName() + " (MPG: " + getMpg() + " MAX SPEED: " + getMax() + ")"; 
				
		return data;
	}
	


}


