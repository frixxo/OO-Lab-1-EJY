package Fuctionality;

public class TrimmedMotor extends NormalMotor{
    protected double trimFactor;

    public TrimmedMotor(double power,double trimFactor) {
        super(power);
        this.trimFactor=trimFactor;
    }

    @Override
    public double SpeedFactor() {
        return trimFactor*power*0.01;
    }
}
