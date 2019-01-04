package org.smallkat.customtypes;

import us.ihmc.graphicsDescription.Graphics3DObject;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.Joint;
import us.ihmc.simulationconstructionset.Link;

public class AppendageSection {


    private Joint joint;
    private Link link;

    double linkLength;
    double linkDiameter;

    double jointDiameter;

    double dh_distance;
    double dh_radius;
    double dh_theta;
    double dh_alpha;

    public AppendageSection(Joint joint, Link link){
        this.joint = joint;
        this.link = link;

    }

    public void setDefaultGraphics(double sphereRadius, double cylinderRadius){
        Graphics3DObject linkGraphics = new Graphics3DObject();
        linkGraphics.addSphere(sphereRadius, YoAppearance.Red());
        linkGraphics.addCylinder(linkLength, cylinderRadius, YoAppearance.Blue());
        linkGraphics.translate(0.0, 0.0, linkLength);
        link.setLinkGraphics(linkGraphics);
    }

    public void setGraphics(Graphics3DObject linkGraphics){
        link.setLinkGraphics(linkGraphics);
    }

    public void setLink(){
        this.joint.setLink(this.link);
    }

    public Joint getJoint() {
        return joint;
    }

    public void setJoint(Joint joint) {
        this.joint = joint;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

}
