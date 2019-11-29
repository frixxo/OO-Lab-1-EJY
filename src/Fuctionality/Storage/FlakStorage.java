package Flak;

import LastHandle.IHandleLast;

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
