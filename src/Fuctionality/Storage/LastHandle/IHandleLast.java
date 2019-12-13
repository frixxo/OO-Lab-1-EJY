package Fuctionality.Storage.LastHandle;

import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;
import WorldObjects.Objects.Vehicle;

import java.awt.*;

/** Describes the methods an unit that is supposed to handle cargo is supposed to have*/
public interface IHandleLast<objectType extends WorldObjectH, object extends IsWorldObject> {
    boolean load(object cargo, Point position) throws IllegalArgumentException;
    object release() throws IllegalArgumentException;
    int getCargoCount();
    void updatePosition(Point position);
    void setLoadState(boolean loadState);
}
