package Fuctionality;

import LableInterfaces.IHasMotor;

import java.awt.*;
import java.awt.geom.Point2D;

public class MotorHandler implements IHasMotor {
    IMotor motor;

    public void setMotor(IMotor motor){
        this.motor=motor;
    }

    @Override
    public double getEnginePower(){ return motor.getPower(); }

    @Override
    public double getCurrentSpeed(){
        return motor.getCurrentSpeed();
    }

    @Override
    public IMotor getMotor() { return motor; }

    @Override
    public void startEngine() { motor.startEngine(); }

    @Override
    public void stopEngine() { motor.stopEngine(); }

    @Override
    public void gas(double amount) { motor.gas(amount); }

    @Override
    public void brake(double amount) { motor.brake(amount); }

    @Override
    public void move(Point position,Point2D direction,boolean IsLoaded) { motor.move(position,direction,IsLoaded); }
}
