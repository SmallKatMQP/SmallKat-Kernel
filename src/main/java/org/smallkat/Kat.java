package org.smallkat;

import org.smallkat.xl.KatXLRobot;
import us.ihmc.euclid.referenceFrame.ReferenceFrame;
import us.ihmc.humanoidRobotics.bipedSupportPolygons.ContactablePlaneBody;
import us.ihmc.robotics.robotSide.RobotQuadrant;
import us.ihmc.robotics.robotSide.SideDependentList;
import us.ihmc.robotics.screwTheory.RigidBody;

public class Kat {
    //TODO: Comment what these variables do
    private static final ReferenceFrame WORLD_FRAME = ReferenceFrame.getWorldFrame();

    private final KatXLRobot robot = new KatXLRobot();

//    private final InverseDynamicsJointsFromSCSRobotGenerator inverseDynamicsRobot;

//    private final SCSToInverseDynamicsJointMap jointMap;

    /**
     * Center of Mass Reference Frame
     */
//    private final ReferenceFrame comFrame;

    private final SideDependentList<ReferenceFrame> footFrames = new SideDependentList<>();

    private final SideDependentList<ContactablePlaneBody> footContactableBodies = new SideDependentList<>();

    public Kat(){
//        inverseDynamicsRobot = new InverseDynamicsJointsFromSCSRobotGenerator(robot);

//        jointMap = inverseDynamicsRobot.getSCSToInverseDynamicsJointMap();

//        comFrame = new CenterOfMassReferenceFrame("centerOfMassFrame", WORLD_FRAME, inverseDynamicsRobot.getElevator());




    }


    public RigidBody getFoot(RobotQuadrant side){
//        return jointMap.getRigidBody(robot.getFoot(side));
        return null;
    }

}
