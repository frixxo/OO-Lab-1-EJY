package Fuctionality.Storage.Containers;

public interface Container {

    /** the normal state of the flak, and when it is supposed to be able to move
     * @return if in normalstate*/
    boolean normalState();
    /** Defines when the flak is supposed to be able to move
     * @return if in normalstate*/
    boolean loadState();

    void openContainer();
    void closeContainer();

    void setCanChangeState(boolean canChangeState);
}
