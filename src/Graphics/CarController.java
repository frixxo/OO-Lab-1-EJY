package Graphics;

import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.*;

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
    ArrayList<WorldObject> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        // no
       cc.cars.add(new Volvo240());
        cc.cars.add(new LamborghiniGallardo(new Point(0,100),new Point (1,0),new Point(20,20)));
        cc.cars.add(new Scania(new Point(0,200),new Point(1,0),new Point(20,20)));
        cc.cars.add(new CarTransport(new Point(350,0),new Point(0,1),new Point(20,20)));
        cc.cars.add(new Saab95(new Point(0,560),new Point(0,-1),new Point(20,20)));
        cc.cars.add(new CarFerry(new Point(200,0),new Point(0,1),new Point(40,40)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Make sure cars are in frame
        for (WorldObject car : cc.cars) {
            //car.fixPosition(new Point(cc.frame.getSize().width,cc.frame.getSize().height-240),cc.frame.drawPanel.getImageMap().get(car.getClass()).getSize());
        }
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (WorldObject car : cars) {
                if(car instanceof Drivable) {
                    ((Drivable)car).move();
                }
                    hasHitWall(car);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    private void hasHitWall(WorldObject vehicle){
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
    private void changeDirection(WorldObject vehicle,int x, int y){
        //vehicle.stopEngine();                                     //stops the cars when hitting a wall. if commented cars will turn around instantly and run with same speed the other way
       // vehicle.fixPosition(new Point(frame.getSize().width,frame.getSize().height-240),frame.drawPanel.getImageMap().get(vehicle.getClass()).getSize());
        vehicle.setDirection(new Point.Double(vehicle.getDirection().getX()*x, vehicle.getDirection().getY()*y));
    }
    // Calls the gas method for each car once
    //region Vehicle functionality
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (WorldObject car : cars){
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().gas(gas);
            }
        }
    }
    void startEngline() {
        /*for (Drivable car : cars
        ) {
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor()
            }

        }*/
    }
    void stopEngline() {
       /* for (Vehicle car : cars
        ) {
            car.stopEngine();
        }*/
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (WorldObject car : cars
        ) {
            if(car instanceof IHasMotor){
                ((IHasMotor) car).getMotor().brake(brake);
            }
        }
    }
    void RaiseFlak() {
        for (WorldObject car : cars
        ) {
            if(car instanceof IHasStorage) {
                ((IHasStorage) car).getStorage().getContainer().closeContainer();
            }
        }
    }
    void LowerFlak() {
        for (WorldObject car : cars
        ) {
            if(car instanceof IHasStorage) {
                ((IHasStorage) car).getStorage().getContainer().openContainer();
            }
        }
    }
    void TurnLeft() {
        for (WorldObject car : cars
        ) {
            if(car instanceof Drivable) {
                ((Drivable)car).turnLeft();
            }
        }
    }
    void TurnRight() {
        for (WorldObject car : cars
        ) {
            if(car instanceof Drivable) {
                ((Drivable)car).turnRight();
            }
        }
    }
    //endregion
}
