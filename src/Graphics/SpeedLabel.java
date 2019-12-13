package Graphics;

import Systems.CarSimulator;
import Systems.Observer.Observer;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.util.List;

public class SpeedLabel extends JLabel implements Observer {
    private List<WorldObjectView> vehicles;

    public SpeedLabel(CarSimulator cs){
        super();

        this.vehicles = cs.getVehicles();
        update();
    }

    @Override
    public void update(){
        StringBuilder sb = new StringBuilder();
        for (WorldObjectView vehicle : vehicles){
            if (vehicle instanceof Drivable) {
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        this.setText(sb.append("awpafagfafAWFawfaeegaeegTEST").toString());
    }

}
