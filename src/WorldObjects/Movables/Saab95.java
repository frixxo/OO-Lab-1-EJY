package WorldObjects.Movables;

import Fuctionality.IMotor;
import LableInterfaces.IHasMotor;
import LableInterfaces.IHasTurbo;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represent a Movables.Saab95
 */
public class Saab95 implements Car, IHasMotor, IHasTurbo {
    private boolean turboOn;

    //region constructors
    public Saab95(Point position, Point2D direction){
        super(position,direction);
        initialize(4,Color.red,125,"Saab95");
        setTurboOn(false);
    }
    public Saab95(){
        super();
       initialize(4,Color.red,125,"Saab95");
       setTurboOn(false);
    }
    //endregion

    public void setTurboOn(boolean TrueOrFalse){
	    turboOn = TrueOrFalse;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return engine.Power * 0.01 * turbo;
    }

    @Override
    public void initialize(int doors, Color color, int enginePower, String modelName, IMotor motor) {
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
    public void setTurbo(boolean turbo) {

    }

    @Override
    public boolean getTurbo() {
        return false;
    }

    @Override
    public Point getPosition() {
        return null;
    }
}
