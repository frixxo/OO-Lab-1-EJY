package WorldObjects.Objects;

import Fuctionality.IDGenerator.IDGenerator;
import Fuctionality.IDGenerator.RegNrGenerator;
import Fuctionality.Motors.IMotor;
import Fuctionality.Motors.TrimmedMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.MoveHandlers.VehicleDriver;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.RotationHandler.VehicleSteerer;
import WorldObjects.InterfaceHierarchy.Car;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public class Volvo240 extends Drivable implements Car {
    private RotationHandler steerer;
    private MoveHandler driver;
    private IMotor motor;
    private String modelName="Volvo240";
    private String RegNr;


    //region Constructor
    public Volvo240(String modelName, Point position, Point2D direction, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr) {
        super(position, direction, new Point(70,50), false);
        this.modelName = modelName;
        this.steerer = steerer;
        this.driver = driver;
        this.motor = motor;
        this.RegNr = RegNr;
    }

    public Volvo240(String modelName ,RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr)
    {
        this(modelName, new Point(0,0),new Point(1,0), steerer, driver, motor, RegNr);
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
    public RotationHandler getRotationHandler() { return steerer; }

    @Override
    public MoveHandler getMoveHandler() { return driver; }
}
