package LastHandle;

import WorldObjects.Movable;
import WorldObjects.WorldObject;

import java.awt.*;

/** Describes the methods an unit that is supposed to handle cargo is supposed to have*/
public interface IHandleLast<T extends WorldObject> {
    boolean load(T cargo);
    T release();
    int getCargoCount();
    void updatePosition(Point position);
}
