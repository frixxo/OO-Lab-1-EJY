package Graphics;

import Systems.CarController;
import Systems.CarSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame extends JFrame{
    List<JPanel> panels;

    public Frame(List<JPanel> panels,Dimension FrameSize){
      this.panels=panels;
        InitializeFrame(FrameSize);
    }

    private void InitializeFrame(Dimension FrameSize){
        this.setTitle("CarSimulator 2000");
        this.setPreferredSize(FrameSize);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //Adds panels to the JFrame
        for (JPanel panel:panels) {
            this.add(panel);
        }
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

