package WorldObjects.Objects;
import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.Containers.Ramp;
import Fuctionality.Storage.StandardStorage;
import Fuctionality.Storage.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import Fuctionality.Storage.LastHandle.*;
import WorldObjects.InterfaceHierarchy.LandVehicle;
import WorldObjects.InterfaceHierarchy.Vehicle;

import java.awt.*;
import java.awt.geom.Point2D;

/** A ferry that transports cars over a body of water*/
public class CarFerry extends Drivable implements IHasStorage, IHasMotor, Vehicle {

    private String modelname = "CarFerry";
    private RotationHandler steerer = new VehicleSteerer();
    private MoveHandler driver = new VehicleDriver();
    private IMotor engine = new StandardMotor(10, driver);
    private Storage storage = new StandardStorage<LandVehicle>(new Ramp(), new LoadHandler( 20, 2, 10, 10, LoadHandler.Principle.FIFO));
    private String RegNr;
    private IDGenerator reg=new RegNrGenerator();

    public CarFerry() {
    this(new Point(0,0),new Point(1,0));}
    public CarFerry(Point position, Point2D direction){
        super(position,direction,new Point(140,100),false);
        RegNr=reg.generate();
    }

    @Override
    public String getModelName() {
        return modelname;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public IMotor getMotor() {
        return engine;
    }

    @Override
    public Storage getStorage() {
        storage.setCanChangeState(!driver.isMoving());
        return storage;
    }


    @Override
    public RotationHandler getRotationHandler() { return steerer; }

    @Override
    public MoveHandler getMoveHandler() { return driver; }

    @Override
    public boolean getLoaded()
    {
        return storage.normalState();
    }
}
