package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.InterfaceHierarchy.LandVehicle;

import java.awt.*;
import java.awt.geom.Point2D;

public class Car extends MotorizedVehicle implements LandVehicle {
    public Car(String modelName, Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr) {
        super(modelName, position, direction, size, steerer, driver, motor, RegNr);
    }
}
