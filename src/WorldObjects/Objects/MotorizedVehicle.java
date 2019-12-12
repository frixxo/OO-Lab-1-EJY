package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.LableInterfaces.IHasMotor;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Represents a Volvo 240 raggarbil
 */
public abstract class MotorizedVehicle extends Vehicle implements IHasMotor {
    protected IMotor motor;

    //region Constructor
    protected MotorizedVehicle(String modelName, Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr) {
        super(modelName, position, direction, size,false, steerer, driver, RegNr);
        this.motor = motor;
    }
    //endregion

    public IMotor getMotor() {
        return motor;
    }
}


