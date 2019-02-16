package org.smallkat.xl;

import org.smallkat.Appendage;
import org.smallkat.customtypes.AppendageSection;
import org.smallkat.customtypes.DHParameters;
import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.robotics.robotSide.RobotQuadrant;
import us.ihmc.simulationconstructionset.*;
import static org.smallkat.xl.KatXL.*;

import java.util.ArrayList;

public class XLLeg extends Appendage implements Leg {



    private Vector3D legPosition = new Vector3D(0, 0, 0);

    private DHParameters shoulderDH = new DHParameters(0, 0, 0, 0);
    private DHParameters topLegDH = new DHParameters(0, 0.092, 0, 0);
    private DHParameters midLegDH = new DHParameters(0, 0.075, 0, 0);
    private DHParameters footDH = new DHParameters(0, 0.09464, 0, 0);

    // Masses
    private double topLegMass = 0.33;
    private double midLegMass = 0.33;
    private double footMass = 0.33;

    // Moment of Inertia
    private Vector3D topLegInertia = new Vector3D(0.019 * topLegMass, 0.019 * topLegMass, 0.017 * topLegMass);
    private Vector3D midLegInertia = new Vector3D(0.019 * midLegMass, 0.019 * midLegMass, 0.017 * midLegMass);
    private Vector3D footInertia = new Vector3D(0.019 * footMass, 0.019 * footMass, 0.017 * footMass);

    private String name;
    private KatXLRobot robot;

    // Constructors

    public XLLeg(String name, Vector3D legPos, KatXLRobot robot){
        this.name = name;
        this.robot = robot;
        this.legPosition = legPos;

        generateLeg();
        robot.getJoint("Body").addJoint(getFirstJoint());
    }

    public XLLeg(String name, Vector3D legPos, KatXLRobot robot,
                 DHParameters shoulder, DHParameters topleg, DHParameters midleg, DHParameters foot){
        this.name = name;
        this.robot = robot;
        this.legPosition = legPos;

        shoulderDH = shoulder;
        topLegDH = topleg;
        midLegDH = midleg;
        footDH = foot;

        generateLeg();
        robot.getJoint("Body").addJoint(getFirstJoint());
    }

    // Leg Generating Methods
    void generateLeg(){
        appendageSections.add(makeTopLeg(false));
        appendageSections.add(makeMidLeg(false));
        appendageSections.add(makeFoot(false));
        attachLegs();
    }



    void attachLegs(){
        for(int i = 1; i < appendageSections.size(); i++){
            appendageSections.get(i-1).getJoint().addJoint(appendageSections.get(i).getJoint());
        }
    }

    private AppendageSection makeTopLeg(boolean debug){

        Joint shoulder = new UniversalJoint(makeName(TOPLEG_ROLL_JOINTNAME), makeName(TOPLEG_PITCH_JOINTNAME),
                legPosition, robot, Axis.X, Axis.Y);
        Link topLeg = new Link(makeName(TOPLEG_LINKNAME));
        shoulder.setLink(topLeg);


        topLeg.setMass(topLegMass);
        topLeg.setMomentOfInertia(topLegInertia.getX(), topLegInertia.getY(), topLegInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        linkGraphics.addCylinder(-topLegDH.getR(), DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        topLeg.setLinkGraphics(linkGraphics);

        return new AppendageSection(shoulder, topLeg);
    }

    private AppendageSection makeMidLeg(boolean debug){
        Joint knee = new PinJoint(makeName(MIDLEG_JOINTNAME), new Vector3D(0, 0, -topLegDH.getR()), robot, Axis.Y);
        Link midLeg = new Link(makeName(MIDLEG_LINKNAME));
        knee.setLink(midLeg);
        ((PinJoint) knee).setQ(midLegDH.getTheta());

        midLeg.setMass(midLegMass);
        midLeg.setMomentOfInertia(midLegInertia.getX(), midLegInertia.getY(), midLegInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        linkGraphics.addCylinder(-midLegDH.getR(), DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        midLeg.setLinkGraphics(linkGraphics);

        return new AppendageSection(knee, midLeg);
    }

    private AppendageSection makeFoot(boolean debug){
        Joint ankle = new PinJoint(makeName(FOOT_JOINTNAME), new Vector3D(0, 0, -midLegDH.getR()), robot, Axis.Y);
        Link foot = new Link(makeName(FOOT_LINKNAME));
        ankle.setLink(foot);
        ((PinJoint) ankle).setQ(footDH.getTheta());

        foot.setMass(footMass);
        foot.setMomentOfInertia(footInertia.getX(), footInertia.getY(), footInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();

        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        linkGraphics.addCylinder(-midLegDH.getR(), DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        linkGraphics.translate(0, 0, -footDH.getR());
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        foot.setLinkGraphics(linkGraphics);

        GroundContactPoint groundContactPoint = new GroundContactPoint(makeName(GROUND_CONTACT_POINT),
                new Vector3D(0, 0, -footDH.getR()), robot);
        ankle.addGroundContactPoint(groundContactPoint);

//        ReferenceFrame footFrame =

        return new AppendageSection(ankle, foot);
    }


    // Getters/Setters and Basic Functions

    public Joint getFirstJoint(){
        return appendageSections.get(0).getJoint();
    }

    public Joint getAnkleJoint(){
        return appendageSections.get(2).getJoint();
    }

    /**
     * Returns which corner the leg is positioned at
     * @return {@code RobotQuadrant} corner of the leg
     */
    public RobotQuadrant getQuadrant(){
        return null;
    }

    public ArrayList<AppendageSection> getAppendageSections(){
        return super.getAppendageSections();
    }

    public DHParameters getShoulderDH() {
        return shoulderDH;
    }

    public void setShoulderDH(DHParameters shoulderDH) {
        this.shoulderDH = shoulderDH;
    }

    public DHParameters getTopLegDH() {
        return topLegDH;
    }

    public void setTopLegDH(DHParameters topLegDH) {
        this.topLegDH = topLegDH;
    }

    public DHParameters getMidLegDH() {
        return midLegDH;
    }

    public void setMidLegDH(DHParameters midLegDH) {
        this.midLegDH = midLegDH;
    }

    public DHParameters getFootDH() {
        return footDH;
    }

    public void setFootDH(DHParameters footDH) {
        this.footDH = footDH;
    }

    private String makeName(String partName){
        return name + "_" + partName;
    }
}
