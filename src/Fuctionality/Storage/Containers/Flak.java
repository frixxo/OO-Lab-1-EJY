package Fuctionality.Storage.Containers;
/** A normal flak that is raisable and has an open top so is always loadable*/
public class Flak extends NormalFlak {
    @Override
    public boolean normalState() {
        return getAngle() == 0;
    }

    @Override
    public boolean loadState() { return getAngle() > 0; }

    @Override
    public void openContainer (){if (canChangeState)raiseRamp();}

    @Override
    public void closeContainer (){if (canChangeState)lowerRamp();}
}
