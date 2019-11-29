package WorldObjects; /** A scania truck*/
import Flak.Flak;
import Flak.FlakStorage;
import Flak.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.VehicleDriver;
import Fuctionality.VehicleSteerer;
import LastHandle.LoadHandler;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends WorldObject implements Movable, Vehicle, Truk {
    private final static String model = "Scania";
    private MoveHandler driver = new VehicleDriver(this);
    private RotationHandler steerer = new VehicleSteerer(this);
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Flak(), new LoadHandler <>(this,10, 2,3, 3, LoadHandler.Principle.FILO));

    public Scania(Point position, Point2D direction, Point size) {
        super(position,direction, size, false);
    }
    public Scania() {
        this(new Point(0,0),new Point(1,0), null);
    }

    @Override
    public MoveHandler getDriveHandler(){ return driver; }

    @Override
    public RotationHandler getSteerHandler (){return steerer; }

    @Override
    public IMotor getMotor(){ return engine; }

    @Override
    public String getModelName() { return model; }

    @Override
    public String getRegNr() {
        return null;
    }

    @Override
    public Storage getStorage(){return storage; }
}
