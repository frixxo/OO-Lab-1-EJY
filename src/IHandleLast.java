/** Describes the methods an unit that is supposed to hadle cargo is supposed to have*/
public interface IHandleLast<T> {
    boolean load(T cargo);
    T release();
    int getCargoCount();
}
