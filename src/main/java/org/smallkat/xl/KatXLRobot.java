package org.smallkat.xl;

import org.smallkat.Body;
import org.smallkat.Leg;
import us.ihmc.robotics.robotSide.RobotQuadrant;
import us.ihmc.simulationconstructionset.*;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;
import static org.smallkat.xl.KatXL.*;


public class KatXLRobot extends Robot {
    public static final String ROOBOT_NAME = "KatXL";

    private Body body;

    private Leg frLeg;
    private Leg flLeg;
    private Leg hrLeg;
    private Leg hlLeg;


    public KatXLRobot(RobotDefinitionFixedFrame definition, String name) {
        super(definition, name);
    }


    public KatXLRobot() {
        super(ROOBOT_NAME);

        body = new XLBody(BODY_POSITION, this);
        this.addRootJoint(body.getMainBodyJoint());

        frLeg = new XLLeg("FR", FR_POSITION, this,
                FR_SHOULDER_DH, FR_TOPLEG_DH, FR_MIDLEG_DH, FR_FOOT_DH);
        flLeg = new XLLeg("FL", FL_POSITION, this,
                FL_SHOULDER_DH, FL_TOPLEG_DH, FL_MIDLEG_DH, FL_FOOT_DH);
        hrLeg = new XLLeg("HR", HR_POSITION, this,
                HR_SHOULDER_DH, HR_TOPLEG_DH, HR_MIDLEG_DH, HR_FOOT_DH);
        hlLeg = new XLLeg("HL", HL_POSITION, this,
                HL_SHOULDER_DH, HL_TOPLEG_DH, HL_MIDLEG_DH, HL_FOOT_DH);

    }

    public Joint getBody(){
        return body.getMainBodyJoint();
    }

    public Joint getFoot(RobotQuadrant side){
        return null;
    }

}
