package Graphics;

import Systems.CarSimulator;
import WorldObjects.InterfaceHierarchy.WorldObjectView;
import WorldObjects.Objects.Drivable;
import WorldObjects.Objects.WorldObject;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpeedLabel extends JPanel {
    private CarSimulator cs;
    JLabel lable;

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();
        this.cs=cs;
        initText();
        lable=new JLabel();
        this.setPreferredSize(size);
    }

    private void initText(){
        StringBuilder sb = new StringBuilder();
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        lable.setText(sb.toString());
        this.add(lable);
    }

}
