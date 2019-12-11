package Fuctionality.Motors;

import Fuctionality.MoveHandlers.MoveHandler;
import WorldObjects.LableInterfaces.IHasTurbo;

public class TurboMotor extends NormalMotor{
    private boolean turboOn=false;
    public TurboMotor(double power, MoveHandler moveHandler) {
        super(power,moveHandler);
    }

    @Override
    public double SpeedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return power * 0.01 * turbo;
    }

    public void setTurbo(boolean turbo) { turboOn=turbo; }

}
