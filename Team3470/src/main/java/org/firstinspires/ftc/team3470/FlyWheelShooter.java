package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Shoots balls into the goal.
 *
 * @author Name: TODO
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class FlyWheelShooter {
    private DCMotor flyWheelMotor;
    private Servo angleServo;
    private Servo sidePusherLeft, sidePusherRight;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for FlyWheelShooter.
     *
     * @param flyWheelMotor flywheel dc motor
     * @param angleServo angular shooting servo
     * @param sidePusherLeft left side pusher servo
     * @param sidePusherRight right side pusher servo
     */
    public FlyWheelShooter(DCMotor flyWheelMotor, Servo angleServo, Servo sidePusherLeft, Servo sidePusherRight) {
        this.flyWheelMotor = flyWheelMotor;
        this.angleServo = angleServo;
        this.sidePusherLeft = sidePusherLeft;
        this.sidePusherRight = sidePusherRight;
    }

    /**
     * Pushes ball into flywheel and spins it.
     */
    public void shootBall() {
        //TODO
    }

    /**
     * Moves angleServo to set firing angle.
     *
     * @param angle angle of servo
     */
    public void adjustAngle(double angle) {
        //TODO
    }

    /**
     * Pushes a ball into flywheel using side pushers.
     *
     * @param ball the ball to be fed
     */
    public void feedBall(Ball ball)
    {
        //TODO
    }
}
