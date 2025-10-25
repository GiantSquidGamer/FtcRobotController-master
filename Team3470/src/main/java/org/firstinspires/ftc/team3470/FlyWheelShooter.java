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
    private DcMotor flyWheelMotor;
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
    public FlyWheelShooter(DcMotor flyWheelMotor, Servo angleServo, Servo sidePusherLeft, Servo sidePusherRight) {
        this.flyWheelMotor = flyWheelMotor;
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

            // Write code here; set flywheel motors at a certain speed given v0
            feedBall(ball);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves angleServo to set firing angle.
     *
     * @param angle angle of servo
     */
    public void adjustAngle(double angle) {
        // Write code here; purpose TBD
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
        double distanceX = x2-x1;
        if (distanceX<0) {
            distanceX=distanceX*-1.0;
        }

        double distanceZ = z2-z1;
        if (distanceZ<0) {
            distanceZ = distanceZ*-1.0;
        }

        if (distanceX == 0 && distanceZ == 0) {
            return -1;
        }

        double angle = AngleUtils.getAngleDegrees(x1, y1, x2, y2);
        double distance = Math.sqrt(distanceX*distanceX + distanceZ*distanceZ);
        double yDistance = y2-y1;

        return calculateLaunchAngle(v0, distance, yDistance, 9.81);
    }

    private static double calculateLaunchAngle(double v0, double distance, double deltaY, double g) {
        double underSqrt = Math.pow(v0, 4) - g * (g * distance * distance + 2 * deltaY * v0 * v0);
        if (underSqrt < 0) {
            return Double.MIN_VALUE;
        }
        double sqrtPart = Math.sqrt(underSqrt);
        double angle1 = Math.atan((v0 * v0 + sqrtPart) / (g * distance));
        double angle2 = Math.atan((v0 * v0 - sqrtPart) / (g * distance));

        return Math.toDegrees(Math.min(angle1, angle2));
    }

}
