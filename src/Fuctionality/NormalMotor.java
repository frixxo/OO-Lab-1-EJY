package Fuctionality;

import WorldObjects.Movables.Movable;
import WorldObjects.Movables.Vehicle;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class NormalMotor implements IMotor{
    private double power;
    private int frameCounter=0;

    public NormalMotor(double power){
        this.power=power;
        stopEngine();
    }
    public abstract double SpeedFactor();


    public double getPower() { return power; }


    /** increase speed set amount
     * @param amount how much to decrease
     * */
    public double incrementSpeed(double amount){  return Math.min(getCurrentSpeed() + SpeedFactor() * amount,power); }

    /** decrease speed set amount
     * @param amount how much to decrease
     * */
    public double decrementSpeed(double amount){   return; Math.max(getCurrentSpeed() - SpeedFactor() * amount,0);}

    /** apply gas
     * @param amount how much to gas
     * */
    public double gas(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        return incrementSpeed(amount);
    }

    /** apply brake
     * @param amount how much to brake
     */
    public double brake(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        return decrementSpeed(amount);
    }

    /** checks if the vehicle is moving
     * @return if the vehicle is moving
     * */
    public boolean isMoving(){
        return (Math.abs(currentSpeed)-0.001>0);
    }
    //endregion

    //region move methods
    /** move car ahead*/

}
