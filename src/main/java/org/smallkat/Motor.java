package org.smallkat;

public class Motor {



    double kP = 0;
    double kI = 0;
    double kD = 0;


    public Motor(){

    }

    public void setPosition(double pos){

    }

    public void setVelocity(double vel){

    }

    public void setTorque(double torque){

    }

    public double getkP() {
        return kP;
    }

    public void setkP(double kP) {
        this.kP = kP;
    }

    public double getkI() {
        return kI;
    }

    public void setkI(double kI) {
        this.kI = kI;
    }

    public double getkD() {
        return kD;
    }

    public void setkD(double kD) {
        this.kD = kD;
    }
}
