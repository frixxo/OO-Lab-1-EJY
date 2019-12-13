package Graphics;

import Systems.CarController;
import Systems.CarSimulator;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    JPanel world;
    JPanel Buttons;
    JPanel speedLable;

    public Frame(Dimension FrameSize, CarSimulator cs, CarController cc){
        world=new DrawPanel(new Dimension(FrameSize.width,FrameSize.height-240),cs);
        Buttons =new Buttons(cc,new Dimension(FrameSize.width,FrameSize.height-640));
        speedLable = new SpeedLabel(cs,new Dimension(50,10));
        InitializeFrame(FrameSize);
    }

    private void InitializeFrame(Dimension FrameSize){
        this.setTitle("CarSimulator 2000");
        this.setPreferredSize(FrameSize);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(world);
        this.add(Buttons);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

