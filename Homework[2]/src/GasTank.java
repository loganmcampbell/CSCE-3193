
public class GasTank
{
	
	// D E C L A R E
	//instance variables
	private  int capacity;
	private  double current;
	
	// S E T   C O N S T R U C T O R
	 public GasTank (int setCap)
	{
		capacity = setCap;
		if (setCap <= 0)
		{
			this.capacity = 0;
			this.current  = 0.0;
		}
	}
	// G E T T E R S
	public int getCapacity() 
	{
		return capacity;
	}
	public double getLevel() 
	{
		if (current <= 0.0)
		{
			this.current = 0.0;
		}
	
		return current;
	}
	//	S E T T E R 
	public void setLevel(double levelIn) 
	{
		
		
		if (levelIn <= 0)
		{
			this.current = 0.0;
		}
		if (levelIn >= capacity)
		{
			this.current = this.capacity;
		}
		else
		{
			this.current = levelIn;

		}
		
	}
	

}
