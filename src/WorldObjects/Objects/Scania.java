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
    private MoveHandler driver = new VehicleDriver(this);
    private RotationHandler steerer = new VehicleSteerer(this);
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new FlakStorage(new Flak(), new LoadHandler <>(this,10, 2,3, 3, LoadHandler.Principle.FILO));
    private IDGenerator reg=new RegNrGenerator();
    private String modelname = "Scania";
    private String RegNr;


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
    public String getModelName() { return modelname; }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public Storage getStorage(){return storage; }
}
