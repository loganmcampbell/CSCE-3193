
public class Car 
{

	// D E C L A R A T I O N S
	//private instance variables
	private String description;
	private int	xCoordinate;
	private int yCoordinate;	
	
	private   GasTank gVar;
	private   Engine  eVar;
	
	
	//C O N S T R U C T O R
	public Car (String des, int maxFuel, Engine eVar)
	{
		
		gVar = new GasTank (maxFuel);

		this.description = des;
		
		if (maxFuel < 0)
		{
			maxFuel = 0;
		}
		
		if (des.length() == 0)
		{
			this.description = "Generic car";
		}
		
		
		if (eVar == null)
		{
			//Engine newEngine = new Engine ("",0,0);
			 this.eVar = new Engine ("",0,0);
			
		}
		else
		{
			this.eVar = eVar;
		}
			
	}

	//C A R    G E T T E R S

	public String getDes()
	{
		return description;
	}
	
	public int getX()
	{
		return xCoordinate;
	}
	public int getY()
	{
		return yCoordinate;
	}
	
	// G A S || E N G I N E || C O N N E C T E D
	public  double getFuelLevel()
	{
		return gVar.getLevel();
	}
	public int getMPG()
	{
		return eVar.getMpg();
	}
	public void fillUp()
	{
		gVar.setLevel(gVar.getCapacity());
	}
	public int getMaxSpeed()
	{
		return eVar.getMax();
	}


	public String getDescription()
	{
		String data;
		//data = getDes() + " (engine: " + eVar.getDescription() + "), Fuel : " + gVar.getLevel() + ", Location: (" + Integer.toString(getX()) + "," +Integer.toString(getY()) + ")";
		data = getDes() + " (engine: " ;
		data = data + eVar.getDescription();
		data = data + ", Fuel : ";
		data = data + getFuelLevel();
		data = data + "/" + gVar.getCapacity() ;
		data = data + ", Location: (";
		data = data + Integer.toString(getX()) + "," +Integer.toString(getY()) + ") ";
		
		return data;
	}
	
	
	
	// P O S I T I O N   F U N C T I O N
	public  double  drive (int distance, double xRatio, double yRatio)
	{

		double hypo  = Math.sqrt(Math.pow(xRatio, 2) + Math.pow(yRatio, 2));
		double ratio = distance/hypo;
		double xcord = xRatio * (ratio);
		double ycord = yRatio * (ratio);
		
		//miles till empty : how many miles i can travel.
		double mte;
		mte = (eVar.getMpg() * gVar.getLevel());
		
		//amount of gas to travel to destination
		double neededGas =  distance/eVar.getMpg();
		
		if (mte > distance)
		{

		//ending coordinates
		xCoordinate = (int) (xCoordinate + xcord);
		yCoordinate = (int) (yCoordinate + ycord);

		//set the new gas level
		double resources = gVar.getLevel() - neededGas;
		gVar.setLevel(resources);
		}
		
		else
			
		{
			xcord = xRatio * (mte/hypo);
			ycord = yRatio * (mte/hypo);
			
			xcord = xCoordinate + xcord;
			ycord = yCoordinate + ycord;
			
			System.out.println("Ran out of gas after driving : " + mte );
			neededGas = distance/eVar.getMpg();
			double resources = (double)gVar.getLevel() - neededGas;
			gVar.setLevel(resources);
			
			return mte;
		}
		
		return distance;

		
		
		
		
		

		
	
	}
	
}
