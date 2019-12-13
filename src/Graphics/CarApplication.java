package Graphics;

import Systems.CarSimulator;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.*;
import WorldObjects.InterfaceHierarchy.WorldObjectView;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarApplication {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    private CarWidget frame;
    //methods:

    private CarSimulator cs;

    public static void main(String[] args) {
        // Instance of this class
        CarApplication cc = new CarApplication();
        // Start a new view and send a reference of self
        cc.frame = new CarWidget("CarSim 1.0", cc);
        cc.cs = new CarSimulator(cc.frame.windowSize(), 10);
        //frame.drawPanel.repaint();
    }

}
