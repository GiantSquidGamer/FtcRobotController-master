package org.firstinspires.ftc.team3470;

//TODO Import Statement

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
    private DriveTrain driveTrain;
    private FlyWheelShooter flyWheelShooter;
    private CameraSystem cameraSystem;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for Robot.
     *
     * @param driveTrain drive train system
     * @param flyWheelShooter flywheel shooter system
     * @param cameraSystem system for camera use
     */
    public Robot(DriveTrain driveTrain, FlyWheelShooter flyWheelShooter, CameraSystem cameraSystem) {
        this.driveTrain = driveTrain;
        this.flyWheelShooter = flyWheelShooter;
        this.cameraSystem = cameraSystem;
    }
    /**
     * Moves the robot in a specified direction.
     *
     * @param direction “forward”, “backward”, “left”, “right”, “rotateLeft”, “rotateRight”
     * @param speed 0.0–1.0
     */
    public void move(String direction, double speed) {
        //TODO
    }

    /**
     * Activates the sorting system intake to pick up balls.
     */
    public void pickUpBalls()
    {
        //TODO
    }

    /**
     * Detects color and routes balls using the SortingSystem.
     */
    public void sortBalls(){
        //TODO
    }

    /**
     * Feeds a ball into the FlyWheelShooter and fires.
     */
    public void shootBall()
    {
        //TODO
    }

    /**
     * Calls the CameraSystem to read a QR code.
     *
     * @return String (QR code value)
     */
    public String readQRCode()
    {
        //TODO
        return null;
    }

}

