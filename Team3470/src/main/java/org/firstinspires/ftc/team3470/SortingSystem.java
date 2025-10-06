package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Handles picking up and sorting balls by color.
 *
 * @author Name: TODO
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class SortingSystem {
	private DCMotor intakeRoller;
    private Servo liftTrack;
    private ColorSensor colorSensor;
    private Servo torqueServoPusher;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for SortingSystem.
     *
     * @param intakeRoller intake roller motor
     * @param liftTrack lift track servo
     * @param colorSensor REV color sensor
     * @param torqueServoPusher torque servo for pushing balls
     */
    public SortingSystem(DCMotor intakeRoller, Servo liftTrack, ColorSensor colorSensor, Servo torqueServoPusher) {
        this.intakeRoller = intakeRoller;
        this.liftTrack = liftTrack;
        this.colorSensor = colorSensor;
        this.torqueServoPusher = torqueServoPusher;
    }

    /**
     * Activates intake roller and lift track.
     */
    public void pickUpBall() {
        //TODO
    }

    /**
     * Reads the color sensor.
     *
     * @return "purple" or "green"
     */
    public String detectColor() {
        //TODO
        return null;
    }

    /**
     * Uses torqueServoPusher to route ball based on detected color.
     */
    public void sortBall()
    {
        //TODO
    }

}
