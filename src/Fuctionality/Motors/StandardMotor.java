package Fuctionality.Motors;

import Fuctionality.MoveHandlers.MoveHandler;

public class StandardMotor extends NormalMotor {

    public StandardMotor(double power, MoveHandler moveHandler) {
        super(power,moveHandler);
    }

    @Override
    public double SpeedFactor() {
        return getPower()*0.01;
    }
}
