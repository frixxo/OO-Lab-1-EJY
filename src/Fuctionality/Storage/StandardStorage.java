package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.InterfaceHierarchy.IsWorldObject;

import java.awt.*;

public class StandardStorage <T extends IsWorldObject> implements Storage<T>{
    Container container;
    IHandleLast lasthandler;

    public StandardStorage(Container container, IHandleLast<T> lasthandler )
    {
        this.container = container;
        this.lasthandler = lasthandler;
    }

    public boolean load(T cargo,Point position){
        return lasthandler.load(cargo,container.loadState(),position);
    }
    public T release(){
        return (T)lasthandler.release();
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
    public void closeContainer(){ container.closeContainer(); }
}
