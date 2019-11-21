package Flak;

public interface IFlak {
    boolean lowerRamp();
    boolean raiseRamp();

    /** the normal state of the flak, and when it is supposed to be able to move*/
    boolean normalState();
    /** Defines when the flak is supposed to be able to move*/
    boolean loadState();

    double getAngle();
    double getMAX_ANGLE();
}
