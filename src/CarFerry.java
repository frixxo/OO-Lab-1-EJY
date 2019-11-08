public class CarFerry extends Vehicle{
    private LoadHandler load;

    public CarFerry(){
        load = new LoadHandler(this, 1000, 50, LoadHandler.Principle.FIFO);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
