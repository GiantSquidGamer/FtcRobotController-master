package org.firstinspires.ftc.team3470;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Controls the 4 mecanum wheels.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: Nikhil
 * @version October 5, 2025
 */
public class DriveTrain {
    private DcMotor  frontLeft, frontRight, backLeft, backRight;

    /**
     * Constructor for DriveTrain.
     *
     * @param frontLeft front left dc motor
     * @param frontRight front right dc motor
     * @param backLeft back left dc motor
     * @param backRight back right dc motor
     */
    public DriveTrain(DcMotor frontLeft, DcMotor frontRight, DcMotor backLeft, DcMotor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
    }

    /**
     * Moves robot forward/backward.
     */
    public void drive() {
        double vertical = 0;
        double horizontal = 0;
        double pivot = 0;
        vertical = -gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;

        frontRight.setPower(pivot + (-vertical + horizontal));
        backRight.setPower(pivot + (-vertical - horizontal));
        frontLeft.setPower(pivot + (-vertical - horizontal));
        backLeft.setPower(pivot + (-vertical + horizontal));

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
