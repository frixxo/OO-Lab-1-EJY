package WorldObjects;

import Fuctionality.*;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TurboMotor;
import LableInterfaces.IHasTurbo;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Represent a Movables.Saab95
 */
public class Saab95 extends WorldObject implements Car,Vehicle,Movable,IHasTurbo {
    private MoveHandler Driver=new VehicleDriver(this);
    private RotationHandler Steerer=new VehicleSteerer(this);
    private TurboMotor engine = new TurboMotor(20,Driver);
    private String ModelName="Saab95";
    private String RegNr;
    private RegNrGenerator reg = new RegNrGenerator();

    //region constructors
    public Saab95(Point position, Point2D direction, Point size){
        super(position,direction, size, false);
        RegNr=reg.generate();
    }

    //endregion
    
    @Override
    public void setTurbo(boolean turbo) {engine.setTurbo(turbo);}

    @Override
    public IMotor getMotor() { return engine; }

    @Override
    public MoveHandler getDriveHandler() {
        return Driver;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return Steerer;
    }

    @Override
    public String getModelName() {
        return ModelName;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }
}