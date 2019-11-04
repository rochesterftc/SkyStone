package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.SoundPlayer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Rochesterftc10303 on 10/4/2018.
 */

@TeleOp(name="Competition",group="Master")

public class
CompetitionTeleOp extends OpMode {

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;
    DcMotor arm;
    CRServo wrist;
    Servo clamp;
    int slowModeModifier = 5;
    double wristPower;
    boolean clampButtonPushed;
    boolean clampOn;
    boolean slowButtonPushed;
    boolean slowMode;

    // Declare OpMode members.
    private boolean helloThereFound;      // Sound file present flag

    public void init() {
        // Test Branch
        // Determine Resource IDs for sounds built into the RC application.
        int helloThereID = hardwareMap.appContext.getResources().getIdentifier("hellothere", "raw", hardwareMap.appContext.getPackageName());

        // Determine if sound resources are found.
        // Note: Preloading is NOT required, but it's a good way to verify all your sounds are available before you run.
        if (helloThereID != 0) {
            helloThereFound = SoundPlayer.getInstance().preload(hardwareMap.appContext, helloThereID);
        }

        fl = hardwareMap.dcMotor.get("front left");
        fr = hardwareMap.dcMotor.get("front right");
        bl = hardwareMap.dcMotor.get("back left");
        br = hardwareMap.dcMotor.get("back right");
        arm = hardwareMap.dcMotor.get("arm");
        wrist = hardwareMap.crservo.get("wrist");
        clamp = hardwareMap.servo.get("clamp");
        clampButtonPushed = false;
        clampOn = false;
        slowButtonPushed = false;
        slowMode = false;

        //LeftRL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //RightRL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //RightRL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //LeftRL.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Display sound status
        telemetry.addData("hellothere resource",   helloThereFound ?   "Found" : "NOT found\n Add hellothere.wav to /src/main/res/raw" );
        telemetry.addData("Status", "Init complete! Press Start to Continue");
        telemetry.update();

        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, helloThereID);

    }

    public void loop() {

        //floats to streamline drive code
        float x = gamepad1.left_stick_x;
        float z = -gamepad1.left_stick_y;
        float y = gamepad1.right_stick_x;

        /*
        Holonomic Drive:
        Gamepad 1 left and right sticks control the robot main movement, holding down a moves 5x slower
         */

        if(gamepad1.a && !slowButtonPushed) {
            slowMode = !slowMode;
            slowButtonPushed = true;
        } else if(!gamepad1.a && slowButtonPushed) slowButtonPushed = false;

        if (slowMode) {
            fl.setPower((-y - x + z) / slowModeModifier);
            bl.setPower((-y + x + z) / slowModeModifier);
            fr.setPower((-y - x - z) / slowModeModifier);
            br.setPower((-y + x - z) / slowModeModifier);
            telemetry.addData("Slow Mode","On with factor of "+slowModeModifier);
        } else {
            fl.setPower(-y - x + z);
            bl.setPower(-y + x + z);
            fr.setPower(-y - x - z);
            br.setPower(-y + x - z);
            telemetry.addData("Slow Mode","Off");

        }

        arm.setPower(gamepad1.right_stick_y);

        wristPower = gamepad1.left_trigger - gamepad1.right_trigger;
        wrist.setPower(wristPower);

        /*float targetPosition = gamepad1.right_stick_y;
        int intTargetPosition = (int) targetPosition * 200;

        arm.setTargetPosition(arm.getCurrentPosition()+(intTargetPosition));
        if (gamepad1.right_stick_y > 0) {
            arm.setPower(.7);
        } else if (gamepad1.right_stick_y < 0) {
            arm.setPower(-0.7);
        } */
               if(gamepad2.a && !clampButtonPushed) {
            clamp.setPosition((clampOn ? 1 : 0));
           clampOn = !clampOn;
           clampButtonPushed = true;
        } else if(!gamepad2.a && clampButtonPushed) clampButtonPushed = false;

        telemetry.update();
    }
}