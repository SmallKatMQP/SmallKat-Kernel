package org.smallkat.xl;

import org.smallkat.Controller;
import us.ihmc.simulationconstructionset.Robot;
import us.ihmc.simulationconstructionset.util.RobotController;
import us.ihmc.yoVariables.registry.YoVariableRegistry;

public class XLController implements Controller {
    private String name;
    private Robot robot;

    public XLController(String name, Robot robot){
        this.name = name;
        this.robot = robot;

    }

    public XLController(){

    }

    @Override
    public void doControl() {

    }

    @Override
    public void initialize() {

    }

    @Override
    public YoVariableRegistry getYoVariableRegistry() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
