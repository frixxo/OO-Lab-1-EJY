package Fuctionality.Storage;

import WorldObjects.InterfaceHierarchy.IsWorldObject;

import java.awt.*;

public interface Storage <T extends IsWorldObject>{
    boolean load(T cargo,Point LoaderPosition);
    T release();
    int getCargoCount();
    void updatePosition(Point position);
    void openContainer();
    void closeContainer();
}
