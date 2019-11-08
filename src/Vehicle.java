import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

abstract public class Vehicle implements Movable{
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
=======
    protected int nrDoors;
    protected double enginePower;
    private double currentSpeed;
    protected Color color;

    /** 2D points have double coordinates.*/
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
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
     * */
<<<<<<< HEAD
    protected void initialize(int doors,Color color, int enginePower,String modelName){
<<<<<<< Updated upstream
=======
=======
    protected void initialize(int doors,Color color, int enginePower){
        this.nrDoors = doors;
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
    public Point2D getDirection() {
        return direction;
    }

<<<<<<< Updated upstream
=======
=======
    public int getNrDoors(){
        return nrDoors;
    }
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream


=======

<<<<<<< HEAD
=======
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
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a

>>>>>>> Stashed changes
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
