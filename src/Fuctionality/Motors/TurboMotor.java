package Fuctionality.Motors;

import Fuctionality.MoveHandler;
import WorldObjects.LableInterfaces.IHasTurbo;

public class TurboMotor extends NormalMotor implements IHasTurbo {
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

    @Override
    public void setTurbo(boolean turbo) { turboOn=turbo; }

}
