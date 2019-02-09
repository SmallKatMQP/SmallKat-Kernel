package org.smallkat.xl;

import org.smallkat.Kat;
import us.ihmc.commonWalkingControlModules.controllerCore.WholeBodyControllerCore;
import us.ihmc.commonWalkingControlModules.controllerCore.WholeBodyControllerCoreMode;
import us.ihmc.commonWalkingControlModules.controllerCore.command.ControllerCoreCommand;
import us.ihmc.graphicsDescription.yoGraphics.YoGraphicsListRegistry;
import us.ihmc.robotics.screwTheory.RigidBody;
import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.util.RobotController;
import us.ihmc.yoVariables.registry.YoVariableRegistry;
import us.ihmc.yoVariables.variable.YoDouble;

public class KatController implements RobotController {

    private String name;
    private YoVariableRegistry registry;
    private final YoDouble time;

    private Kat_XL robot;
//    private final WholeBodyControllerCore bodyController;
//    private final ControllerCoreCommaamand controllerCoreCommand =
//            new ControllerCoreCommand(WholeBodyControllerCoreMode.INVERSE_DYNAMICS);
//    private final RigidBody elevator;

    private YoDouble testDouble;


    public KatController(String name, Kat_XL robot, double controlDT, double gravityZ, YoGraphicsListRegistry graphicsListRegistry){
        this.name = name;
        registry = new YoVariableRegistry(name);
        this.robot = robot;
        time = this.robot.getYoTime();

        Kat kat = new Kat();

//        elevator = this.robot.getElevator();
//        bodyController = createBodyControllerCore(controlDT, gravityZ, graphicsListRegistry);



//        testDouble = new YoDouble("TestDouble", registry);
//        testDouble.set(0);
    }

    private WholeBodyControllerCore createBodyControllerCore(double controlDT, double gravity, YoGraphicsListRegistry yoGraphicsListRegistry){

        return null;
    }

    /**
     * This method gets called each update, where control code is written
     */
    @Override
    public void doControl() {
//        robot.moveTestJoint(testDouble.getDoubleValue());
    }

    /**
     * Initializes stuff
     */
    @Override
    public void initialize() {

    }

    /**
     * Returns a YoVariableRegistry to instantiate the controller and add variables to the system
     * @return YoVariableRegistry
     */
    @Override
    public YoVariableRegistry getYoVariableRegistry() {
        return registry;
    }

    /**
     * Returns the name of the controller
     * @return String name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getDescription() {
        return name;
    }
}
