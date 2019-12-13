package Systems;

import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.Drivable;

/** sends the instructions to the cars*/
public class CarController {

    CarSimulator sim;

    public CarController(CarSimulator sim){
        this.sim = sim;
    }

    public void startEngline() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().startEngine();
            }
        }
    }

    public void stopEngline() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().stopEngine();
            }

        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasMotor){
                ((IHasMotor) vehicle).getMotor().gas(gas);
            }
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().brake(brake);
            }
        }
    }

    public void raiseFlak() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasStorage) {
                ((IHasStorage) vehicle).getStorage().getContainer().closeContainer();
            }
        }
    }

    public void lowerFlak() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof IHasStorage) {
                ((IHasStorage) vehicle).getStorage().getContainer().openContainer();
            }
        }
    }

    public void turnLeft() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).turnLeft();
            }
        }
    }

    public void turnRight() {
        for (WorldObjectView vehicle : sim.getVehicles()) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).turnRight();
            }
        }
    }
}
