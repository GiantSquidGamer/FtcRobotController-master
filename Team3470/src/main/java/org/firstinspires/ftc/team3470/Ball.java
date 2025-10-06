package org.firstinspires.ftc.team3470;

//TODO Import Statement

/**
 * Acts as a representation of a ball.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: None
 * @version October 5, 2025
 */
public class Ball {
    private String color;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Gives the ball a color.
     *
     * @param color purple or green
     */
    public Ball(String color) {
        this.color = color;
    }

    /**
     * Returns the color of the ball.
     *
     * @return the ball's color
     */
    public String getColor() {
        return color;
    }
}
