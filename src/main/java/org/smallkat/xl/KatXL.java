package org.smallkat.xl;

import org.smallkat.customtypes.DHParameters;
import us.ihmc.euclid.tuple3D.Vector3D;

public class KatXL {

    /**
     * Body Parameters
     */
    public static final Vector3D BODY_POSITION = new Vector3D(0, 0, 0.4);

    /**
     * Front Right Parameters
     */
    public static final DHParameters FR_SHOULDER_DH = new DHParameters(0, 0, 90, 0);
    public static final DHParameters FR_TOPLEG_DH = new DHParameters(0, 0.092, 0, -22.5);
    public static final DHParameters FR_MIDLEG_DH = new DHParameters(0, 0.075, 0, 22.5);
    public static final DHParameters FR_FOOT_DH = new DHParameters(0, 0.07103, 0, 45);

    public static final Vector3D FR_POSITION = new Vector3D(0.115, -0.03826, 0.0);

    /**
     * Front Left Parameters
     */
    public static final DHParameters FL_SHOULDER_DH = new DHParameters(0, 0, 90, 0);
    public static final DHParameters FL_TOPLEG_DH = new DHParameters(0, 0.092, 0, -22.5);
    public static final DHParameters FL_MIDLEG_DH = new DHParameters(0, 0.075, 0, 22.5);
    public static final DHParameters FL_FOOT_DH = new DHParameters(0, 0.07103, 0, 45);

    public static final Vector3D FL_POSITION = new Vector3D(0.115, 0.03826, 0.0);

    /**
     * Hind Right Parameters
     */
    public static final DHParameters HR_SHOULDER_DH = new DHParameters(0, 0, 90, 0);
    public static final DHParameters HR_TOPLEG_DH = new DHParameters(0, 0.092, 0, 22.5);
    public static final DHParameters HR_MIDLEG_DH = new DHParameters(0, 0.075, 0, -22.5);
    public static final DHParameters HR_FOOT_DH = new DHParameters(0, 0.095, 0, 45);

    public static final Vector3D HR_POSITION = new Vector3D(-0.115, -0.03826, 0.0);

    /**
     * Hind Left Parameters
     */
    public static final DHParameters HL_SHOULDER_DH = new DHParameters(0, 0, 90, 0);
    public static final DHParameters HL_TOPLEG_DH = new DHParameters(0, 0.092, 0, 22.5);
    public static final DHParameters HL_MIDLEG_DH = new DHParameters(0, 0.075, 0, -22.5);
    public static final DHParameters HL_FOOT_DH = new DHParameters(0, 0.095, 0, 45);

    public static final Vector3D HL_POSITION = new Vector3D(-0.115, 0.03826, 0.0);

    // Leg Names
    public static final String TOPLEG_LINKNAME = "TopLeg";
    public static final String TOPLEG_PITCH_JOINTNAME = "ShoulderPitch";
    public static final String TOPLEG_ROLL_JOINTNAME = "ShoulderRoll";

    public static final String MIDLEG_LINKNAME = "MidLeg";
    public static final String MIDLEG_JOINTNAME = "Knee";

    public static final String FOOT_LINKNAME = "Foot";
    public static final String FOOT_JOINTNAME = "Ankle";
    public static final String GROUND_CONTACT_POINT = "GroundContactPoint";

    public KatXL(){

    }

}
