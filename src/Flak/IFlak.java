package Flak;

public interface IFlak {
    boolean lowerRamp();
    boolean raiseRamp();
    boolean normalState();
    boolean loadState();

    double getAngle();
    double getMAX_ANGLE();
}
