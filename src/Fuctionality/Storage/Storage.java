package Fuctionality.Storage;

import Fuctionality.Storage.Containers.Container;
import Fuctionality.Storage.LastHandle.IHandleLast;

public interface Storage {
    IHandleLast getLastHandler();
    Container getContainer();
}
