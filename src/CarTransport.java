public class CarTransport extends Truck{
    private LoadHandler load;

    public CarTransport(){
        load = new LoadMovable(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
    }

    public boolean lowerRamp(){
        if(!isMoving()) {
            load.setDock(true);
            return true;
        } return false;
    }
    public void liftRamp(){ load.setDock(false); }
    public void load(Car car) { load.load(car); }
    public Car release() { return (Car)load.release(); }
    public int getCarLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (load.dockStatus()) super.move();
    }

}
