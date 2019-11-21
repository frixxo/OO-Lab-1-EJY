package Flak;

public class Flak2 extends NormalFlak{
    @Override
    public boolean normalState() {
        return getAngle() == getMAX_ANGLE();
    }

    @Override
    public boolean loadState() {
        return getAngle() == 0;
    }

    public Flak2 ()
    {
        tippingAmount = getMAX_ANGLE();
    }
}
