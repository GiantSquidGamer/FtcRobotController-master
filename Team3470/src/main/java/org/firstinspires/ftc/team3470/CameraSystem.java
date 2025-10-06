package org.firstinspires.ftc.team3470;

//TODO Import Statement

import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.firstinspires.ftc.robotcore.external.navigation.Position;

/**
 * Handles vision tasks, like detecting and decoding QR codes or AprilTags.
 *
 * @author Name: TODO
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: TODO
 * @version October 5, 2025
 */
public class CameraSystem {

    private Camera camera;

    //TODO
//    VisionPipeline pipeline;

    //TODO Fix constructor after real parts are implemented, have objects have orignal properties
    /**
     * Constructor for Camera.
     *
     * @param camera the camera object
     */
    public CameraSystem(Camera camera) {
        this.camera = camera;
    }

    /**
     * Sets up the camera for use.
     */
    public void initializeCamera() {
        //TODO
    }

    /**
     * Begins camera feed.
     */
    public void startStreaming() {
        //TODO
    }

    /**
     * Stops camera feed.
     */
    public void stopStreaming() {
        //TODO
    }

    /**
     * Processes curent frame.
     *
     * @return decoded QR code or null if none found
     */
    public String readQRCode() {
        //TODO
        return null;
    }

    /**
     * Returns coordinates of detected object.
     *
     * @return Position object with coordinates or null if none found.
     */
    public Position getTargetPosition() {
        return null;
    }

}


