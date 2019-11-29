package Flak;

import LastHandle.IHandleLast;
import LastHandle.LoadHandler;
import WorldObjects.WorldObject;

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
