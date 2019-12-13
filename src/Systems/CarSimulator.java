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

/** */
public class CarSimulator {
    private List<WorldObjectView> vehicles = new ArrayList<>();
    private Point worldSize;
    private int MAX_COUNT;

    public CarSimulator(Point worldSize, int MAX_COUNT) {
        this.MAX_COUNT = MAX_COUNT;
        this.worldSize = worldSize;
        tempInit();

        Timer timer = new Timer(50, e -> update());
        timer.start();
    }

    public void update() {
        for (WorldObjectView vehicle : vehicles) {
            if(vehicle instanceof Drivable) {
                ((Drivable)vehicle).move();
            }
            vehicle.UpdateCollider(worldSize);
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

    public List<WorldObjectView> getVehicles(){return vehicles;}
}
