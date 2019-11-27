package Fuctionality;

import LableInterfaces.IHasTurbo;

public class TurboMotor extends NormalMotor implements IHasTurbo,IMotor {
    public TurboMotor(double power) {
        super(power);
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return power * 0.01 * turbo;
    }

    @Override
    public void setTurbo(boolean turbo) {

    }

    @Override
    public boolean getTurbo() {
        return turboOn;
    }
}
