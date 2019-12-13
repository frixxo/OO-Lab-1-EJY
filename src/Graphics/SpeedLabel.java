package Graphics;

import Systems.CarSimulator;
import Systems.Observer.Observer;
import WorldObjects.LableInterfaces.WorldObjectView;
import WorldObjects.Objects.Drivable;

import javax.swing.*;
import java.awt.*;

public class SpeedLabel extends JLabel {
    private CarSimulator cs;
    StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();
        this.cs=cs;
        initText();
public class SpeedLabel extends JPanel implements Observer {
    private CarSimulator cs;
    private JLabel label;
    private StringBuilder sb = new StringBuilder();

    public SpeedLabel(CarSimulator cs, Dimension size){
        super();

        this.cs = cs;

        label = new JLabel();
        this.add(label);
        this.setPreferredSize(size);
        cs.addObserver(this);

        update();
    }

    @Override
    public void update() {
        for (WorldObjectView vehicle : cs.getVehicles()){
            if(vehicle instanceof Drivable){
                sb.append(vehicle.getType()).append(": ").append(((Drivable)vehicle).getCurrentSpeed()).append("; ");
            }
        }
        this.setText(sb.toString());
    }
}
