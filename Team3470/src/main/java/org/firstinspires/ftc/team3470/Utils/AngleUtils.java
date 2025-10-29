package org.firstinspires.ftc.team3470.Utils;

/**
 * Useful class for calculating angles.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: None
 * @version October 18, 2025
 */

public class AngleUtils {

    /**
     * Gets the angle in degrees between two points (x1, y1) and (x2, y2).
     *
     * @param x1 x position 1
     * @param y1 y position 1
     * @param x2 x position 2
     * @param y2 y position 2
     * @return the angle in degrees between the two points
     */
    public static double getAngleDegrees(double x1, double y1, double x2, double y2) {
        double angleRadians = Math.atan2(y2 - y1, x2 - x1);
        double angleDegrees = Math.toDegrees(angleRadians);

        if (angleDegrees < 0) {
            angleDegrees += 360;
        }
        return angleDegrees;
    }
}
