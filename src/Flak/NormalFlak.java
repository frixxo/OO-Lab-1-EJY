package Flak;

public abstract class NormalFlak implements IFlak {
    protected double angle = 0;  //0 is when the ramp is flat against the truck.
    protected double tippingAmount = 5;
    protected final double MAX_ANGLE = 70;

    public boolean lowerRamp(){
        return increaseTippingAngle(-tippingAmount);
    }
    public boolean raiseRamp(){
        return increaseTippingAngle(tippingAmount);
    }


    /** private method for raising or lowering the tipping angle called on by lower or raise ramp
     * @param amount how much to change the angle
     * @return if successful
     * */

    boolean increaseTippingAngle (double amount){
        angle=(angle+amount > MAX_ANGLE) ? MAX_ANGLE : (angle+amount < 0) ? 0 : angle+amount;
        return true;
    }


    public double getMAX_ANGLE() {
        return MAX_ANGLE;
    }

   /* public void setTippingAmount(double tippingAmount) {
        this.tippingAmount = tippingAmount;
    }
*/
    public double getAngle() {
        return angle;
    }
}
