package org.firstinspires.ftc.team3470.Components;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
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
public class FlyWheelShooter implements Component {
    private DcMotor flyWheelMotor1, flyWheelMotor2;
    private Servo angleServo;
    private Servo sidePusherLeft, sidePusherRight;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for FlyWheelShooter.
     *
     * @param hardwareMap Hardware map
     */
    public void init(HardwareMap hardwareMap) {
        this.flyWheelMotor1 = hardwareMap.get(DcMotor.class, "fwMotor1");
        this.flyWheelMotor2 = hardwareMap.get(DcMotor.class, "fwMotor2");
        this.angleServo = hardwareMap.get(Servo.class, "angleServo");
        this.sidePusherLeft = hardwareMap.get(Servo.class, "spLeft");
        this.sidePusherRight = hardwareMap.get(Servo.class, "spRight");
    }

    /**
     * Pushes ball into flywheel and spins it.
     */
    public boolean shootBall(double x1, double y1, double z1, double x2, double y2, double z2, double v0) {
        double angle = getAngle(x1, y1, z1, x2, y2, z2, v0);

        if (angle != Double.MIN_VALUE) {
            adjustAngle(angle);
            feedBall(v0);

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
     * Feeds the next ball into flywheel using side pushers.
     *
     * @param v0 the initial velocity of the ball
     */
    public void feedBall(double v0)
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
