package org.smallkat.xl;

import us.ihmc.simulationconstructionset.SimulationConstructionSet;
import us.ihmc.simulationconstructionset.SimulationConstructionSetParameters;
//import us.ihmc.euclid.geometry.Shape3D

public class KatSimulation {

    public static final double DT = 0.001;
    private SimulationConstructionSet sim;

    public KatSimulation(){

        Kat_XL robot = new Kat_XL();

        SimulationConstructionSetParameters parameters = new SimulationConstructionSetParameters();
        parameters.setDataBufferSize(32000);

        sim = new SimulationConstructionSet(robot, parameters);
        sim.setDT(DT, 20);
        sim.setGroundVisible(true);
//        sim.setCameraPosition(0, -5.0, 0.6);
//        sim.setCameraFix(0.0, 0.0, 0.70);

        sim.setSimulateDuration(60);

        Thread myThread = new Thread(sim);

        myThread.start();
    }

    public static void main(String[] args) {
        new KatSimulation();
    }

}
