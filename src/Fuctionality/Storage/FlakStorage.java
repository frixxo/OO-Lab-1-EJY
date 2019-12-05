package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.Containers.IFlak;
import Fuctionality.Storage.LastHandle.IHandleLast;

public class FlakStorage implements Storage{

    IFlak flak;
    IHandleLast lasthandler;

    public FlakStorage (IFlak flak, IHandleLast lasthandler)
    {
        this.flak = flak;
        this.lasthandler = lasthandler;
    }

    @Override
    public Container getContainer() {
        return flak;
    }

    @Override
    public IHandleLast getLastHandler() {
        return lasthandler;
    }


}
