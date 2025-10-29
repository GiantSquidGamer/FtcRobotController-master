package org.firstinspires.ftc.team3470.Components;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Controls the 4 mecanum wheels.
 *
 * @author Name: Siddhartha Gopal
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: Nikhil Ratakonda, Raphael Manayon
 * @version October 29, 2025
 */
public class DriveTrain implements Component
{
    private DcMotor frontLeft, frontRight, backLeft, backRight;

    /**
     * Constructor for DriveTrain.
     *
     * @param hardwareMap The Hardware Map
     */
    public void init(HardwareMap hardwareMap) {
        this.frontLeft = hardwareMap.get(DcMotor.class, "fl");
        this.frontRight = hardwareMap.get(DcMotor.class, "fr");
        this.backLeft = hardwareMap.get(DcMotor.class, "bl");
        this.backRight = hardwareMap.get(DcMotor.class, "br");
    }

    /**
     * Moves robot forward/backward.
     */
    public void drive() {
        // TODO
    }
}
