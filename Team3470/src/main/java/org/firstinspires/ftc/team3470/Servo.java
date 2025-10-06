package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Represents any servo on the robot.
 *
 * @author Name: TODO
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class Servo {
    private double position;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for Servo.
     *
     * @param position servo angle (0–1 or 0–180 depending on implementation)
     */
    public Servo(double position) {
        this.position = position;
    }

    /**
     * Sets servo angle (0–1 or 0–180 depending on implementation)
     *
     * @param position angle we set the servo to
     */
    public void setPosition(double position) {
        this.position = position;
    }
}
