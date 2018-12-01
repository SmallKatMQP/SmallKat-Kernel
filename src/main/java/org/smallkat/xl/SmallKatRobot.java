package org.smallkat.xl;

import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;

public class SmallKatRobot extends Robot {


    public SmallKatRobot(RobotDefinitionFixedFrame definition, String name) {
        super(definition, name);
    }

    public SmallKatRobot(String name) {
        super(name);
    }
}
