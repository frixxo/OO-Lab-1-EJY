package Fuctionality.Storage.LastHandle;

import WorldObjects.InterfaceHierarchy.IsWorldObject;

import java.awt.*;

/** Describes the methods an unit that is supposed to handle cargo is supposed to have*/
public interface IHandleLast<T extends IsWorldObject> {
    boolean load(T cargo, Point position);
    T release();
    int getCargoCount();
    void updatePosition(Point position);
    void setLoadState(boolean loadState);
}
