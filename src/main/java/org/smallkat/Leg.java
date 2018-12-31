package org.smallkat;


import org.smallkat.customtypes.AppendageSection;
import us.ihmc.graphicsDescription.appearance.AppearanceDefinition;
import us.ihmc.graphicsDescription.appearance.YoAppearance;

import java.util.ArrayList;

public interface Leg {

    AppearanceDefinition DEFAULT_JOINT_APPEARANCE = YoAppearance.Red();
    AppearanceDefinition DEFAULT_LINK_APPEARANCE = YoAppearance.Blue();

    double DEFAULT_JOINT_RADIUS = 0.1;
    double DEFAULT_LINK_RADIUS = 0.05;

    ArrayList<AppendageSection> getAppendageSections();

//    void addSection(AppendageSection section);



}
