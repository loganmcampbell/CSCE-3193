import java.awt.Graphics;

public class Car extends Sprite
{

	// D E C L A R A T I O N S
	//private instance variables
	private String description;
	//private int	xCoordinate;
	//private int yCoordinate;	
	
	private   GasTank gVar;
	private   Engine  eVar;
	
	
	//C O N S T R U C T O R
	public Car (String des, int maxFuel, Engine eVar, String spriteImg)
	{
		super(spriteImg);
		
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
	
//	public int getX()
//	{
//		return xCoordinate;
//	}
//	public int getY()
//	{
//		return yCoordinate;
//	}
	
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
	
	public int drive(int distance, double xRatio, double yRatio)
	{
		double Hypo = Math.sqrt(Math.pow(xRatio, 2) + Math.pow(yRatio, 2));
		
		double Travel = distance/Hypo;
		
		double xPoint = xRatio * Travel;
		double yPoint = yRatio * Travel;
		
		
		double canDrive = gVar.getLevel() * eVar.getMpg();
		
		double howMuchGas = (double) distance/ eVar.getMpg();
		
		double finalGas = gVar.getLevel()- howMuchGas;
		
		if(canDrive > distance)
		{
			super.setX((int) (super.getX() + xPoint));
			super.setY((int) (super.getY() + yPoint));
			
			gVar.setLevel(finalGas);
		}
		
		else
		{			
			distance = (int)canDrive;	
			
			System.out.println("Ran out of gas after driving " + canDrive + " miles");
			
			super.setX( (int)(super.getX() + (xRatio * canDrive)));
			super.setY( (int)(super.getY() + (yRatio * canDrive)));
			
			gVar.setLevel(finalGas);
		}
		

		
		return distance;	
	}
	
	
	public void updateImage (Graphics g)
	{
		//locationX = locationX + 1;
		//locationY = locationY + 1;
		super.updateImage(g);
	}
	

	
}
