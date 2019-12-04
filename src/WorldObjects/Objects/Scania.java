package WorldObjects.Objects; /** A scania truck*/
import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.Containers.Flak;
import Fuctionality.Storage.FlakStorage;
import Fuctionality.Storage.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.Storage.LastHandle.LoadHandler;
import WorldObjects.Truk;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends WorldObject implements Truk {
    private MoveHandler driver = new VehicleDriver();
    private RotationHandler steerer = new VehicleSteerer();
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Flak(), new LoadHandler <>(this,10, 2,3, 3, LoadHandler.Principle.FILO));
    private IDGenerator reg=new RegNrGenerator();
    private String modelname = "Scania";
    private String RegNr;
    private int turnAngle=90;


    public Scania(Point position, Point2D direction, Point size) {
        super(position,direction, size, false);
    }
    public Scania() {
        this(new Point(0,0),new Point(1,0), null);
    }

    @Override
    public IMotor getMotor(){ return engine; }

    @Override
    public String getModelName() { return modelname; }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public Storage getStorage(){return storage; }

    @Override
    public void turnLeft() {
        steerer.turnLeft(turnAngle,getDirection());
    }

    @Override
    public void turnRight() {
        steerer.turnRight(turnAngle,getDirection());
    }

    @Override
    public void move() {
        driver.move(getPosition(),getDirection(),getStatic());
    }

    @Override
    public double getCurrentSpeed() {
        return driver.getCurrentSpeed();
    }
}
