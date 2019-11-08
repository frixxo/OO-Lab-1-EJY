import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;
/**
 * Represents a car and has all the
 * common variables and methods needed.
 */

public abstract class LandVehicle extends Vehicle implements Movable{
    protected String modelName;
    protected String RegNr;
    public static int RegKey=11857;
    Random r = new Random(RegKey);


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
        this.modelName = modelName;
        //RegNr Generator
        RegKey--;
        r = new Random(RegKey);
        this.RegNr=(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+""+(char)(r.nextInt(26) + 'a')+" "+r.nextInt(10)+""+r.nextInt(10)+""+r.nextInt(10);
    }
    //endregion

    //region Getters/Setters
    public String getRegNr() {
        return RegNr;
    }
    //endregion

}
