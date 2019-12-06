package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.InterfaceHierarchy.IsWorldObject;

import java.awt.*;

public class StandardStorage <T extends IsWorldObject> implements Storage<T>{
    private Container container;
    private IHandleLast lasthandler;
    private boolean canChangeState =true;

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
        if(canChangeState) {container.openContainer();}
    }
    public void closeContainer(){ container.closeContainer(); }

    public boolean normalState(){ return container.normalState();}

    @Override
    public void setCanChangeState(boolean canChangeState) {
        this.canChangeState = canChangeState;
    }
}
