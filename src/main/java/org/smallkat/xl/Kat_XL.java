package org.smallkat.xl;

import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.euclid.tuple3D.interfaces.Vector3DReadOnly;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.*;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;
import us.ihmc.yoVariables.variable.YoDouble;

public class Kat_XL extends Robot {
    public static final String ROOBOT_NAME = "SmallKatXL";

    //TODO: Make a body interface
    XLBody body;
    Leg frontLeftLeg;
    Leg frontRightLeg;
    Leg backLeftLeg;
    Leg backRightLeg;

    private static final Vector3D bodyPos = new Vector3D(0, 0, 0.5);
    private static final Vector3D frontLeftLegPos = new Vector3D(0.115, 0.03826, 0.0);
    private static final Vector3D frontRightLegPos = new Vector3D(0.115, -0.03826, 0.0);
    private static final Vector3D backLeftLegPos = new Vector3D(-0.115, 0.03826, 0.0);
    private static final Vector3D backRightLegPos = new Vector3D(-0.115, -0.03826, 0.0);


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

        body = new XLBody(bodyPos, this);
        this.addRootJoint(body.getJoint());

        frontLeftLeg = new XLFrontLeg("FrontLeft", frontLeftLegPos, this);
        body.getJoint().addJoint(frontLeftLeg.getFirstJoint());

//        frontRightLeg = new XLFrontLeg();
//        backLeftLeg = new XLBackLeg();
//        backRightLeg = new XLBackLeg();


    }



}
