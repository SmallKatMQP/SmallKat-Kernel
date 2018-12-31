package org.smallkat;


import org.smallkat.customtypes.AppendageSection;
import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.graphicsDescription.appearance.AppearanceDefinition;
import us.ihmc.graphicsDescription.appearance.YoAppearance;

import java.util.ArrayList;

public interface Leg {

    AppearanceDefinition DEFAULT_JOINT_APPEARANCE = YoAppearance.Red();
    AppearanceDefinition DEFAULT_LINK_APPEARANCE = YoAppearance.Blue();

    double DEFAULT_JOINT_RADIUS = 0.025;
    double DEFAULT_LINK_RADIUS = 0.01;

    double coordinateLength = 0.2;

    ArrayList<AppendageSection> getAppendageSections();
    void setLegPosition(Vector3D legPosition);
    void generateLeg();

//    void addSection(AppendageSection section);



}
