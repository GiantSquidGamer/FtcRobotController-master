package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Represents any DC motor on the robot.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class DCMotor {
    private double power;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for DCMotor.
     *
     * @param power power of the motor
     */
    public DCMotor(double power) {
        this.power = power;
    }

    /**
     * Sets power of the motor.
     *
     * @param power power of the motor
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * Stops the motor.
     */
    public void stop() {
        this.power = 0.0;
    }
}
