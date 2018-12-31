package org.smallkat.xl;

import org.smallkat.Appendage;
import org.smallkat.customtypes.AppendageSection;
import org.smallkat.customtypes.DHParameters;
import org.smallkat.Leg;
import us.ihmc.euclid.Axis;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.simulationconstructionset.Joint;
import us.ihmc.simulationconstructionset.Link;
import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.UniversalJoint;

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
    private DHParameters topLegPitchDH = new DHParameters(0.3, 0, 0, 0);
    private DHParameters midLegDH = new DHParameters(0.3, 0, 0, 0);
    private DHParameters footDH = new DHParameters(0.3, 0, 0, 0);

    // Masses
    private double topLegMass = 0.33;
    private double midLegMass = 0.33;
    private double footMass = 0.33;

    // Moment of Inertia
    private Vector3D topLegInertia = new Vector3D(0.019 * topLegMass, 0.019 * topLegMass, 0.017 * topLegMass);
    private Vector3D midLegInertia = new Vector3D(0.019 * midLegMass, 0.019 * midLegMass, 0.017 * midLegMass);
    private Vector3D footInertia = new Vector3D(0.019 * footMass, 0.019 * footMass, 0.017 * footMass);

    private String name;
    private String shortname;
    private Robot robot;
    private boolean debug;

    // Constructors

    public XLLeg(String name, String shortname, Robot robot, boolean debug){
        this.name = name;
        this.shortname = shortname;
        this.robot = robot;
        this.debug = debug;
    }

    // Leg Generating Methods
    public void generateLeg(){
        appendageSections.add(makeTopLeg());
    }

    private AppendageSection makeTopLeg(){

        Joint shoulder = new UniversalJoint(makeShortName(TOPLEG_PITCH_JOINTNAME), makeShortName(TOPLEG_ROLL_JOINTNAME),
                legPosition, robot, Axis.X, Axis.Y);
        Link topLeg = new Link(makeShortName(TOPLEG_LINKNAME));
        shoulder.setLink(topLeg);

        topLeg.setMass(topLegMass);
        topLeg.setMomentOfInertia(topLegInertia.getX(), topLegInertia.getY(), topLegInertia.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();
//        linkGraphics.translate();
        linkGraphics.addCoordinateSystem(coordinateLength);
        linkGraphics.addSphere(DEFAULT_JOINT_RADIUS, DEFAULT_JOINT_APPEARANCE);
        linkGraphics.addCylinder(-topLegPitchDH.distance, DEFAULT_LINK_RADIUS, DEFAULT_LINK_APPEARANCE);
//        linkGraphics.translate(0.0, 0.0, topLegPitchDH.radius);

        topLeg.setLinkGraphics(linkGraphics);


        return new AppendageSection(shoulder, topLeg);
    }



    // Getters/Setters and Basic Functions

    public ArrayList<AppendageSection> getAppendageSections(){
        return super.getAppendageSections();
    }

    public Vector3D getLegPosition() {
        return legPosition;
    }

    public void setLegPosition(Vector3D legPosition) {
        this.legPosition = legPosition;
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

    private String makeShortName(String partName){
        return shortname + "_" + partName;
    }
}
