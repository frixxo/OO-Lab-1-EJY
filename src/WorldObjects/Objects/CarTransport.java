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
import Fuctionality.Storage.LastHandle.LoadHandler;
import WorldObjects.InterfaceHierarchy.Car;
import WorldObjects.InterfaceHierarchy.Truk;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/

public class CarTransport extends Drivable implements Truk {

    private final static String model = "CarTransport";
    private MoveHandler driver = new VehicleDriver();
    private RotationHandler steerer = new VehicleSteerer();
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new StandardStorage<Car>(new Ramp(), new LoadHandler(10, 2,3, 3, LoadHandler.Principle.FILO));
    private String RegNr;
    private IDGenerator reg=new RegNrGenerator();

    public CarTransport() {
        this(new Point(0,0),new Point(1,0));
    }
    public CarTransport(Point position, Point2D direction){
        super(position,direction,new Point(70,50),false);
        RegNr=reg.generate();
    }

    @Override
    public String getModelName() {
        return model;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }


    @Override
    public Storage getStorage() { return storage; }

    @Override
    public IMotor getMotor() { return engine; }

    @Override
    public RotationHandler getRotationHandler() { return steerer; }

    @Override
    public MoveHandler getMoveHandler() { return driver; }

    @Override
    public boolean getStatic()
    {
        return storage.normalState();
    }
}
