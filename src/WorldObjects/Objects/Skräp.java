package WorldObjects.Objects;

import Fuctionality.Colliders.StandardCollider;
import WorldObjects.InterfaceHierarchy.ObjectH;

import java.awt.*;
import java.awt.geom.Point2D;

/** this class represents all the trash that can be loaded onto a truck,*/
public class Skräp extends WorldObject{
    protected Skräp(Point position, Point2D direction, Point size, boolean isStatic) {
        super(position, direction, size, new ObjectH() {}, isStatic, new StandardCollider(true), "Skräp");
    }
}
