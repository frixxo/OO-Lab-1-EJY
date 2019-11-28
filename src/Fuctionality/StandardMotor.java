package Fuctionality;

public class StandardMotor extends NormalMotor{

    @Override
    public double SpeedFactor() {
        return power*0.01;
    }
}
