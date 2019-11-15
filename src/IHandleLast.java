/** Describes the methods an unit that is supposed to hadle cargo is supposed to have*/
public interface IHandleLast {
    boolean load(Car car) throws Exception;
    Car release() throws Exception;
    int getCarsLoaded();
}
