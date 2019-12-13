package Graphics;

import Systems.CarController;
import Systems.CarSimulator;

import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarApplication {
    // member fields:

    private Dimension windowSize = new Dimension(800, 900);
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    private Frame frame;
    //methods:

    private CarSimulator cs;
    private CarController cc;

    public static void main(String[] args) {
        // Instance of this class
        CarApplication application = new CarApplication();
        application.frame=new Frame(application.getWindowSize(),application.cs,application.cc);
        application.frame.world.repaint();
        application.frame.speedLable.
    }

    public Dimension getWindowSize ()
    {
        return new Dimension(windowSize);
    }

}
