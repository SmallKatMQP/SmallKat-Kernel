package org.smallkat.xl;

import org.smallkat.Appendage;
import org.smallkat.customtypes.AppendageSection;
import org.smallkat.customtypes.DHParameters;
import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.simulationconstructionset.*;

import java.util.ArrayList;

public class XLLeg extends Appendage implements Leg {

    // Leg Names
    public static final String TOPLEG_LINKNAME = "TopLeg";
    public static final String TOPLEG_PITCH_JOINTNAME = "ShoulderPitch";
    public static final String TOPLEG_ROLL_JOINTNAME = "ShoulderRoll";

    public static final String MIDLEG_LINKNAME = "MidLeg";
    public static final String MIDLEG_JOINTNAME = "Knee";

    public static final String FOOT_LINKNAME = "Foot";
    public static final String FOOT_JOINTNAME = "Ankle";

    private Vector3D legPosition = new Vector3D(0, 0, 0);

    private DHParameters topLegRollDH = new DHParameters(0, 0, 0, 0);
    private DHParameters topLegPitchDH = new DHParameters(0.092, 0, 0, 0);
    private DHParameters midLegDH = new DHParameters(0.075, 0, 0, 0);
    private DHParameters footDH = new DHParameters(0.09464, 0, 0, 0);

    // Masses
    private double topLegMass = 0.33;
    private double midLegMass = 0.33;
    private double footMass = 0.33;

    // Moment of Inertia
    private Vector3D topLegInertia = new Vector3D(0.019 * topLegMass, 0.019 * topLegMass, 0.017 * topLegMass);
    private Vector3D midLegInertia = new Vector3D(0.019 * midLegMass, 0.019 * midLegMass, 0.017 * midLegMass);
    private Vector3D footInertia = new Vector3D(0.019 * footMass, 0.019 * footMass, 0.017 * footMass);

    private String name;
    private Robot robot;

    // Constructors

    public XLLeg(String name, Vector3D legPos, Robot robot ){
        this.name = name;
        this.robot = robot;
        this.legPosition = legPos;
        generateLeg();
        robot.getJoint("Body").addJoint(getFirstJoint());
    }

    // Leg Generating Methods
    void generateLeg(){
        appendageSections.add(makeTopLeg(false));
        appendageSections.add(makeMidLeg(false));
        appendageSections.add(makeFoot(true));
        attachLegs();
    }

    void attachLegs(){
        for(int i = 1; i < appendageSections.size(); i++){
            appendageSections.get(i-1).getJoint().addJoint(appendageSections.get(i).getJoint());
        }
    }

    private AppendageSection makeTopLeg(boolean debug){

        Joint shoulder = new UniversalJoint(makeName(TOPLEG_PITCH_JOINTNAME), makeName(TOPLEG_ROLL_JOINTNAME),
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
        linkGraphics.addCylinder(-topLegPitchDH.distance, DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        topLeg.setLinkGraphics(linkGraphics);

        return new AppendageSection(shoulder, topLeg);
    }

    private AppendageSection makeMidLeg(boolean debug){
        Joint knee = new PinJoint(makeName(MIDLEG_JOINTNAME), new Vector3D(0, 0, -topLegPitchDH.distance), robot, Axis.Y);
        Link midLeg = new Link(makeName(MIDLEG_LINKNAME));
        knee.setLink(midLeg);

        midLeg.setMass(midLegMass);
        midLeg.setMomentOfInertia(midLegInertia.getX(), midLegInertia.getY(), midLegInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        linkGraphics.addCylinder(-midLegDH.distance, DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        midLeg.setLinkGraphics(linkGraphics);

        return new AppendageSection(knee, midLeg);
    }

    private AppendageSection makeFoot(boolean debug){
        Joint ankle = new PinJoint(makeName(FOOT_JOINTNAME), new Vector3D(0, 0, -midLegDH.distance), robot, Axis.Y);
        Link foot = new Link(makeName(FOOT_LINKNAME));
        ankle.setLink(foot);

        foot.setMass(footMass);
        foot.setMomentOfInertia(footInertia.getX(), footInertia.getY(), footInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();

        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        linkGraphics.addCylinder(-midLegDH.distance, DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
        linkGraphics.translate(0, 0, -footDH.distance);
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        if (debug){
            linkGraphics.addCoordinateSystem(coordinateLength);
        }
        foot.setLinkGraphics(linkGraphics);

        return new AppendageSection(ankle, foot);
    }


    // Getters/Setters and Basic Functions

    public Joint getFirstJoint(){
        return appendageSections.get(0).getJoint();
    }

    public ArrayList<AppendageSection> getAppendageSections(){
        return super.getAppendageSections();
    }

    public DHParameters getTopLegRollDH() {
        return topLegRollDH;
    }

    public void setTopLegRollDH(DHParameters topLegRollDH) {
        this.topLegRollDH = topLegRollDH;
    }

    public DHParameters getTopLegPitchDH() {
        return topLegPitchDH;
    }

    public void setTopLegPitchDH(DHParameters topLegPitchDH) {
        this.topLegPitchDH = topLegPitchDH;
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
