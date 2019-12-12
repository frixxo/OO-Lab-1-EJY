package WorldObjects.Objects;

import Fuctionality.Motors.IMotor;
import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import Fuctionality.Storage.Storage;
import WorldObjects.InterfaceHierarchy.LandVehicle;

import java.awt.*;
import java.awt.geom.Point2D;

public class Truck extends MotorizedTransportVehicle implements LandVehicle {
    public Truck(Point position, Point2D direction, Point size, RotationHandler steerer, MoveHandler driver, IMotor motor, String RegNr, Storage storage,String type) {
        super(position, direction, size, steerer, driver, motor, RegNr, storage,type);
    }
}