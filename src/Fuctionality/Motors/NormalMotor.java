package Fuctionality.Motors;

import Fuctionality.MoveHandlers.MoveHandler;

public abstract class NormalMotor implements IMotor {
    protected double power;
    private boolean isEngineOn = false;
    private int frameCounter = 0;
    private MoveHandler moveHandler;

    public NormalMotor(double power, MoveHandler moveHandler) {
        this.power = power;
        this.moveHandler = moveHandler;
    }

    public abstract double SpeedFactor();


    public double getPower() {
        return power;
    }

    @Override
    public void startEngine() { isEngineOn = true; }
    @Override
    public void stopEngine() {
        isEngineOn = false;
    moveHandler.setCurrentSpeed(0);}


    /**
     * increase speed set amount
     * @param amount how much to decrease
     */
    private void incrementSpeed(double amount) {
        moveHandler.setCurrentSpeed(Math.min(moveHandler.getCurrentSpeed() + SpeedFactor() * amount, power));
    }

    /**
     * decrease speed set amount
     * @param amount how much to decrease
     */
    private void decrementSpeed(double amount) {
        moveHandler.setCurrentSpeed(Math.max(moveHandler.getCurrentSpeed() - SpeedFactor() * amount, 0));
    }

    /**
     * apply gas
     * @param amount how much to gas
     */
    public void gas(double amount) {
        if (isEngineOn) {
            amount = (amount > 1) ? 1 : (amount < 0) ? 0 : amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
            incrementSpeed(amount);
        }
    }

    /**
     * apply brake
     * @param amount how much to brake
     */
    public void brake(double amount) {
        amount = (amount > 1) ? 1 : (amount < 0) ? 0 : amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        decrementSpeed(amount);
    }

}
