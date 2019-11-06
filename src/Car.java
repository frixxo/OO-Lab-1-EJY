import java.awt.*;

public abstract class Car {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name

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

    //region Abstract classes
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
}
