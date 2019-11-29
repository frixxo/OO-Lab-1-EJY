package Flak;

import LastHandle.IHandleLast;
import WorldObjects.WorldObject;

public interface Storage <T extends WorldObject> {
    IHandleLast getLastHandler();
    Container getContainer();
}
