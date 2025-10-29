package org.firstinspires.ftc.team3470.Components;

//TODO Import Statement

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Main robot class; holds all subsystems.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: Raphael Manayon
 * @version October 5, 2025
 */
//TODO USE REAL PARTS
public class Robot {
    public OpMode myOpMode;

    public DriveTrain driveTrain = new DriveTrain();
    public FlyWheelShooter flyWheelShooter = new FlyWheelShooter();
    public CameraSystem cameraSystem = new CameraSystem();
    public Component[] components = {cameraSystem, flyWheelShooter, driveTrain};

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for Robot.
     *
     * @param opMode The running OP Mode
     */
    public Robot(OpMode opMode) {
        this.myOpMode = opMode;
    }

    /**
     * Initialize every component of the robot
     */
    public void init() {
        for (Component component : components) {
            component.init(myOpMode.hardwareMap);
        }
    }
}

