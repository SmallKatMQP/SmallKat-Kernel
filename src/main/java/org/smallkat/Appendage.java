package org.smallkat;

import org.smallkat.customtypes.AppendageSection;
import us.ihmc.simulationconstructionset.Joint;

import java.util.ArrayList;

public class Appendage {

    protected ArrayList<AppendageSection> appendageSections;

    protected Joint endEffector;

    public Appendage(){

        appendageSections = new ArrayList<>();

    }

    protected void addEndEffector(Joint joint){
        endEffector = joint;
    }

    public ArrayList<AppendageSection> getAppendageSections(){
        return appendageSections;
    }


}

