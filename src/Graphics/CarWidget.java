package Graphics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

public class CarWidget extends JFrame{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    CarApplication carC;

    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turnLeftButton = new JButton("Turn Left");
    JButton turnRightButton = new JButton("Turn Right");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton TurboOn = new JButton("Turbo On");
    JButton TurboOff = new JButton("Turbo Off");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarWidget(String framename){
        initComponents(framename);
    }

   // public <T>Point getSize(T obj){ return drawPanel.getSize(obj); }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        //Gas amount input
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        //original buttons

        controlPanel.add(gasButton, 0);
        controlPanel.add(TurboOn, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(TurboOff, 4);
        controlPanel.add(lowerBedButton, 5);

        /*
        controlPanel.add(gasButton, 0);
        controlPanel.add(turnLeftButton, 1);
        controlPanel.add(turnRightButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(liftBedButton, 4);
        controlPanel.add(lowerBedButton, 5);

        */
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);

       //region button functionality
        startButton.addActionListener(e -> carC.startEngline());
        stopButton.addActionListener(e -> carC.stopEngline());
        gasButton.addActionListener(e -> carC.gas(gasAmount));
        brakeButton.addActionListener(e -> carC.brake(gasAmount));
        liftBedButton.addActionListener(e -> carC.raiseFlak());
        lowerBedButton.addActionListener(e -> carC.lowerFlak());
        turnLeftButton.addActionListener(e -> carC.turnLeft());
        turnRightButton.addActionListener(e -> carC.turnRight());
        //endregion

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
    public Point windowSize(){
        return new Point(X,Y-240);
    }

}