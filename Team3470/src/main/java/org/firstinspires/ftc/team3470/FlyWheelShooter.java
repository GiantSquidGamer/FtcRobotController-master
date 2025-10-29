package org.firstinspires.ftc.team3470;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//TODO Import Statement
//TODO USE REAL PARTS
/**
 * Shoots balls into the goal.
 *
 * @author Name: Raphael Manayon
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: Siddhartha Gopal
 * @version October 25, 2025
 */
public class FlyWheelShooter {
    private DcMotor flyWheelMotor1, flyWheelMotor2;
    private Servo angleServo;
    private Servo sidePusherLeft, sidePusherRight;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for FlyWheelShooter.
     *
     * @param flyWheelMotor1 flywheel dc motor 1
     * @param flyWheelMotor2 flywheel dc motor 2
     * @param angleServo angular shooting servo
     * @param sidePusherLeft left side pusher servo
     * @param sidePusherRight right side pusher servo
     */
    public FlyWheelShooter(DcMotor flyWheelMotor1, DcMotor flyWheelMotor2, Servo angleServo, Servo sidePusherLeft, Servo sidePusherRight) {
        this.flyWheelMotor1 = flyWheelMotor1;
        this.flyWheelMotor2 = flyWheelMotor2;
        this.angleServo = angleServo;
        this.sidePusherLeft = sidePusherLeft;
        this.sidePusherRight = sidePusherRight;
    }

    /**
     * Pushes ball into flywheel and spins it.
     */
    public boolean shootBall(Ball ball, double x1, double y1, double z1, double x2, double y2, double z2, double v0) {
        double angle = getAngle(x1, y1, z1, x2, y2, z2, v0);

        if (angle != Double.MIN_VALUE) {
            adjustAngle(angle);
            feedBall(ball, v0);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves angleServo to set firing angle.
     *
     * @param angle angle of servo in degrees
     */
    public void adjustAngle(double angle) {
        double position = angle/180;
        if (position < 0 || position > 1) {
            return;
        }

        this.angleServo.setPosition(position);
    }

    /**
     * Pushes a ball into flywheel using side pushers.
     *
     * @param ball the ball to be fed
     * @param v0 the initial velocity of the ball
     */
    public void feedBall(Ball ball, double v0)
    {
        // Set flywheel motors at a speed such that the ball is launched at a speed of v0
        // Push ball using pusher servos
        // Return once ball leaves
    }

    /**
     * Calculates the angle needed to shoot the ball at for it to his a target.
     *
     * @param x1 x pos of robot
     * @param y1 y pos of robot
     * @param z1 z pos of robot
     * @param x2 x pos of target
     * @param y2 y pos of target
     * @param z2 z pos of target
     * @param v0 initial velocity of the ball
     * @return angle in degrees to hit the target
     */
    public double getAngle(double x1, double y1, double z1, double x2, double y2, double z2, double v0)
    {
        double deltaX = x2-x1;
        double deltaZ = z2-z1;
        if (deltaX == 0 && deltaZ == 0) {
            return -1;
        }

        double hDistance = Math.sqrt(deltaX*deltaX + deltaZ*deltaZ);
        double yDistance = y2-y1;

        return calculateVerticalLaunchAngle(v0, hDistance, yDistance, 9.807);
    }

    /**
     * Calculates the necessary vertical launch angle for a ball
     *
     * @param v0 Estimated initial velocity of ball
     * @param hDistance Distance from the robot and the goal on the horizontal plane
     * @param deltaY Vertical distance
     * @param g Gravitational acceleration constant
     * @return The launch angle required; or Double.MIN_VALUE if not possible
     */
    private static double calculateVerticalLaunchAngle(double v0, double hDistance, double deltaY, double g) {
        double underSqrt = Math.pow(v0, 4) - g * (g * hDistance * hDistance + 2 * deltaY * v0 * v0);
        if (underSqrt < 0) {
            return Double.MIN_VALUE;
        }
        double sqrtPart = Math.sqrt(underSqrt);
        double angle1 = Math.atan((v0 * v0 + sqrtPart) / (g * hDistance));
        double angle2 = Math.atan((v0 * v0 - sqrtPart) / (g * hDistance));

        return Math.toDegrees(Math.min(angle1, angle2));
    }

}
