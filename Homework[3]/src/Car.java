
public class Car 
{

	// D E C L A R A T I O N S
	//private instance variables
	private String description;
	private int	xCoordinate;
	private int yCoordinate;	
	private double mDriven;
	
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
		
		if (des.length() == 0 )
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
		data = getDes() + " (ENGINE: " ;
		data = data + eVar.getDescription();
		data = data + ", Fuel : ";
		data = data + getFuelLevel();
		data = data + "/" + gVar.getCapacity() ;
		data = data + ", Location: (";
		data = data + Integer.toString(getX()) + "," +Integer.toString(getY()) + ") ";
		
		return data;
	}
	
	public String getDiDes()
	{
		String didata;
		
		didata = getDes() + " (ENGINE: " ;
		didata = didata + eVar.getDescription();
		didata = didata + " || Fuel Capacity : ";
		didata = didata + gVar.getCapacity();
		return didata;
	}
	
	
	
	// P O S I T I O N   F U N C T I O N
	public  double  drive (int distance, double xRatio, double yRatio)
	{
		//miles till empty : how many miles i can travel.
		double mte;
		mte = (double)(eVar.getMpg() * gVar.getCapacity());
		//miles distanced
		mDriven += distance;
		//traveling
		double mRatio = mDriven/mte;
		//calculate tank
		double nCap = mRatio * gVar.getCapacity();
		//available fuel
		double eFuel = gVar.getCapacity() - nCap;
		gVar.setLevel(eFuel);

		
		if (gVar.getLevel() > 0 && mDriven < mte)
		{
				if ((xRatio < 0 && yRatio <0) || (xRatio < 0 && yRatio > 0))
				{
					double trigAngle = Math.atan(yRatio/xRatio);
					int	   iX 		 =	((int) (distance * Math.cos(trigAngle)));
					int	   xpoint = iX * -1;
					int	   iY		 =	((int) (distance * Math.sin(trigAngle)));
					int	   ypoint = iY * -1;
					this.xCoordinate += xpoint;
					this.yCoordinate += ypoint;
				}
				else
				{
					double trigAngle = Math.atan((yRatio/xRatio));
					int xpoint = (int) (distance * Math.cos(trigAngle));
					int ypoint = (int) (distance * Math.sin(trigAngle));
					this.xCoordinate += xpoint;
					this.yCoordinate += ypoint;
				}
			return distance;
		}
		else
		{
			double wantedDistance = mDriven - distance;
			double neededGas = mte - wantedDistance;
			if (neededGas < 0)
			{
				neededGas = 0.0;
			}
		
			System.out.println("Ran out of gas after driving : " + neededGas );
			if ((xRatio < 0 && yRatio < 0) || xRatio < 0 && yRatio > 0)
			{
				double trigAngle = Math.atan(yRatio/xRatio);
				int iX = (int) (neededGas * Math.cos(trigAngle));
				int xpoint = iX * -1;
				int iY = (int) (neededGas * Math.sin(trigAngle));
				int ypoint = iY * -1;
				this.xCoordinate += xpoint;
				this.yCoordinate += ypoint;
				
			}
			else
			{
				double trigAngle = Math.atan(yRatio/xRatio);
				int xpoint = (int) (neededGas * Math.cos(trigAngle));
				int ypoint = (int) (neededGas * Math.sin(trigAngle));
				this.xCoordinate += xpoint;
				this.yCoordinate += ypoint;
			}
			return neededGas;
		}
		
	
	
	}
	
}
