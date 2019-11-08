<<<<<<< Updated upstream
=======
<<<<<<< HEAD
>>>>>>> Stashed changes
public class CarFerry extends Vehicle {



    @Override
    public void load(Car car) throws Exception {

    }

    @Override
    public Car release() throws Exception {
        return null;
<<<<<<< Updated upstream
=======
=======
public class CarFerry extends Vehicle{
    private LoadHandler load;

    public CarFerry(){
        load = new LoadHandler(this, 1000, 50, LoadHandler.Principle.FIFO);
    }

    @Override
    public double speedFactor() {
        return 0;
>>>>>>> 1ba7faeb97736a9023c834c953d78114c256179a
>>>>>>> Stashed changes
    }
}
