package WorldObjects;

import Flak.FlakStorage;
import Flak.Ramp;
import Flak.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.MoveHandler;
import Fuctionality.VehicleDriver;
import Fuctionality.VehicleSteerer;
import LastHandle.LoadHandler;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/

public class CarTransport extends WorldObject implements Truk {
    // TODO HELP
    private final static String model = "CarTransport";
    private MoveHandler driver = new VehicleDriver(this);
    private Movable.RotationHandler steerer = new VehicleSteerer(this);
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Ramp(), new LoadHandler<Car>(this,10, 2,3, 3, LoadHandler.Principle.FILO));

    public CarTransport(Point position, Point2D direction, Point size) {
        super(position,direction, size, false);
    }
    public CarTransport(Point position, Point2D direction, Point Size){
        super(position,direction,Size,false);
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);

    }

    @Override
    public String getModelName() {
        return model;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return steerer;
    }

    @Override
    public MoveHandler getDriveHandler() {
        return driver;
    }

    @Override
    public Storage getStorage() { return storage; }

    @Override
    public IMotor getMotor() { return engine; }
}
