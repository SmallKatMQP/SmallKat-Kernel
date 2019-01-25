package org.smallkat;

import us.ihmc.graphicsDescription.appearance.AppearanceDefinition;
import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.Joint;

public interface Leg {

    AppearanceDefinition DEFAULT_JOINT_APPEARANCE = YoAppearance.Red();
    AppearanceDefinition DEFAULT_LINK_APPEARANCE = YoAppearance.Blue();

    double DEFAULT_JOINT_RADIUS = 0.025;
    double DEFAULT_LINK_RADIUS = 0.01;

    double coordinateLength = 0.2;

    Joint getFirstJoint();
    Joint getAnkleJoint();



}
