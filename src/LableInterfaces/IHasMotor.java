package LableInterfaces;

import Fuctionality.IMotor;

public interface IHasMotor {
     void startEngine();
     void stopEngine();
     void gas();
     void brake();
     void move();
     IMotor getMotor();
    }

