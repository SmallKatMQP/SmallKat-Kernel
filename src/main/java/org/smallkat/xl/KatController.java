package org.smallkat.xl;

import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.util.RobotController;
import us.ihmc.yoVariables.registry.YoVariableRegistry;
import us.ihmc.yoVariables.variable.YoDouble;

public class KatController implements RobotController {

    private String name;
    private YoVariableRegistry registry;
    private Kat_XL robot;

    private YoDouble testDouble;


    public KatController(String name, Kat_XL robot){
        this.name = name;
        registry = new YoVariableRegistry(name);
        this.robot = robot;

        testDouble = new YoDouble("TestDouble", registry);
        testDouble.set(0);
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
