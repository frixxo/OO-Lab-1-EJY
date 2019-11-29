package WorldObjects;
import Flak.FlakStorage;
import Flak.Ramp;
import Flak.IFlak;
import Flak.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.NormalMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.MoveHandler;
import Fuctionality.VehicleDriver;
import Fuctionality.VehicleSteerer;
import LableInterfaces.IHasMotor;
import LableInterfaces.IHasStorage;
import LastHandle.IHandleLast;
import LastHandle.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends WorldObject implements IHasStorage, IHasMotor, Movable, Vehicle {

    private String modelname = "CarFerry";
    private RotationHandler steerer = new VehicleSteerer(this);
    private MoveHandler driver = new VehicleDriver(this);
    private IMotor engine = new StandardMotor(10, driver);
    private Storage storage = new FlakStorage(new Ramp(), new LoadHandler<Car>(this, 20, 2, 10, 10, LoadHandler.Principle.FIFO));


    public CarFerry(){
        super();
        super.initialize(Color.YELLOW,100,"CarFerry");
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
    }
    public CarFerry(Point position, Point2D direction){
        super(position,direction);
        super.initialize(Color.yellow,100,"CarFerry");
        load = new LoadHandler<>(this, 5000, 40, 20, 10, LoadHandler.Principle.FIFO);
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
