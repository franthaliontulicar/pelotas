import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        int index = 0;
        Random rand = new Random();
        int xPo;
        int yPo;
        int dia;
        ArrayList<BouncingBall> pelotas = new ArrayList<BouncingBall>();
        while(numBolas > index){
            Color col = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            xPo = rand.nextInt(70);
            yPo = rand.nextInt(70);
            dia = rand.nextInt(20);
            pelotas.add(new BouncingBall(xPo, yPo, dia, col, ground, myCanvas));
            index++;

        }

        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);  
            for(int i = 0;i < pelotas.size();i++)
            {
                pelotas.get(i).move();
           
                if (pelotas.get(i).getXPosition() >= 550)
                {
                    finished = true;
                }
            }

        }

       
    }
}
