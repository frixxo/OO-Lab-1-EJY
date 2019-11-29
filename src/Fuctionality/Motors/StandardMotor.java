package Fuctionality.Motors;

public class StandardMotor extends NormalMotor {

    public StandardMotor(double power) {
        super(power);
    }

    @Override
    public double SpeedFactor() {
        return getPower()*0.01;
    }
}
