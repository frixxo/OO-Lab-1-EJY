package Gui;

import Flak.IHasFlak;
import LastHandle.IHasLast;
import Movables.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
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
    ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new LamborghiniGallardo(new Point(0,100),new Point(1,0)));
        cc.cars.add(new Scania(new Point(0,200),new Point(1,0)));
        cc.cars.add(new CarTransport(new Point(350,0),new Point(0,1)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                car.move();
                hasHitWall(car);

                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void hasHitWall(Vehicle vehicle){
        Point pos = vehicle.getPosition();
        Point2D dir = vehicle.getDirection();
        if(dir.getX() > 0 && pos.x + frame.getSize(vehicle).x >= frame.getWidth() ||
                dir.getX() < 0 && pos.x <= 0){
            changeDirection(vehicle,-1,1);
        }
        if(dir.getY() > 0 && pos.y + frame.getSize(vehicle).y>= frame.getSize().height-240 ||
                dir.getY() < 0 && pos.y <= 0){
            changeDirection(vehicle,1,-1);
        }
    }
    private void changeDirection(Vehicle vehicle,int x, int y){
        vehicle.stopEngine();
        vehicle.fixPosition(new Point(frame.getSize().width,frame.getSize().height-240));
        Point2D carDirection = vehicle.getDirection();
        carDirection.setLocation(carDirection.getX()*x, carDirection.getY()*y);
    }
    // Calls the gas method for each car once
    //region Vehicle functionality
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }
    void startEngline() {
        for (Vehicle car : cars
        ) {
            car.startEngine();
        }
    }
    void stopEngline() {
        for (Vehicle car : cars
        ) {
            car.stopEngine();
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }
    void RaiseFlak() {
        for (Vehicle car : cars
        ) {
            if(car instanceof IHasFlak) {
                ((IHasFlak) car).raiseFlak();
            }
        }
    }
    void LowerFlak() {
        for (Vehicle car : cars
        ) {
            if(car instanceof IHasFlak) {
                ((IHasFlak) car).lowerFlak();
            }
        }
    }
    //endregion
}
