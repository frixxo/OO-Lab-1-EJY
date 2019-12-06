package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.IsWorldObject;

import java.awt.*;

public interface Storage{
    boolean load(IsWorldObject cargo);
    IsWorldObject release();
    int getCargoCount();
    void updatePosition(Point position);
    void openContainer();
    void closeContainer();
}
