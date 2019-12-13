package Graphics;

import Systems.CarController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class Buttons extends JPanel{

    // The controller member
    Dimension windowSize;
    CarController cc;


    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turnLeftButton = new JButton("Turn Left");
    JButton turnRightButton = new JButton("Turn Right");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton TurboOn = new JButton("Turbo On");
    JButton TurboOff = new JButton("Turbo Off");
    JButton AddCar= new JButton("Add Car");
    JButton RemoveCar= new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public Buttons(CarController cc, Dimension windowSize){
        this.cc=cc;
        this.setPreferredSize(windowSize);
        initComponents();
    }

   // public <T>Point getSize(T obj){ return drawPanel.getSize(obj); }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents() {
        //Gas amount input
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,5));

        //original buttons

        controlPanel.add(gasButton, 0);
        controlPanel.add(TurboOn, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(TurboOff, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(AddCar,6);
        controlPanel.add(RemoveCar);

        /*
        controlPanel.add(gasButton, 0);
        controlPanel.add(turnLeftButton, 1);
        controlPanel.add(turnRightButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(liftBedButton, 4);
        controlPanel.add(lowerBedButton, 5);

        */
        controlPanel.setPreferredSize(new Dimension((windowSize.width/2)+4, windowSize.height-40));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(windowSize.height/5-15,windowSize.height-40));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(windowSize.width/5-15,windowSize.height-40));
        this.add(stopButton);

       //region button functionality
        startButton.addActionListener(e -> cc.startEngline());
        stopButton.addActionListener(e -> cc.stopEngline());
        gasButton.addActionListener(e -> cc.gas(gasAmount));
        brakeButton.addActionListener(e -> cc.brake(gasAmount));
        liftBedButton.addActionListener(e -> cc.raiseFlak());
        lowerBedButton.addActionListener(e -> cc.lowerFlak());
        turnLeftButton.addActionListener(e -> cc.turnLeft());
        AddCar.addActionListener(e -> cc.addCar());
        RemoveCar.addActionListener(e -> cc.removeCar());
        //endregion

    }
}