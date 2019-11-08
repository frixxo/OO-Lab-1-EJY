import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

abstract public class Vehicle implements Movable{
    protected Point2D direction;
    protected Point position;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;

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
     * @param   doors how many doors the vehicle is supposed to havehas
     * @param   color the color the vehicle is supposed to have
     * @param   enginePower the enginepower the car is supposed to have
     * @param   modelName the name of the vehicle model
     * */
    protected void initialize(int doors,Color color, int enginePower,String modelName){
        this.color = color;
        this.enginePower = enginePower;
    }
    //endregion
    //region Start/Stop engine
    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
    //endregion

    //region Getters/Setters
    public Point2D getDirection() {
        return direction;
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

    public Point getPosition(){ return position; }
    //endregion



    /** checks if the vehicle is moving
     * @return if the vehicle is moving
     * */
    protected boolean isMoving(){
        return (Math.abs(currentSpeed)-0.01<0);
    }
    //endregion

    //region move methods
    /** move car ahead*/
    public void move(){
        position.translate((int) (direction.getX()*currentSpeed),(int)(direction.getY()*currentSpeed));
    }
    public void turnLeft(){
        rotate(turnAngle);
    }
    public void turnRight(){
        rotate(360-turnAngle);
    }

    /** calculates the rotation of the car when using turn methods
     * @param angle how much to turn
     * */
    private void rotate (double angle)
    {
        angle = angle*(Math.PI/180);
        double x = direction.getX();
        double y = direction.getY();
        direction.setLocation(x*Math.cos(angle) - y*Math.sin(angle), x*Math.sin(angle) + y*Math.cos(angle));
    }
    //endregion
}
