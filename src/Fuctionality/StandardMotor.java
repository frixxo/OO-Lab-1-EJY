package Fuctionality;

public class StandardMotor extends NormalMotor{

    public StandardMotor(double power) {
        super(power);
    }

    @Override
    public double SpeedFactor() {
        return power*0.01;
    }
}
