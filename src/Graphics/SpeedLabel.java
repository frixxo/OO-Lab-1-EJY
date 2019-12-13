package Graphics;

import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.util.List;

public class SpeedLabel extends JLabel {
    private List<Drivable> vehicles;

    public SpeedLabel(List<Drivable> vehicles){
        super();

        this.vehicles = vehicles;
        initText();
    }

    private void initText(){
        StringBuilder sb = new StringBuilder();
        for (Drivable vehicle : vehicles){
            sb.append(vehicle.getType()).append(": ").append(vehicle.getCurrentSpeed()).append("; ");
        }
        this.setText(sb.toString());
    }

}
