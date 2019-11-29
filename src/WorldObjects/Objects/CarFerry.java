package WorldObjects.Objects;
import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.FlakStorage;
import Fuctionality.Storage.Containers.Ramp;
import Fuctionality.Storage.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import Fuctionality.Storage.LastHandle.*;
import WorldObjects.Car;
import WorldObjects.Movable;
import WorldObjects.Vehicle;

import java.awt.*;
import java.awt.geom.Point2D;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends WorldObject implements IHasStorage, IHasMotor, Movable, Vehicle {

    private String modelname = "CarFerry";
    private RotationHandler steerer = new VehicleSteerer(this);
    private MoveHandler driver = new VehicleDriver(this);
    private IMotor engine = new StandardMotor(10, driver);
    private Storage storage = new FlakStorage(new Ramp(), new LoadHandler<Car>(this, 20, 2, 10, 10, LoadHandler.Principle.FIFO));
    private String RegNr;
    private IDGenerator reg=new RegNrGenerator();

    public CarFerry() {
    this(new Point(0,0),new Point(1,0),null)}
    public CarFerry(Point position, Point2D direction,Point Size){
        super(position,direction,Size,false);
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
        RegNr=reg.generate();
    }

    @Override
    public MoveHandler getDriveHandler() {
        return driver;
    }

    @Override
    public RotationHandler getSteerHandler() {
        return  steerer;
    }

    @Override
    public String getModelName() {
        return modelname;
    }

    @Override
    public String getRegNr() {
        return null;
    }

    @Override
    public IMotor getMotor() {
        return engine;
    }

    @Override
    public Storage getStorage() {
        return storage;
    }
}
