package WorldObjects.Objects;

import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.SpoilerDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Systems.CollisionHandler;
import WorldObjects.LableInterfaces.IHasSpoiler;
import WorldObjects.Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Lamborghini Gallardo that has a Spoiler that decreases speed but increases turning ability, is also epic.
 */
public class LamborghiniGallardo extends Drivable implements Car, IHasSpoiler {
    private boolean epic;
    private RotationHandler steerer=new VehicleSteerer();
    private SpoilerDriver driver=new SpoilerDriver();
    private StandardMotor motor = new StandardMotor(320,driver);
    private RegNrGenerator reg=new RegNrGenerator();
    private String ModelName="Lamborghini Gallardo";
    private String RegNr;
    private CollisionHandler collider=new CollisionHandler();

    //region constructors
    public LamborghiniGallardo(Point position, Point2D direction){
        super(position,direction,new Point(70,50),false);
        epic = true;
        this.RegNr=reg.generate();
    }
    public LamborghiniGallardo(){
        this(new Point(0,0),new Point(1,0));
    }

    @Override
    public IMotor getMotor() {
        return motor;
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
        turnAngle=95;
    }

    @Override
    public void LowerSpoiler() {
        driver.lowerSpoiler();
        turnAngle=90;
    }

    @Override
    public RotationHandler getRotationHandler() { return steerer;}

    @Override
    public MoveHandler getDriver() { return driver; }

    @Override
    public void updateCollider(Point Worldsize) {
        collider.hasHitWall(this,Worldsize);
    }
}
