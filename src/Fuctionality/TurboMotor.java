package Fuctionality;

import LableInterfaces.IHasTurbo;

public class TurboMotor extends NormalMotor implements IHasTurbo {
    private boolean turboOn=false;
    public TurboMotor(double power) {
        super(power);
    }

    @Override
    public double SpeedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return power * 0.01 * turbo;
    }

    @Override
    public void setTurbo(boolean turbo) { turboOn=turbo; }

    @Override
    public boolean getTurbo() { return turboOn; }


}
