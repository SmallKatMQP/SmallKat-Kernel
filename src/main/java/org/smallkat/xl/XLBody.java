package org.smallkat.xl;

import org.smallkat.Body;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.euclid.tuple3D.interfaces.Vector3DReadOnly;
import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.FloatingJoint;
import us.ihmc.simulationconstructionset.Link;
import us.ihmc.simulationconstructionset.Robot;

public class XLBody implements Body {

    public static final String BODY_NAME = "Body";

    public static final double BODY_WIDTH = 0.07652;
    public static final double BODY_HEIGHT = 0.05;
    public static final double BODY_LENGTH = 0.23;

    public static final double BODY_MASS = 3; //in kg
    public static final Vector3DReadOnly BODY_COM = new Vector3D(0.0, 0.0, 0.0);
    public static final Vector3DReadOnly BODY_INTERTIA = new Vector3D(0.019 * BODY_MASS, 0.019 * BODY_MASS, 0.017 * BODY_MASS);

    protected Link bodyLink;
    protected FloatingJoint bodyJoint;

    public XLBody(Vector3D bodyPos, Robot robot){
        bodyJoint = generateBodyJoint(bodyPos, robot);
        bodyLink = generatBodyLink(false);

        bodyJoint.setLink(bodyLink);
    }

    private FloatingJoint generateBodyJoint(Vector3D position, Robot robot){
        FloatingJoint joint = new FloatingJoint(BODY_NAME, new Vector3D(), robot);
        joint.setPosition(position);
        return joint;
    }

    private Link generatBodyLink(boolean debug){
        Link link = new Link(BODY_NAME);
        link.setMass(BODY_MASS);
        link.setComOffset(new Vector3D(BODY_COM));
        link.setMomentOfInertia(BODY_INTERTIA.getX(), BODY_INTERTIA.getY(), BODY_INTERTIA.getZ());

        Graphics3DObject linkGraphics = new Graphics3DObject();
        if (debug) {
            linkGraphics.addCoordinateSystem(0.3);
        }
        linkGraphics.addCube(BODY_LENGTH, BODY_WIDTH, BODY_HEIGHT, YoAppearance.Green());

        link.setLinkGraphics(linkGraphics);
        return link;
    }

    public FloatingJoint getMainBodyJoint(){
        return bodyJoint;
    }

    public Link getLink(){
        return bodyLink;
    }
}
