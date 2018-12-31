package org.smallkat.xl;

import us.ihmc.euclid.tuple3D.Vector3D;
import us.ihmc.simulationconstructionset.Robot;


public class XLFrontLeg extends XLLeg {


    public XLFrontLeg(String name, String shortname, Robot robot){
        super(name, shortname, robot);

        this.setLegPosition(new Vector3D(0.0, 0.0, 0.0));

        generateLeg();
    }

    public XLFrontLeg(String name, Robot robot){
        this(name, name, robot);
    }






}
