package WorldObjects; /** A scania truck*/
import Flak.Flak;
import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandler;
import Fuctionality.Motors.NormalMotor;
import Fuctionality.Motors.StandardMotor;
import Fuctionality.RotationHandler;
import Fuctionality.VehicleDriver;
import Fuctionality.VehicleSteerer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Scania extends WorldObject implements Movable, Vehicle, Truk {
    private final static String model = "Scania";
    private MoveHandler driver = new VehicleDriver(this);
    private RotationHandler steerer = new VehicleSteerer(this);
    private StandardMotor engine = new StandardMotor(20, driver);




    public Scania(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position,direction, size, isStatic);
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
}
