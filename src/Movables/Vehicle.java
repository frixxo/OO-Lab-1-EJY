package Movables;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** A vehicle, an abstract concept*/
abstract public class Vehicle implements Movable{
    private int fixLowSpeed=1;
    protected Point picsize;
    protected String modelName;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected boolean IsLoaded=false;

    /** 2D points have double coordinates.*/
    protected Point2D direction;
    protected Point position;

    /** How much a car turns when turn method called */
    protected int turnAngle =  45;
    //region Constructors
    protected Vehicle(Point position, Point2D direction){
        this.position = position;
        this.direction = direction;
        stopEngine();
    }
    protected Vehicle(){
        this.position = new Point(0,0);
        this.direction = new Point(1,0);
        stopEngine();
    }
    /** has all common variables for the constructors
     * @param   color the color the vehicle is supposed to have
     * @param   enginePower the enginepower the car is supposed to have
     * @param   modelname the model of the car
     * @param   picsize the size of the picture (if (null) size = 70x50)
     * */
    protected void initialize(Color color, int enginePower,String modelname,Point picsize){
        this.modelName=modelname;
        this.color = color;
        this.enginePower = enginePower;
        if(picsize==null){
            this.picsize=new Point(70,50);}
        else{
            this.picsize=picsize;}
    }
    //endregion
    //region Start/Stop engine
    public void startEngine(){
        if(currentSpeed<0.1)currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }
    //endregion

    //region Getters/Setters
    public boolean getIsLoaded(){return IsLoaded;}
    public void setIsLoaded(boolean b){IsLoaded = b;}
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
    public Point getPosition(){ return position; }
    public Point2D getDirection() { return direction; }
    public Point getPicsize(){return picsize;}
    //endregion

    //region speed methods
    /** calculates how much the speed should increase with
     * @return how much the speed increases
     * */
    public abstract double speedFactor();

    /** increase speed set amount
     * @param amount how much to decrease
     * */
    private void incrementSpeed(double amount){  currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower); }

    /** decrease speed set amount
     * @param amount how much to decrease
     * */
    private void decrementSpeed(double amount){  currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);}

    /** apply gas
     * @param amount how much to gas
     * */
    public void gas(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        incrementSpeed(amount);
    }

    /** apply brake
     * @param amount how much to brake
     */
    public void brake(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        decrementSpeed(amount);
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
    public void move(){
        if(!IsLoaded){
            if(currentSpeed*fixLowSpeed<0.5)fixLowSpeed++;            //Helps when speed is low so that the car moves every other frame instead of not moving at all
            else { fixLowSpeed=1;}
            position.translate((int)Math.round(direction.getX()*currentSpeed*fixLowSpeed),(int)Math.round(direction.getY()*currentSpeed*fixLowSpeed));
        }
    }
    public void turnLeft(){
        rotate(turnAngle);
    }
    public void turnRight(){
        rotate(360-turnAngle);
    }

    /** calculates the rotation of the car when using turn methods (Origo is top left so we had to flip the rotation using -y)
     * @param angle how much to turn
     * */
    private void rotate (double angle)
    {
        angle = angle*(Math.PI/180);
        double x = direction.getX();
        double y = direction.getY();
        direction.setLocation(-(x*Math.cos(angle) - y*Math.sin(angle)), -(x*Math.sin(angle) + y*Math.cos(angle)));
    }

    /** makes sure that the car is not slightly outside of frame when hitting a wall and puts it back on the border
     * @param windowsize the size of the window cars are allowed to drive in
     * */
    public void fixPosition(Point windowsize){
        if(position.x+(picsize.x)>windowsize.x){      //corrects right
            position.x=(windowsize.x-(picsize.x));
        }if(position.y+(picsize.y)>windowsize.y){     //corrects down
            position.y=(windowsize.y-(picsize.y));
        }if(position.x<0){                              //corrects left
            position.x=0;
        }if(position.y<0){                              //corrects up
            position.y=0;
        }
    }
    //endregion
}
