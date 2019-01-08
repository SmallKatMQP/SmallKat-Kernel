package org.smallkat.customtypes;

import us.ihmc.yoVariables.variable.YoDouble;

public class JointValues {
    private YoDouble angle;
    private YoDouble velocity;
    private YoDouble torque;

    public JointValues(){

    }

    public YoDouble getAngle() {
        return angle;
    }

    public void setAngle(YoDouble angle) {
        this.angle = angle;
    }

    public YoDouble getVelocity() {
        return velocity;
    }

    public void setVelocity(YoDouble velocity) {
        this.velocity = velocity;
    }

    public YoDouble getTorque() {
        return torque;
    }

    public void setTorque(YoDouble torque) {
        this.torque = torque;
    }
}
