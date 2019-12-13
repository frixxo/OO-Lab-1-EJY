package Graphics;

import Systems.CarSimulator;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.util.List;

public class SpeedLabel extends JLabel {
    private List<WorldObjectView> vehicles;

    public SpeedLabel(CarSimulator cs){
        super();

        this.vehicles = cs.getVehicles();
        initText();
    }

    private void initText(){
        StringBuilder sb = new StringBuilder();
        for (WorldObjectView vehicle : vehicles){
            if (vehicle instanceof Drivable) {
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        this.setText(sb.append("awpafagfafAWFawfaeegaeegTEST").toString());
    }

}
