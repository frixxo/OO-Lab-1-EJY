package Flak;

public class Flak1 extends NormalFlak {
    @Override
    public boolean normalState() {
        return getAngle() == 0;
    }

    @Override
    public boolean loadState() {
        return true;
    }
}
