package org.smallkat.xl;

import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.*;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;
import us.ihmc.yoVariables.variable.YoDouble;

public class Kat_XL extends Robot {
    public static final String ROOBOT_NAME = "SmallKatXL";

    XLBody body;
    Leg frontLeftLeg;
    Leg frontRightLeg;
    Leg backLeftLeg;
    Leg backRightLeg;


    private static final double BODY_POS_X = 0;
    private static final double BODY_POS_Y = 0;
    private static final double BODY_POS_Z = 0.5;


    public Kat_XL(RobotDefinitionFixedFrame definition, String name) {
        super(definition, name);
    }

    /**
     * Creates a Robot with the specified name. A Robot is a forest of trees of
     * Joints, each Joint having an associated Link.
     *
     */
    public Kat_XL() {
        super(ROOBOT_NAME);

        body = new XLBody(BODY_POS_X, BODY_POS_Y, BODY_POS_Z, this);
        this.addRootJoint(body.getJoint());

        frontLeftLeg = new XLFrontLeg("FrontLeft", "FR", this);

//        Joint rightHipUni = new UniversalJoint("right_hip_yaw", "right_hip_roll", new Vector3D(0.0, 0.0, 0.0), this, Axis.Z, Axis.X);
//        Link rightWaistLink = rightThigh();
//        rightHipUni.setLink(rightWaistLink);
//        body.getJoint().addJoint(rightHipUni);

        body.getJoint().addJoint(frontLeftLeg.getAppendageSections().get(0).getJoint());

//        frontRightLeg = new XLFrontLeg();
//        backLeftLeg = new XLBackLeg();
//        backRightLeg = new XLBackLeg();


    }

    private Link rightThigh() {
        Link ret = new Link("right_thigh");
        ret.setMass(0.3);
        ret.setComOffset(new Vector3D(new Vector3D(0.0, 0.0, 0.0)));
        ret.setMomentOfInertia(0.0, 0.0, 0.0);

        Graphics3DObject linkGraphics = new Graphics3DObject();
        linkGraphics.translate(0.0, -0.3, -0.3);
        linkGraphics.addCylinder(-0.3, 0.05);
        linkGraphics.translate(0.0, 0.1, 0.1);
        ret.setLinkGraphics(linkGraphics);

        return ret;
    }


}
