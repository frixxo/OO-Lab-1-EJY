package WorldObjects.Objects;

import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TurboMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Systems.CollisionHandler;
import WorldObjects.LableInterfaces.IHasTurbo;
import WorldObjects.Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represent a Movables.Saab95
 */
public class Saab95 extends Drivable implements Car,IHasTurbo {
    private MoveHandler driver=new VehicleDriver();
    private RotationHandler steerer=new VehicleSteerer();
    private TurboMotor engine = new TurboMotor(100,driver);
    private RegNrGenerator reg = new RegNrGenerator();
    private String ModelName="Saab95";
    private String RegNr;
    private CollisionHandler collider=new CollisionHandler();


    //region constructors
    public Saab95(Point position, Point2D direction){
        super(position,direction, new Point(70,50), false);
        RegNr=reg.generate();
    }
    public Saab95(){
        this(new Point(0,0),new Point(1,0));
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
    public RotationHandler getRotationHandler() { return steerer; }

    @Override
    public MoveHandler getMoveHandler() { return driver; }
}
