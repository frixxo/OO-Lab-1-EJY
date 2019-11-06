import java.awt.*;
import java.awt.geom.Point2D;


/**
 * Represents a car and has all the
 * common variables and methods needed.
 */

public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Point2D direction;      /** 2D points have double coordinates.*/
    protected Point position;

    private final int turnAngle =  90;
    //region Start/Stop engine
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    //endregion

    //region Getters/Setters
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }
    //endregion

    //region speed methods
    public abstract double speedFactor();

    public void incrementSpeed(double amount){  currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower); }

    public void decrementSpeed(double amount){  currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
    //endregion

    //region move methods
    public void move(){
        position.translate((int) (direction.getX()*currentSpeed),(int)(direction.getY()*currentSpeed));
    }
    public void turnLeft(){
        rotate(turnAngle);
    }
    public void turnRight(){
        rotate(-turnAngle);
    }

    private void rotate(double angle)
    {
        angle = angle*(180/Math.PI);
        double x = direction.getX();
        double y = direction.getY();
        direction.setLocation(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) - y*Math.cos(angle));
    }
    //endregion
}
