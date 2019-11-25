package Movables;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Random;
/**
 * Represents a vehicle moving on land
 */

public abstract class LandVehicle extends Vehicle{
    protected String RegNr;
    protected int nrDoors;
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
     * @param   picsize the size of the picture
     * */
    protected void initialize(int doors,Color color, int enginePower,String modelName,Point picsize){
        this.nrDoors=doors;
        super.initialize(color, enginePower,modelName,picsize);
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

    public int getNrDoors() { return nrDoors; }
    //endregion

}
