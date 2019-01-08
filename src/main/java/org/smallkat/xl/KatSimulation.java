package org.smallkat.xl;

import us.ihmc.graphicsDescription.appearance.YoAppearance;
import us.ihmc.simulationconstructionset.GroundContactModel;
import us.ihmc.simulationconstructionset.GroundContactPoint;
import us.ihmc.simulationconstructionset.SimulationConstructionSet;
import us.ihmc.simulationconstructionset.SimulationConstructionSetParameters;
import us.ihmc.simulationconstructionset.util.LinearGroundContactModel;
//import us.ihmc.euclid.geometry.Shape3D

public class KatSimulation {

    public static final double DT = 0.001;
    private SimulationConstructionSet sim;

    public KatSimulation(){

        Kat_XL robot = new Kat_XL();

        GroundContactModel groundModel = new LinearGroundContactModel(robot, 4000,
                500, 500, 500, robot.getRobotsYoVariableRegistry());

        robot.setGroundContactModel(groundModel);

        XLController controller = new XLController();
        controller.initialize();
        robot.setController(controller, 1);

        SimulationConstructionSetParameters parameters = new SimulationConstructionSetParameters();
        parameters.setDataBufferSize(32000);

        sim = new SimulationConstructionSet(robot, parameters);
        sim.setDT(DT, 20);
        sim.setGroundVisible(true);
//        sim.setCameraPosition(0, -5.0, 0.6);
//        sim.setCameraFix(0.0, 0.0, 0.70);

        sim.setSimulateDuration(5);
        sim.setGroundVisible(true);
//        sim.setGroundAppearance(YoAppearance.EarthTexture());

        Thread myThread = new Thread(sim);

        myThread.start();
    }

    public static void main(String[] args) {
        new KatSimulation();
    }

}
