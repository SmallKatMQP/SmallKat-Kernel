package org.smallkat.xl;

import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.simulationconstructionset.Robot;

public class XLBackLeg extends XLLeg {

    public XLBackLeg(String name, Vector3D legPos, Robot robot){
        super(name, robot, legPos);
        super.generateLeg();
    }


}
