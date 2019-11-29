package WorldObjects;

import Fuctionality.*;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import LableInterfaces.IHasSpoiler;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends WorldObject implements Car,Movable,Vehicle,IHasSpoiler {
    private boolean spoilerUp;
    private boolean epic;
    private int startturnangle;
    private RotationHandler steerer=new VehicleSteerer(this);
    private SpoilerDriver driver=new SpoilerDriver(this);
    private StandardMotor motor = new StandardMotor(300,driver);
    private RegNrGenerator reg=new RegNrGenerator();
    private String ModelName="Lamborghini Gallardo";
    private String RegNr;


    //region constructors
    public LamborghiniGallardo(Point position, Point2D direction,Point size){
        super(position,direction,size,false);
        epic = true;
        this.RegNr=reg.generate();
    }
    public LamborghiniGallardo(){
        this(new Point(0,0),new Point(1,0),null);
    }

    @Override
    public IMotor getMotor() {
        return motor;
    }

    @Override
    public MoveHandler getDriveHandler() {
        return driver;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return steerer;
    }

    @Override
    public String getModelName() {
        return ModelName;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public void RaiseSpoiler() {
        driver.raiseSpoiler();
    }

    @Override
    public void LowerSpoiler() {
        driver.lowerSpoiler();
    }
}
