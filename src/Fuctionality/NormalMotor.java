package Fuctionality;

import WorldObjects.Movables.Movable;
import WorldObjects.Movables.Vehicle;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class NormalMotor {
    double currentSpeed;
    double power;
    int frameCounter=0;

    public NormalMotor(double power){
        this.power=power;
        currentSpeed=0;
        stopEngine();
    }

    public double getCurrentSpeed() { return currentSpeed; }

    public double getPower() { return power; }

    public void startEngine(){
        if(currentSpeed<0.1)currentSpeed = 0.1;
    }
    public void stopEngine(){ currentSpeed = 0; }

    /** increase speed set amount
     * @param amount how much to decrease
     * */
    private void incrementSpeed(double amount,double speedfactor){  currentSpeed = Math.min(getCurrentSpeed() + speedfactor * amount,power); }

    /** decrease speed set amount
     * @param amount how much to decrease
     * */
    private void decrementSpeed(double amount,double speedfactor){  currentSpeed = Math.max(getCurrentSpeed() - speedfactor * amount,0);}

    /** apply gas
     * @param amount how much to gas
     * */
    public void gas(double amount,double speedfactor){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        incrementSpeed(amount,speedfactor);
    }

    /** apply brake
     * @param amount how much to brake
     */
    public void brake(double amount,double speedfactor){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        decrementSpeed(amount,speedfactor);
    }

    /** checks if the vehicle is moving
     * @return if the vehicle is moving
     * */
    protected boolean isMoving(){
        return (Math.abs(currentSpeed)-0.001>0);
    }
    //endregion

    //region move methods
    /** move car ahead*/
    public void move(Point position, Point2D direction,boolean IsLoaded){
        if(!IsLoaded){
            if(currentSpeed*frameCounter<0.5)frameCounter++;            //Helps when speed is low so that the car moves every other frame instead of not moving at all
            else { frameCounter=1;}
            position.translate((int)Math.round(direction.getX()*currentSpeed*frameCounter),(int)Math.round(direction.getY()*currentSpeed*frameCounter));
        }
    }
}
