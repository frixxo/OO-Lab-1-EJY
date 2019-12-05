package WorldObjects.Objects;

import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TurboMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import WorldObjects.LableInterfaces.IHasTurbo;
import WorldObjects.Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represent a Movables.Saab95
 */
public class Saab95 extends WorldObject implements Car,IHasTurbo {
    private MoveHandler driver=new VehicleDriver();
    private RotationHandler steerer=new VehicleSteerer();
    private TurboMotor engine = new TurboMotor(100,driver);
    private RegNrGenerator reg = new RegNrGenerator();
    private String ModelName="Saab95";
    private String RegNr;
    private int turnAngle=90;


    //region constructors
    public Saab95(Point position, Point2D direction, Point size){
        super(position,direction, size, false);
        RegNr=reg.generate();
    }
    public Saab95(){
        this(new Point(0,0),new Point(1,0), null);
    }

    //endregion
    
    @Override
    public void setTurbo(boolean turbo) {engine.setTurbo(turbo);}

    @Override
    public IMotor getMotor() { return engine; }

    @Override
    public String getModelName() {
        return ModelName;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public RotationHandler getSteerer() {
        return null;
    }

    @Override
    public MoveHandler getDriver() {
        return null;
    }
}
