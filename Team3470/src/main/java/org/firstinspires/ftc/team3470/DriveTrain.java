package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Controls the 4 mecanum wheels.
 *
 * @author Name: TODO
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class DriveTrain {
    private DCMotor  frontLeft, frontRight, backLeft, backRight;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for DriveTrain.
     *
     * @param frontLeft front left dc motor
     * @param frontRight front right dc motor
     * @param backLeft back left dc motor
     * @param backRight back right dc motor
     */
    public DriveTrain(DCMotor frontLeft, DCMotor frontRight, DCMotor backLeft, DCMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    /**
     * Moves robot forward/backward.
     *
     * @param direction “forward”, “backward”, “left”, “right”, “rotateLeft”, “rotateRight”
     * @param speed 0.0–1.0
     */
    public void drive(String direction, double speed)
    {
        //TODO
    }

    /**
     * Moves robot sideways (“left” or “right”).
     *
     * @param direction “forward”, “backward”, “left”, “right”, “rotateLeft”, “rotateRight”
     * @param speed 0.0–1.0
     */
    public void strafe(String direction, double speed)
    {
        //TODO
    }
}
