package Fuctionality.Storage.RegisterdStorages;

import WorldObjects.InterfaceHierarchy.WorldObjectH;
import WorldObjects.LableInterfaces.IsWorldObject;

public interface RegisterStorage <objectType extends WorldObjectH, object extends IsWorldObject, key extends Object>{
    boolean add(IsWorldObject worldObject) throws IllegalArgumentException;
    IsWorldObject release(Object obj) throws IllegalArgumentException;
    int getCurrentStorageAmmount();
    int getMaxAmmaount();
}
