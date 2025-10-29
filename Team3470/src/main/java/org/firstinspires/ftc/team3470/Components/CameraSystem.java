package org.firstinspires.ftc.team3470.Components;

//TODO Import Statement
//TODO USE REAL PARTS

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagLibrary;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import android.util.Size;

/**
 * Handles vision tasks, like detecting and decoding QR codes or AprilTags.
 *
 * @author Name: Mr. President
 * @author Team: 3470
 * @author Robot: LeBot
 * @author Sources/Contributors: None (Built by the president with his bare hands)
 * @version October 25, 2025
 */
public class CameraSystem implements Component {
    private AprilTagProcessor tagProcessor;
    private VisionPortal visionPortal;

    /**
     * Initialize the CameraSystem
     * @param hardwareMap the Hardware map
     */

   public void init(HardwareMap hardwareMap) {
       this.tagProcessor = new AprilTagProcessor.Builder()
               .setDrawAxes(true)
               .setDrawCubeProjection(true)
               .setDrawTagID(true)
               .setDrawTagOutline(true)
               .build();

        this.visionPortal = new VisionPortal.Builder()
                .addProcessor(this.tagProcessor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
                .setCameraResolution(new Size(640, 480))
                .build();
   }

    /**
     * Get the X coordinate of a tag
     * @param id The ID of the desired tag
     * @return The X coordinate of the desired tag
     */
   public double getTagXCoordinate(int id) {
       return getTagCoordinate("X", id);
   }

    /**
     * Get the Y coordinate of a tag
     * @param id The ID of the desired tag
     * @return The Y coordinate of the desired tag
     */
    public double getTagYCoordinate(int id) {
        return getTagCoordinate("Y", id);
    }

    /**
     * Get the Z coordinate of a tag
     * @param id The ID of the desired tag
     * @return The Z coordinate of the desired tag
     */
    public double getTagZCoordinate(int id) {
        return getTagCoordinate("Z", id);
    }

    /**
     * Get any one coordinate of a tag
     * @param coordType The desired coordinate
     * @param id The ID of the desired tag
     * @return The desired coordinate of the desired tag
     */
   private double getTagCoordinate(String coordType, int id) {
       int detectionSize = tagProcessor.getDetections().size();

        if (detectionSize <= 0) {
            return Double.MIN_VALUE;
        }

        AprilTagDetection tag = null;

        for (int i = 0; i < detectionSize; i++) {
            if (tagProcessor.getDetections().get(0).id == id) {
                tag = tagProcessor.getDetections().get(0);
            }
        }

        if (tag == null) {
            return Double.MIN_VALUE;
        }

       switch (coordType.toUpperCase()) {
           case "X":
               return tag.ftcPose.x;
           case "Y":
               return tag.ftcPose.y;
           case "Z":
               return tag.ftcPose.z;
           default:
               return Double.MIN_VALUE;
       }
   }
}


