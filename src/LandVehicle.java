import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;
/**
 * Represents a car and has all the
 * common variables and methods needed.
 */

<<<<<<< Updated upstream
public abstract class LandVehicle extends Vehicle {
    protected int nrDoors;
=======
<<<<<<< HEAD
public abstract class LandVehicle extends Vehicle {
    protected int nrDoors;
=======
public abstract class LandVehicle extends Vehicle implements Movable{
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
    protected String modelName;
    protected String RegNr;
    public static int RegKey = 11857;
    Random r = new Random(RegKey);


<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
    /**
     * 2D points have double coordinates.
     */
    protected Point2D direction;
    protected Point position;

    /**
     * How much a car turns when turn method called
     */
    protected int turnAngle = 90;

<<<<<<< Updated upstream
    //region Constructors
    protected LandVehicle(Point position, Point2D direction) {
        super(position, direction);
    }

    protected LandVehicle() {
        super();
    }

    /**
     * has all common variables for the constructors
     *
     * @param doors       how many doors the vehicle is supposed to havehas
     * @param color       the color the vehicle is supposed to have
     * @param enginePower the enginepower the car is supposed to have
     * @param modelName   the name of the vehicle model
     */
    protected void initialize(int doors, Color color, int enginePower, String modelName) {
        this.nrDoors = doors;
=======
    //region Constructors
    protected LandVehicle(Point position, Point2D direction) {
        super(position, direction);
    }

    protected LandVehicle() {
        super();
    }

    /**
     * has all common variables for the constructors
     *
     * @param doors       how many doors the vehicle is supposed to havehas
     * @param color       the color the vehicle is supposed to have
     * @param enginePower the enginepower the car is supposed to have
     * @param modelName   the name of the vehicle model
     */
    protected void initialize(int doors, Color color, int enginePower, String modelName) {
        this.nrDoors = doors;
=======
    //region Constructors
    protected LandVehicle(Point position, Point2D direction){
        super(position, direction);
    }
    protected LandVehicle(){
        super();
    }
    /** has all common variables for the constructors
     * @param   doors how many doors the vehicle is supposed to havehas
     * @param   color the color the vehicle is supposed to have
     * @param   enginePower the enginepower the car is supposed to have
     * @param   modelName the name of the vehicle model
     * */
    protected void initialize(int doors,Color color, int enginePower,String modelName){
        initialize(doors, color, enginePower);
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
        this.modelName = modelName;
        //RegNr Generator
        RegKey--;
        r = new Random(RegKey);
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
        this.RegNr = (char) (r.nextInt(26) + 'a') + "" + (char) (r.nextInt(26) + 'a') + "" + (char) (r.nextInt(26) + 'a') + " " + r.nextInt(10) + "" + r.nextInt(10) + "" + r.nextInt(10);

    }

<<<<<<< Updated upstream
=======
=======
        this.RegNr=(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+" "+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);
    }
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
    //endregion

    //region Getters/Setters
    public String getRegNr() {
        return RegNr;
    }
<<<<<<< HEAD

    public int getNrDoors() {
        return nrDoors;
    }

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
<<<<<<< Updated upstream
=======
    //endregion
=======
>>>>>>> Stashed changes
    //endregion

>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
}
