package Flak;

import LastHandle.IHandleLast;
import WorldObjects.WorldObject;

public interface Storage {
    IHandleLast getLastHandler();
    Container getContainer();
}
