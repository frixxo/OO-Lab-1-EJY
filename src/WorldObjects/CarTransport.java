package WorldObjects;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.MoveHandler;
import Fuctionality.VehicleDriver;
import Fuctionality.VehicleSteerer;
import LableInterfaces.IHasLast;
import LastHandle.*;
import Flak.*;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/
public class CarTransport extends WorldObject implements IHasLast<Car>, Truk {
    // TODO HELP
    private final static String model = "Scania";
    private MoveHandler driver = new VehicleDriver(this);
    private Movable.RotationHandler steerer = new VehicleSteerer(this);
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Flak(), new LoadHandler <Car>(this,10, 2,3, 3, LoadHandler.Principle.FILO));

    public CarTransport(Point position, Point2D direction, Point size) {
        super(position,direction, size, false);
    }
    public CarTransport() {
        this(new Point(0,0),new Point(1,0), null);
    }


    public boolean load(Car car) { return loadState() && storage.getLastHandler().load(car); }
    public Car release() { return (loadState()) ? storage.getLastHandler().release() : null; }

    @Override
    public void move(){ driver.move(); }
    @Override
    public boolean loadState() {
        return storage.getContainer().loadState();
    }
    @Override
    public void IsLoadedMove(Point p) {
        storage.getLastHandler().updatePosition(p);
    }

    public int getCarsLoaded(){ return storage.getLastHandler().getCargoCount(); }

    @Override
    public Storage getStorage() { return storage; }
    @Override
    public IMotor getMotor() { return engine; }
}
