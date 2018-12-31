package org.smallkat.xl;

import org.smallkat.Appendage;
import org.smallkat.Leg;
import us.ihmc.simulationconstructionset.Robot;

public class XLBackLeg extends XLLeg {

    public XLBackLeg(String name, String shortname, Robot robot){
        super(name, shortname, robot, true);
//        generateLeg();
    }

    public XLBackLeg(String name, Robot robot){
        this(name, name, robot);
    }

}
