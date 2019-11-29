package Flak;

/** all methods a flak has to have*/
public interface IFlak extends Container{
    boolean lowerRamp();
    boolean raiseRamp();

    double getAngle();
    double getMAX_ANGLE();
}
