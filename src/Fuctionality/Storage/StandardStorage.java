package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.LableInterfaces.IsWorldObject;

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

    @Override
    public void updatePosition(Point position){
        lasthandler.updatePosition(position);
    }


    @Override
    public Container getContainer()
    {
        container.setCanChangeState(canChangeState);
        return container;
    }

    @Override
    public IHandleLast getLastHandler() {
        lasthandler.setLoadState(container.loadState());
        return lasthandler;
    }

    @Override
    public void setCanChangeState(boolean canChangeState) {
        this.canChangeState = canChangeState;
    }
}
