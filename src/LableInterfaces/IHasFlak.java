package LableInterfaces;

import Flak.IFlak;

/** has the fuctionality a vehicle that has a flak needs to have
 * */
public interface IHasFlak {
    boolean raiseFlak();
    boolean lowerFlak();
    IFlak getFlak();
}
