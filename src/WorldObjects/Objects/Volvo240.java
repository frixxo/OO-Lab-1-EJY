package WorldObjects.Objects;

import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TrimmedMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import WorldObjects.Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends Drivable implements Car {
    private RotationHandler steerer= new VehicleSteerer();
    private MoveHandler driver= new VehicleDriver();
    private IMotor motor = new TrimmedMotor(100,1.25,driver);
    private IDGenerator reg=new RegNrGenerator();
    private String modelName="Volvo240";
    private String RegNr;
    private int turnAngle =90;


    //region Constructor
    public Volvo240(Point position, Point2D direction, Point size)
    {
        super(position, direction, size, false);
        RegNr=reg.generate();
    }
    public Volvo240()
    {
        this(new Point(0,0),new Point(1,0),null);
    }
    //endregion

    @Override
    public IMotor getMotor() {
        return motor;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getRegNr() {
        return RegNr;
    }

    @Override
    public RotationHandler getSteerer() { return steerer; }

    @Override
    public MoveHandler getDriver() { return driver; }
}
