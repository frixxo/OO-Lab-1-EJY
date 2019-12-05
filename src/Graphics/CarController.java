package Graphics;

import Systems.CollisionHandler;
import Systems.Physics;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.*;
import WorldObjects.WorldObjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    ArrayList<WorldObjectView> cars = new ArrayList<>();

    private Physics physics;
    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        // no
       cc.cars.add(new Volvo240());
        cc.cars.add(new LamborghiniGallardo(new Point(0,100),new Point (1,0)));
        cc.cars.add(new Scania(new Point(0,200),new Point(1,0)));
        cc.cars.add(new CarTransport(new Point(350,0),new Point(0,1)));
        cc.cars.add(new Saab95(new Point(0,560),new Point(0,-1)));
        cc.cars.add(new CarFerry(new Point(200,0),new Point(0,1)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.physics=new Physics(cc.frame.windowSize());
        // Make sure cars are in frame
        for (WorldObjectView car : cc.cars) {
            cc.physics.update(car);
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (WorldObjectView car : cars) {
                if(car instanceof Drivable) {
                    ((Drivable)car).move();
                }
                physics.update(car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }

        }
    }


    // Calls the gas method for each car once
    //region Vehicle functionality
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (WorldObjectView car : cars){
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().gas(gas);
            }
        }
    }
    void startEngline() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().startEngine();
            }
        }
    }
    void stopEngline() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().stopEngine();
            }

        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (WorldObjectView car : cars
        ) {
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().brake(brake);
            }
        }
    }
    void RaiseFlak() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof IHasStorage) {
                ((IHasStorage) car).getStorage().getContainer().closeContainer();
            }
        }
    }
    void LowerFlak() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof IHasStorage) {
                ((IHasStorage) car).getStorage().getContainer().openContainer();
            }
        }
    }
    void TurnLeft() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof Drivable) {
                ((Drivable)car).turnLeft();
            }
        }
    }
    void TurnRight() {
        for (WorldObjectView car : cars
        ) {
            if(car instanceof Drivable) {
                ((Drivable)car).turnRight();
            }
        }
    }
    //endregion
}
