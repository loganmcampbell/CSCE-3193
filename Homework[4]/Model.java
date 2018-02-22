import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

class Model
{
    //private Sprite sprite;
    int car;
    //CREATE AN ARRAY OF SPRITE
    private ArrayList<Sprite>  arraySprites;
    
    Model() throws IOException
    {	
    	arraySprites = new ArrayList<Sprite>();
		//sprite = new Sprite("red-car.jpg");
    	car = 1;
    	CopCar initialCar = new CopCar();
    	arraySprites.add(initialCar);
    }
    

    
    public void update(Graphics g)
    {
    	
    	//sprite.update(g);
    	for (Sprite sprite: arraySprites)
    	{
    		sprite.update(g);
    	}
    	
    }
    
    public void specificSprite ( int x, int y)
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
    	//ADD NEWSPRITE TO ARRAY LIST
    	arraySprites.add((Sprite)newSprite);
    	
    }
    
    public void fillCarUp() {
        for (Sprite sprite : arraySprites) {
          ((Car)sprite).fillUp();
        }
      }
}
