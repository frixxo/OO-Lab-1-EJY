package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.IsWorldObject;

import java.awt.*;

public class StandardStorage implements Storage{
    Container container;
    IHandleLast lasthandler;

    public StandardStorage(Container container, IHandleLast lasthandler)
    {
        this.container = container;
        this.lasthandler = lasthandler;
    }

    public boolean load(IsWorldObject cargo){
        return lasthandler.load(cargo,container.loadState());
    }
    public IsWorldObject release(){                 //Todo generic type?
        return lasthandler.release();
    }
    public int getCargoCount(){
        return lasthandler.getCargoCount();
    }
    public void updatePosition(Point position){
        lasthandler.updatePosition(position);
    }
    public void openContainer(){
        container.openContainer();
    }
    public void closeContainer(){
        container.closeContainer();
    }
}
