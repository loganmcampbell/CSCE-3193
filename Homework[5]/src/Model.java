import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



class Model 
{
    //private Sprite sprite;
    int car;
    //CREATE AN ARRAY OF SPRITE
    private ArrayList<Sprite>  arraySprites = new ArrayList<Sprite>();
    

	    Model() throws IOException
	    {	
	    
	     {
		    	//arraySprites = new ArrayList<Sprite>();
				//sprite = new Sprite("red-car.jpg");
	    	 synchronized(arraySprites)
	    	 {
		    	car = 1;
		    	//CopCar initialCar = new CopCar();
		    	
		    	Bank bankHouse = new Bank();
		    	
		    	arraySprites.add(bankHouse);
	    	 }
	     }
	    }
    
    public void update(Graphics g)
    {
    	synchronized(arraySprites)
    	{
	    	//sprite.update(g);
	    	for (Sprite sprite: arraySprites)
	    	{
	    		sprite.updateImage(g);
	    	}
    	}
    }
    
    public void specificSprite ( int x, int y)
    {
    	synchronized(arraySprites)
    	{
	    	//DECLARE NEW SPRITE
	    	//Sprite newSprite;
	    	Object newSprite;
	    	if (car == 0)
	    	{
	    		newSprite = new CopCar();
	    	}
	    	else
	    	{
	    		newSprite = new RobberCar();
	    	}
	    	
	    	car = ( car + 1 ) % 2;
	    	//SET NEW SPRITE
	    	
	    	((Sprite)newSprite).setX(x);
	    	((Sprite)newSprite).setY(y);
	    	if (car == 0)
	    	{
	    		((Sprite)newSprite).setX(300);
	    		((Sprite)newSprite).setY(300);
	    	}
	    	//ADD NEWSPRITE TO ARRAY LIST
	    	arraySprites.add((Sprite)newSprite);
    	}
    }
    
    public void updateScene(int width, int height)
    {
    	synchronized(arraySprites)
    	{
	    	Iterator<Sprite> iterator = arraySprites.iterator();
	    	
	    	while(iterator.hasNext())
	    	{
	    		Sprite s = iterator.next();
	    		if (s instanceof RobberCar)
	    		{
	    			if (((RobberCar) s).escapedRob)
	    			{
	    				
	    				System.out.println("I A M F R E E !");
	    				iterator.remove();
	    			}
	    		}
	    		
	    	}
	
	    	for (Sprite sprite: arraySprites)
	    	{
	    		
	    		sprite.updateState(width,height);
	    	}
	    	for (int x = 0; x < arraySprites.size(); x++)
	    	{
	    		if (arraySprites.get(x)  instanceof CopCar)
	    		{	
	    			for (int z = 0; z < arraySprites.size(); z++)
	    			{
	    				if (arraySprites.get(z) instanceof RobberCar)
	    				{
	    					if (arraySprites.get(z).overlaps(arraySprites.get(x)))
	    					{
	    						((RobberCar)arraySprites.get(z)).captured();
	
	    					}
	    				}
	    		
	    			
	    			}
	    		}
	    	}
    	}	

    }

    public void initalize ()
    {
    	synchronized(arraySprites)
    	{
	    	arraySprites = new ArrayList<Sprite>();
	    	Bank bankHouse = new Bank();
			arraySprites.add(bankHouse);
			RobberCar.capNum = 0;
			RobberCar.escNum = 0;
			car = 1;
    		
//    		Iterator<Sprite> iter = arraySprites.iterator();
//    		while(iter.hasNext())
//    		{
//    			iter.next();
//    			iter.remove();
//    		}
//    		Bank bankHouse = new Bank();
//    		arraySprites.add(bankHouse);
//    		
//    		car = 1;
//    		RobberCar.capNum = 0;
//    		RobberCar.escNum = 0;
    		
    		
    		
    	}
    }




}
