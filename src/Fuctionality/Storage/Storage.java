package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.IsWorldObject;

import java.awt.*;

public interface Storage <T extends IsWorldObject>{
    boolean load(T cargo);
    T release();
    int getCargoCount();
    void updatePosition(Point position);
    void openContainer();
    void closeContainer();
}
