public class CarFerry extends Vehicle{
    private LoadHandler load;

    public CarFerry(){
        load = new LoadMovable(this, 5000, 40, 20, 10, LoadHandler.Principle.FILO);
    }

    public boolean lowerRamp(){
        if(!isMoving()) {
            load.setDock(true);
            return true;
        } return false;
    }
    public void raiseRamp(){ load.setDock(false); }
    public boolean load(Car car) { return load.load(car); }
    public Car release() { return (Car)load.release(); }
    public int getCarLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }
    @Override
    public void move(){
        if (!load.dockStatus()) super.move();
    }
}
