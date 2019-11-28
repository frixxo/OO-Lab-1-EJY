package LableInterfaces;

import Fuctionality.IMotor;
import WorldObjects.Movables.Movable;

import java.awt.*;

/**
 * Defines what a car needs to do
 */

public abstract class Car implements IHasMotor, Movable {
    protected IMotor engine;
    protected int NrDoors;
    protected Color color;
    protected String modelName;

    void initialize(int doors,Color color,String modelName,IMotor motor){
        this.engine=motor;
        this.NrDoors=doors;
        this.color=color;
        this.modelName=modelName;
    }

    public String getRegNr(){return modelName;}
    public int getNrDoors(){return NrDoors;}
}
