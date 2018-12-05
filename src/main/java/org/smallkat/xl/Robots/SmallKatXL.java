package org.smallkat.xl.Robots;

import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.robotdefinition.RobotDefinitionFixedFrame;

public class SmallKatXL extends Robot {

    public SmallKatXL(RobotDefinitionFixedFrame definition, String name) {
        super(definition, name);
    }

    public SmallKatXL(String name) {
        super(name);
    }

    public Robot getSimulatedRobot(){
        return null;
    }

}
