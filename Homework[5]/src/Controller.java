
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;





class Controller implements MouseListener,KeyListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) {
        model.update(g);
    }
  
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    public void keyTyped (KeyEvent e)
    { 
    	if (e.getKeyChar() == 'h')
    	{
    		System.out.println("HELLO WORLD");
    	}
    	if (e.getKeyChar() == 'n')
    	{
    		System.out.println("robbers captured : " + RobberCar.capNum + " robbers escaped : " + RobberCar.escNum);
    	}
    	if (e.getKeyChar() == 'r')
    	{
    		model.initalize();
    		view.repaint();
    	}
    	
    	if (e.getKeyChar() == 's')
    	{
//    		SpriteMover spriteMover = new SpriteMover (model, view);
//    		Thread thread = new Thread(spriteMover);
//    		//thread = Thread(spriteMover);
//    		thread.start();
    		
    		Thread t = new Thread (new SpriteMover (model, view));
    		t.start();
    		
    		
    		
    	}
    	
    }


	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) 
		{
			view.repaint();
			// Gets here is left mouse button was clicked
			model.specificSprite(e.getX(),e.getY());
			
		} else if (SwingUtilities.isRightMouseButton(e))  
		{
			// Gets here if right mouse button was clicked
			//model.fillCarUp();
			view.repaint();
			model.updateScene(view.getWidth(),view.getHeight());
			
		}
    }
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    
  
    
    
    
    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
    	System.out.println("cwd=" + System.getProperty("user.dir")); 
        new Controller();
    }
}

