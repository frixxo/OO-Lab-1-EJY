package WorldObjects.Objects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;

import java.awt.*;
import java.awt.geom.Point2D;

abstract class Vehicle extends Drivable {
    private String ID;

    protected Vehicle ( Point position, Point2D direction, Point size, boolean isStatic, RotationHandler rotationHandler, MoveHandler moveHandler, String id,String type)
    {
        super(position, direction, size, isStatic, rotationHandler, moveHandler, type);
        this.ID = id;
    }

    public String getID() {
        return ID;
    }
}
