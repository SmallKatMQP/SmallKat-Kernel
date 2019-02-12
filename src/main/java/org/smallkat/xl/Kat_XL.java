package org.smallkat.xl;

import org.smallkat.Body;
import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.euclid.tuple3D.interfaces.Vector3DReadOnly;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.robotics.robotSide.RobotQuadrant;
import us.ihmc.robotics.robotSide.RobotSide;
import us.ihmc.robotics.screwTheory.RigidBody;
import us.ihmc.simulationconstructionset.*;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;
import us.ihmc.yoVariables.variable.YoDouble;

import java.util.HashMap;
import java.util.Map;

public class Kat_XL extends Robot {
    public static final String ROOBOT_NAME = "KatXL";

    //TODO: Make a body interface
    Body body;

    private static final Vector3D bodyPos = new Vector3D(0, 0, 0.4); //0.26164
    private static final Vector3D frontLeftLegPos = new Vector3D(0.115, 0.03826, 0.0);
    private static final Vector3D frontRightLegPos = new Vector3D(0.115, -0.03826, 0.0);
    private static final Vector3D hindLeftLegPos = new Vector3D(-0.115, 0.03826, 0.0);
    private static final Vector3D hindRightLegPos = new Vector3D(-0.115, -0.03826, 0.0);

    private Map<RobotQuadrant, XLLeg> legMap = new HashMap<>();
    private Map<RobotQuadrant, Vector3D> legPositionMap = new HashMap<>();


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
        this.addRootJoint(body.getMainBodyJoint());

        setLegPositions();

        for(RobotQuadrant side: RobotQuadrant.values){
            legMap.put(side, new XLLeg(side.getCamelCaseName(), legPositionMap.get(side), this));
        }
    }


    /**
     * Places leg positions into the
     */
    private void setLegPositions(){
        legPositionMap.put(RobotQuadrant.FRONT_LEFT, frontLeftLegPos);
        legPositionMap.put(RobotQuadrant.FRONT_RIGHT, frontRightLegPos);
        legPositionMap.put(RobotQuadrant.HIND_LEFT, hindLeftLegPos);
        legPositionMap.put(RobotQuadrant.HIND_RIGHT, hindRightLegPos);
    }

}
