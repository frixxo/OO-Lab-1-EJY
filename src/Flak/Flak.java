package Flak;
/** A normal flak that is raisable and has an open top so is always loadable*/
public class Flak extends NormalFlak {
    @Override
    public boolean normalState() {
        return getAngle() == 0;
    }

    @Override
    public boolean loadState() {
        return true;
    }

    @Override
    public void openContainer (){raiseRamp();}

    @Override
    public void closeContainer (){lowerRamp();}
}
