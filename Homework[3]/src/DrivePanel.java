import java.awt.Graphics;
import javax.swing.JPanel;

public class DrivePanel  extends JPanel
{
	public		int	[]	xcoordinates;
	public  	int []	ycoordinates;
	public 	int		bounds;
	
	public DrivePanel (int [] gXcoordinates, int [] gYcoordinates, int gbounds)
	{
		xcoordinates = gXcoordinates;
		ycoordinates = gYcoordinates;
		bounds	= gbounds;
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		int height 	= getHeight();
		
		g.drawLine(0, height, this.xcoordinates[0], height - this.ycoordinates[0]);
		g.drawString("(0,0)", 10, height - 10);
		
		for (int x = 0; x < bounds; x++ )
		{
			//System.out.println("current x for loop : " + x);
			
			int x1 = this.xcoordinates[x];
			int y1 = this.ycoordinates[x];
						
			if ( bounds > 1)
			{
				
				int x2 = xcoordinates[x++];
				int y2 = ycoordinates[x++];
				
				//DrawLine
				g.drawLine(x1, height - y1, x2, height - y2);
				//StringLine
				g.drawString("(" + x2 + ", " + y2 + ")", x2 + 10, height - y2);
			}
		}
}
}


