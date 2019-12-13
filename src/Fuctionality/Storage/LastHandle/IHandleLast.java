package Fuctionality.Storage.LastHandle;

import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;

import java.awt.*;

/** Describes the methods an unit that is supposed to handle cargo is supposed to have*/
public interface IHandleLast<T extends WorldObjectH> {
    boolean load(IsWorldObject cargo, Point position) throws IllegalArgumentException;
    IsWorldObject release();
    int getCargoCount();
    void updatePosition(Point position);
    void setLoadState(boolean loadState);
}
