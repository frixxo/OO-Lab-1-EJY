public class CarTransport extends Truck{
    private LoadHandler load;

    public CarTransport(){
        load = new LoadMovable(this, 5, 10, 20, 10, LoadHandler.Principle.FILO);
    }

    public boolean load(Car car) { return load.load(car); }
    public Car release() { return (Car)load.release(); }
    public int getCarLoaded(){ return load.getCargoCount(); }

    @Override
    public double speedFactor() { return enginePower * 0.01; }

}
