package Fuctionality.Storage.RegisterdStorages;

import WorldObjects.InterfaceHierarchy.VehicleH;
import WorldObjects.LableInterfaces.IsWorldObject;
import WorldObjects.Objects.Vehicle;

import java.util.HashMap;
//Bry er inte om det här tack. det är ett experiment som inte hör till projectet.
public class RegnumberStorage<objectType extends VehicleH, object extends Vehicle, key extends String> implements RegisterStorage <objectType, object, key>{
    private HashMap<String, Vehicle> storing = new HashMap<String, Vehicle>();
    private int maxCargoCount;
    @Override
    public boolean add(Object vehicle) throws IllegalArgumentException
    {


        if (storing.size() < maxCargoCount
                &&!vehicle.getLocked()
        ) {

            vehicle.setLocked(true);
            storing.put(vehicle.);
            return true;
        } return false;
    }
}
