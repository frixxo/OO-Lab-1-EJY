package WorldObjects.Movables;

import java.awt.*;
import java.awt.geom.Point2D;

/** A vehicle, an abstract concept*/
abstract public class Vehicle implements Movable{
    private int fixLowSpeed=1;
    protected String modelName;
    protected double currentSpeed;
    protected Color color;
    protected boolean IsLoaded=false;

    /** 2D points have double coordinates.*/
    protected Point2D direction;
    protected Point position;

    /** How much a car turns when turn method called */
    protected int turnAngle =  90;

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
     * */
    protected void initialize(Color color, int enginePower,String modelname){
        this.modelName=modelname;
        this.color = color;
        this.enginePower = enginePower;
    }
    //endregion
    //region Start/Stop engine

    //endregion

    //region Getters/Setters
    public boolean getIsLoaded(){return IsLoaded;}
    public void setIsLoaded(boolean b){IsLoaded = b;}

    public int getTurnAngle(){return turnAngle;}

    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
        color = clr;
    }
    public Point getPosition(){ return position; }
    public Point2D getDirection() { return direction; }

    //endregion

    //region speed methods
    /** calculates how much the speed should increase with
     * @return how much the speed increases
     * */


    //endregion
}
