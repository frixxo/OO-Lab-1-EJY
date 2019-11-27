package Flak;
/** A ramp for loading vehicles m.m*/
public class Ramp extends NormalFlak{
    @Override
    public boolean normalState() {
        return getAngle() == getMAX_ANGLE();
    }

    @Override
    public boolean loadState() {
        return getAngle() == 0;
    }

    public Ramp()
    {
        tippingAmount = getMAX_ANGLE();         //makes sure that the ramp is either up or down.
        angle=getMAX_ANGLE();                   //Sets the ramp in the up position
    }
}
