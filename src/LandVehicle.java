import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;


/**
 * Represents a car and has all the
 * common variables and methods needed.
 */

public abstract class LandVehicle extends Vehicle implements Movable{
    protected int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    protected Color color;
    protected String modelName;
    protected String RegNr;
    public static int RegKey=11857;
    Random r = new Random(RegKey);


    /** 2D points have double coordinates.*/
    protected Point2D direction;
    protected Point position;

    /** How much a car turns when turn method called */
    protected int turnAngle =  90;
    //region Constructors
    protected LandVehicle(Point position, Point2D direction){
        this.position = position;
        this.direction = direction;
        stopEngine();
    }
    protected LandVehicle(){
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
        this.nrDoors = doors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;

        //RegNr Generator
        RegKey--;
        r = new Random(RegKey);
        this.RegNr=(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+" "+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);

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

    public String getRegNr() {
        return RegNr;
    }

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

    public Point getPosition(){ return position; }
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
