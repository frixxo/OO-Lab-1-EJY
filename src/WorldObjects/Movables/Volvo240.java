package WorldObjects.Movables;

import Fuctionality.IMotor;
import Fuctionality.StandardMotor;
import LableInterfaces.Car;
import LableInterfaces.ICar;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends Car {
    public final static double trimFactor = 1.25;
    IMotor engine;

    //region constructors
    public Volvo240(Point position,Point2D direction){

        initialize(4,Color.black,"Volvo240",new StandardMotor(100));

    }
    public Volvo240(){
        super();
        initialize(4,Color.black,"Volvo240",new StandardMotor(100));
    }
    //endregion
    @Override
    public double speedFactor(){
        return engine.getPower() * 0.01 * trimFactor;
    }

    @Override
    public void initialize(int doors, Color color, String modelName, IMotor motor) {
        this.engine=motor;
        this.

    }

    @Override
    public String getRegNr() {
        return null;
    }

    @Override
    public int getNrDoors() {
        return 0;
    }

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void gas() {

    }

    @Override
    public void brake() {

    }

    @Override
    public void move() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public Point2D getDirection() {
        return null;
    }

    @Override
    public boolean getIsLoaded() {
        return false;
    }

    @Override
    public void setIsLoaded(boolean b) {

    }

    @Override
    public IMotor getMotor() {
        return null;
    }

    @Override
    public Point getPosition() {
        return null;
    }
}
