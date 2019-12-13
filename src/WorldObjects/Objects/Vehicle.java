package WorldObjects.Objects;

import Fuctionality.MoveHandlers.MoveHandler;
import Fuctionality.RotationHandler.RotationHandler;
import WorldObjects.InterfaceHierarchy.WorldObjectH;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Vehicle extends Drivable {
    private String ID;

    protected Vehicle (Point position, Point2D direction, Point size, WorldObjectH objectType, boolean isStatic, RotationHandler rotationHandler, MoveHandler moveHandler, String id, String type)
    {
        super(position, direction, size, objectType, isStatic, rotationHandler, moveHandler, type);
        this.ID = id;
    }

    public String getID() {
        return ID;
    }
}
