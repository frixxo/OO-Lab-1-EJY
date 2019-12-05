package WorldObjects.Objects;
import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.FlakStorage;
import Fuctionality.Storage.Containers.Ramp;
import Fuctionality.Storage.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.Storage.LastHandle.LoadHandler;
import WorldObjects.Car;
import WorldObjects.Truk;

import java.awt.*;
import java.awt.geom.Point2D;

/** A car transporting truck for delivering cars*/

public class CarTransport extends Drivable implements Truk {
    // TODO HELP
    private final static String model = "CarTransport";
    private MoveHandler driver = new VehicleDriver();
    private RotationHandler steerer = new VehicleSteerer();
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Ramp(), new LoadHandler<Car>(this,10, 2,3, 3, LoadHandler.Principle.FILO));
    private String RegNr;
    private IDGenerator reg=new RegNrGenerator();
    private int turnAngle=90;



    public CarTransport() {
        super(new Point(0,0),new Point(1,0), null, false);
    }
    public CarTransport(Point position, Point2D direction, Point Size){
        super(position,direction,Size,false);
        storage = new FlakStorage(new Ramp(),new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO));
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
    public RotationHandler getSteerer() { return steerer; }

    @Override
    public MoveHandler getDriver() { return driver; }
}
