package org.smallkat.xl;

import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.FloatingJoint;
import us.ihmc.simulationconstructionset.Link;
import us.ihmc.simulationconstructionset.PinJoint;
import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;
import us.ihmc.yoVariables.variable.YoDouble;

public class Kat_XL extends Robot {
    public static final String ROOBOT_NAME = "SmallKatXL";

    XLBody body;
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


    }


}
