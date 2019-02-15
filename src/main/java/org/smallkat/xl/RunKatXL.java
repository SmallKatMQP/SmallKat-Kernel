package org.smallkat.xl;

import us.ihmc.graphicsDescription.yoGraphics.YoGraphicsListRegistry;
import us.ihmc.simulationconstructionset.GroundContactModel;
import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.SimulationConstructionSet;
import us.ihmc.simulationconstructionset.SimulationConstructionSetParameters;
import us.ihmc.simulationconstructionset.util.LinearGroundContactModel;

public class RunKatXL {

    double gravityMag = 9.81;
    double controllerDT = 1.0e-2;
    double simulatedDT = 4.0e-4;
    YoGraphicsListRegistry yoGraphicsListRegistry = new YoGraphicsListRegistry();


    RunKatXL(String[] args){

        KatXLRobot robot = new KatXLRobot();
        robot.setController(new KatController("KatController", robot, controllerDT, gravityMag, yoGraphicsListRegistry));

        runSim(robot);

    }

    void runSim(Robot robot){
        final double DT = 0.001;


        GroundContactModel groundModel = new LinearGroundContactModel(robot,
                4000, 500, 500, 500, robot.getRobotsYoVariableRegistry());

        robot.setGroundContactModel(groundModel);

        SimulationConstructionSetParameters parameters = new SimulationConstructionSetParameters();
        parameters.setDataBufferSize(32000);

        SimulationConstructionSet sim = new SimulationConstructionSet(robot, parameters);
        sim.setDT(DT, 20);
        sim.setGroundVisible(true);
//        sim.setCameraPosition(0, -5.0, 0.6);
//        sim.setCameraFix(0.0, 0.0, 0.70);

//        sim.setSimulateDuration(5);
        sim.setGroundVisible(true);
//        sim.setGroundAppearance(YoAppearance.EarthTexture());

        Thread myThread = new Thread(sim);

        myThread.start();
    }


    public static void main(String[] args) {
        new RunKatXL(args);
    }

}
