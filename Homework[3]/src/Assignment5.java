import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Assignment5 
{
	

public static void main( String[] args)
{
	
	//ASK----------------------------------------------------------------------
	String box1 = //STRING
			JOptionPane.showInputDialog ( "C A R   D E S C R I P T I O N :");
	//-------------------------------------------------------------------------
	
	
	
	//-------------------------------------------------------------------------
	String box2 = //DOUBLE
			JOptionPane.showInputDialog("F U E L   T A N K  C A P A C I T Y :");
	//DOUBLE TO STRING
	try 
	{
		 double dftc = Double.parseDouble(box2);
		
		while (dftc <= 0)
		{
			box2 =
			JOptionPane.showInputDialog("F U E L   T A N K  C A P A C I T Y :");
			dftc = Double.parseDouble(box2);
		}
	}
	catch (NumberFormatException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	catch (NullPointerException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	//REASSIGN
	double dftc = Double.parseDouble(box2);
	//-------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------
	String box3 = //STRING
			JOptionPane.showInputDialog("E N G I N E  D E S C R I P T I O N :");
	//--------------------------------------------------------------------------
	
	
	
	String box4 = //INT----------------------------------------------------------
			JOptionPane.showInputDialog("M I L E S  P E R  G A L L O N :");
	try 
	{
		int mpg = Integer.parseInt(box4);
		while (mpg <=0)
		{
			box4 = //INT
			JOptionPane.showInputDialog("M I L E S  P E R  G A L L O N :");
			mpg = Integer.parseInt(box4);
		}
	}
	catch (NumberFormatException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	catch (NullPointerException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	//REASSIGN
	int mpg = Integer.parseInt(box4);
	//----------------------------------------------------------------------------
	
	
	String box5 = //INT-----------------------------------------------------------
			JOptionPane.showInputDialog("M A X  S P E E D :");
	try 
	{
		
		int maxspeed = Integer.parseInt(box5);
		while (maxspeed <=0)
		{
			box5 = //INT
			JOptionPane.showInputDialog("M A X  S P E E D :");
			maxspeed = Integer.parseInt(box5);
	
		}
	}
	catch (NumberFormatException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	catch (NullPointerException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	//REASSIGN
	int maxspeed = Integer.parseInt(box5);
	//---------------------------------------------------------------------------
	
	//CONVERT FUEL TO INT
	int ftc = (int)(dftc);
	
	//ASSIGN OBJECTS
	Engine	userEngine 	= new Engine 	(box3,mpg,maxspeed);
	Car		userCar		= new Car		(box1, ftc,userEngine);
	
	//CREATE MESSAGE
	String message;
	message = userCar.getDescription();
	//STORED MESSAGE
	JOptionPane.showMessageDialog(null, message);
	
	//ASK LEG(S) < 10
	String box6 =
	JOptionPane.showInputDialog("The number of legs in the trip : ");
	try 
	{
		int limit = Integer.parseInt(box6);
		
		while (limit <= 0 && limit <= 10)
		{
			box6 =
			JOptionPane.showInputDialog("The number of legs in the trip : ");
			limit = Integer.parseInt(box6);
		}
	}
	catch (NumberFormatException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	catch (NullPointerException e)
	{
		JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
		System.exit(0);
	}
	
	int limit = Integer.parseInt(box6);
	int 	[]	dArray 		= new int [limit];
	double 	[]	xArray		= new double [limit];
	double 	[]	yArray		= new double [limit];
	int	[]  xcordArray		= new int [limit];
	int	[]	ycordArray		= new int [limit];
	int number = 1;
	
	userCar.fillUp();

	for (int x = 0; x < limit; x++)
	{
		String box7 =
		JOptionPane.showInputDialog("The distance of leg # " + number);
		try 
		{
			int dleg 	= Integer.parseInt(box7);
			
			while (dleg <= 0)
			{
				box7 =
				JOptionPane.showInputDialog("The distance of leg # " + number);
				dleg 	= Integer.parseInt(box7);
			}
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		int dleg 	= Integer.parseInt(box7);

		
		
		String box8 =
		JOptionPane.showInputDialog("The x ratio of leg # " + number);
		try
		{
			double xleg	= Double.parseDouble(box8);
			//GET RID OF WARNING
			xleg = (double)xleg;
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		
		double xleg = Double.parseDouble(box8);
		
		String box9 =
		JOptionPane.showInputDialog("The y ratio of leg # " + number);
		try
		{
			double yleg	= Double.parseDouble(box9);
			//GET RID OF WARNING
			yleg = (double)yleg;
		}
		catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid data entered. Exiting...");
			System.exit(0);
		}
		double yleg = Double.parseDouble(box9);
		
		dArray[x] 	= dleg;	//[x][0]
		xArray[x]	= xleg; //[x][1]
		yArray[x]	= yleg;	//[x][2]
		
		//STORE : USERCAR CALCULATION(S) FOR EACH LEG
		//double look;
		//look = 
		userCar.drive ( dArray[x], xArray[x], yArray[x]);
		xcordArray[x] = userCar.getX();
		ycordArray[x] = userCar.getY();
		
		
		//System.out.println("Distance: " + dArray[x] + " ( X :" + xArray[x] + " , Y :" + yArray[x] + ") : DRIVE = " + look);
		//System.out.println("LIMIT : " + limit);
		//INCREMENT NUMBER TO INDICATE LEG #
		number++;
		//System.out.printf("current size x : " + x );
		// END OF LOOP : CYCLE TO NEXT LEG(S)
	}
	
	
	DrivePanel dPanel = new DrivePanel(xcordArray,ycordArray,limit); 
	JFrame application = new JFrame();
	application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	application.add( dPanel);
	application.setSize(600, 600);
	application.setVisible(true);
	
	
	
	
}

	
}

