package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.Containers.IFlak;
import Fuctionality.Storage.LastHandle.IHandleLast;
import WorldObjects.IsWorldObject;

import java.awt.*;

public class FlakStorage implements Storage{

    IFlak flak;
    IHandleLast lasthandler;

    public FlakStorage (IFlak flak, IHandleLast lasthandler)
    {
        this.flak = flak;
        this.lasthandler = lasthandler;
    }


    @Override
    public boolean load(IsWorldObject cargo) {
        return lasthandler.load(cargo,flak.loadState());
    }

    @Override
    public IsWorldObject release() {
        return null;
    }

    @Override
    public int getCargoCount() {
        return 0;
    }

    @Override
    public void updatePosition(Point position) {

    }

    @Override
    public void openContainer() {

    }

    @Override
    public void closeContainer() {

    }
}
