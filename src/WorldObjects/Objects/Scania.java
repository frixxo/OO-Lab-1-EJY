package WorldObjects.Objects; /** A scania truck*/

import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import Fuctionality.Storage.Containers.Flak;
import Fuctionality.Storage.StandardStorage;
import Fuctionality.Storage.Storage;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.Storage.LastHandle.LoadHandler;
import WorldObjects.InterfaceHierarchy.Truk;

import java.awt.*;
import java.awt.geom.Point2D;

public class Scania extends Drivable implements Truk {
    private MoveHandler driver = new VehicleDriver();
    private RotationHandler steerer = new VehicleSteerer();
    private StandardMotor engine = new StandardMotor(20, driver);
    private Storage storage = new StandardStorage(new Flak(), new LoadHandler <Skräp>(10, 2,3, 3, LoadHandler.Principle.FILO));
    private IDGenerator reg=new RegNrGenerator();
    private String modelname = "Scania";
    private String RegNr;


    public Scania(Point position, Point2D direction) {
        super(position,direction, new Point(70,50), false);
    }
    public Scania() {
        this(new Point(0,0),new Point(1,0));
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
    public Storage getStorage(){
        storage.setCanChangeState(!driver.isMoving());
        return storage;}

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
