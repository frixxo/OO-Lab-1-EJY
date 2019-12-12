package Systems;

import Systems.Factories.VehicleFactory;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.LableInterfaces.IHasMotor;
import WorldObjects.LableInterfaces.IHasStorage;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarSimulator {
    private List<WorldObjectView> vehicles = new ArrayList<>();
    public final int MAX_COUNT;

    public CarSimulator(int MAX_COUNT) {
        this.MAX_COUNT = MAX_COUNT;
        tempInit();

        Timer timer = new Timer(50, e -> update());
        timer.start();
    }

    public void update() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).move();
            }
            vehicle.UpdateCollider();
        }
    }

    public void tempInit() {
        vehicles.add(VehicleFactory.CreateVolvo240());
        vehicles.add(VehicleFactory.CreateLamborghiniGallardo(
                new Point(0,100),new Point (1,0)));
        vehicles.add(VehicleFactory.CreateScania(
                new Point(0,200),new Point(1,0)));
        vehicles.add(VehicleFactory.CreateCarTransport(
                new Point(350,0),new Point(0,1)));
        vehicles.add(VehicleFactory.CreateSaab95(
                new Point(0,560),new Point(0,-1)));
        vehicles.add(VehicleFactory.CreateCarFerry(
                new Point(200,0),new Point(0,1)));
    }

    public void startEngline() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().startEngine();
            }
        }
    }

    public void stopEngline() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().stopEngine();
            }

        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasMotor){
                ((IHasMotor) vehicle).getMotor().gas(gas);
            }
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasMotor) {
                ((IHasMotor) vehicle).getMotor().brake(brake);
            }
        }
    }

    public void raiseFlak() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasStorage) {
                ((IHasStorage) vehicle).getStorage().getContainer().closeContainer();
            }
        }
    }

    public void lowerFlak() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof IHasStorage) {
                ((IHasStorage) vehicle).getStorage().getContainer().openContainer();
            }
        }
    }

    public void turnLeft() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).turnLeft();
            }
        }
    }

    public void turnRight() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).turnRight();
            }
        }
    }

    public boolean addVehicle(WorldObjectView vehicle) {
        if (vehicles.size() < MAX_COUNT) {
            return vehicles.add(vehicle);
        } return false;
    }

    public void popVehicle() {
        try {
            vehicles.remove(vehicles.size() - 1);
        } catch(IndexOutOfBoundsException ignored) {}
    }
}
