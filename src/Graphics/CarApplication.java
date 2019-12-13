package Graphics;

import Systems.CarController;
import Systems.CarSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarApplication {
    // member fields:

    private Dimension windowSize = new Dimension(800, 800);
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The frame that represents this instance View of the MVC pattern
    private Frame frame;
    //methods:

    private CarSimulator cs;
    private java.util.List<JPanel> panels = new ArrayList<>();

    public static void main(String[] args) {
        // Instance of this class
        CarApplication application = new CarApplication();
        application.cs=new CarSimulator(new Point(application.getWindowSize().width,application.getWindowSize().height-240),10);
        application.panels.add(new DrawPanel(new Dimension(application.getWindowSize().width,application.getWindowSize().height-240),application.cs));
        application.panels.add(new Buttons(new Dimension(application.getWindowSize().width,application.getWindowSize().height-640),application.cs));
        JPanel panel=new JPanel();
        panel.add(new SpeedLabel(application.cs,new Dimension(800,40)));
        application.panels.add(panel);
        application.frame=new Frame(application.panels,application.getWindowSize());

        for (JPanel p:application.panels) {
           // p.update();             //TODO
        }
    }

    public Dimension getWindowSize ()
    {
        return new Dimension(windowSize);
    }

}
