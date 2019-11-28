package Fuctionality;

public abstract class NormalMotor implements IMotor{
    protected double power;
    private int frameCounter=0;
    private DriveHandler driveHandler;

    public NormalMotor(double power,DriveHandler driveHandler){
        this.power=power;
        this.driveHandler=driveHandler;
    }
    public abstract double SpeedFactor();


    public double getPower() { return power; }


    /** increase speed set amount
     * @param amount how much to decrease
     * */
    public void incrementSpeed(double amount){  Math.min(driveHandler.getCurrentSpeed() + SpeedFactor() * amount,power); }

    /** decrease speed set amount
     * @param amount how much to decrease
     * */
    public void decrementSpeed(double amount){   Math.max(driveHandler.getCurrentSpeed() - SpeedFactor() * amount,0);}

    /** apply gas
     * @param amount how much to gas
     * */
    public void gas(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        incrementSpeed(amount);
    }

    /** apply brake
     * @param amount how much to brake
     */
    public void brake(double amount){
        amount=(amount>1)? 1:(amount<0)?0:amount;   //sätter alla tal större än 1 till 1 och mindre än 0 till 0.
        decrementSpeed(amount);
    }

    /** checks if the vehicle is moving
     * @return if the vehicle is moving
     * */

}
