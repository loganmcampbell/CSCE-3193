public class SpriteMover implements Runnable

{
	Model 	containM;
	View 	containV;
	
	public SpriteMover ( Model modelT, View viewT)
	{
		containM = 	modelT;
		containV = 	viewT;
	}
	
	
	
	
	public void run() 
		{
			while (true)
			{
				containM.updateScene(containV.getHeight(), containV.getWidth());
				containV.repaint();
			
		        try {
		            Thread.sleep(2);
		        } catch (InterruptedException e) {}
			}
		}	
}
