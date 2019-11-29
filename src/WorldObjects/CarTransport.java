package WorldObjects;
import Fuctionality.MoveHandler;
import Fuctionality.RegNrGenerator;
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
    private LoadHandler<Car> load;
    private MoveHandler driver
    private RegNrGenerator reg= new RegNrGenerator();
    private String RegNr;
    private String ModelName="CarTransport";

    public CarTransport(){
        this();
    }
    public CarTransport(Point position, Point2D direction,Point Size){
        super(position,direction,Size,false);
        load = new LoadHandler<Car>(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);

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
