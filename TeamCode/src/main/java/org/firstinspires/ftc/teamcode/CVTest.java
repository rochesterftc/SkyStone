package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Nathaniel on 10/9/19.
 */

@Autonomous (name="Computer Vision Test",group="REMOVE BEFORE FLIGHT")
public class CVTest extends LinearOpMode {

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;

    // Declare OpMode members.
    private boolean hellothereFound;  // Sound file present flags

    public void move(double x, double y, double z, int time) {



    }

    boolean opModeTime = true;

    @Override
    public void runOpMode() throws InterruptedException {

        // Determine Resource IDs for sounds built into the RC application.
        int hellothereID = hardwareMap.appContext.getResources().getIdentifier("hellothere", "raw", hardwareMap.appContext.getPackageName());

        // Determine if sound resources are found.
        // Note: Preloading is NOT required, but it's a good way to verify all your sounds are available before you run.
        if (hellothereID != 0)
            hellothereFound = SoundPlayer.getInstance().preload(hardwareMap.appContext, hellothereID);

        fl = hardwareMap.dcMotor.get("front left");
        fr = hardwareMap.dcMotor.get("front right");
        bl = hardwareMap.dcMotor.get("back left");
        br = hardwareMap.dcMotor.get("back right");

        // Display sound status
        telemetry.addData("hellothere", hellothereFound ? "Found" : "NOT FOUND!\n Add hellothere.wav to /src/main/res/raw");

        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, hellothereID);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "initialized!");
        telemetry.addData(">", "Press Start to continue");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {

            if(opModeTime) {

                move(0, 1, 0, 250);

                opModeTime = false;
            }else {
                telemetry.addData("Status", "Robot is stopped");
                telemetry.update();
            }
        }

    }

}