package Fuctionality.Storage;

import Fuctionality.Storage.LastHandle.IHandleLast;
import Fuctionality.Storage.Containers.Container;
import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;

import java.awt.*;

public interface Storage <objectType extends WorldObjectH, object> {
    void updatePosition(Point position);
    void setCanChangeState(boolean canChangeState);
    IHandleLast getLastHandler();
    Container getContainer();
}
