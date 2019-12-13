package Graphics;

import Systems.CarSimulator;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.*;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarApplication {
    // member fields:

    private Point windowSize = new Point(800, 800);
    private Point worldSize = new Point (windowSize.x, windowSize.y-240);
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    private CarWidget frame;
    private DrawPanel drawPanel;
    //methods:

    private CarSimulator cs;

    public static void main(String[] args) {
        // Instance of this class
        CarApplication cc = new CarApplication();
        // Start a new view and send a reference of self
        cc.frame = new CarWidget("CarSim 1.0", cc.getWindowSize());
        cc.cs = new CarSimulator(cc.getWorldSize(), 10);
        cc.drawPanel  = new DrawPanel(cc.getWorldSize().x, cc.getWorldSize().y, cc.cs);
        //frame.drawPanel.repaint();
    }

    public Point getWorldSize ()
    {
        return new Point(worldSize);
    }

    public Point getWindowSize ()
    {
        return new Point(worldSize);
    }

}
