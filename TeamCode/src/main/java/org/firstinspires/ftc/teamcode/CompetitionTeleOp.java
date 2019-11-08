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
    Servo lock;
    Servo foundationLeft;
    Servo foundationRight;
    Servo stoneArm;
    int slowModeModifier = 5;
    double wristPower;
    boolean clampButtonPushed;
    boolean clampOn;
    boolean slowButtonPushed;
    boolean slowMode;
    boolean lockButtonPushed;
    boolean lockOn;
    boolean foundationButtonPushed;
    boolean foundationOn;
    boolean stoneArmButtonPushed;
    boolean stoneArmOn;
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
        lock = hardwareMap.servo.get("lock");
        foundationLeft = hardwareMap.servo.get("foundation left");
        foundationRight = hardwareMap.servo.get("foundation right");
        stoneArm = hardwareMap.servo.get("stone arm");
        clampButtonPushed = false;
        clampOn = false;
        slowButtonPushed = false;
        slowMode = false;

        /*arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // Don't remember if next line is needed.  I believe setTargetPosition is inited to zero so probably not needed
        arm.setTargetPosition(0);
        arm.setPower(0.7); //set to the max speed you want the arm to move at*/

        // Display sound status
        telemetry.addData("hellothere resource",   helloThereFound ?   "Found" : "NOT found\n Add hellothere.wav to /src/main/res/raw" );
        telemetry.addData("Status", "Init complete! Press Start to Continue");
        telemetry.update();

        SoundPlayer.getInstance().startPlaying(hardwareMap.appContext, helloThereID);

    }

    public void loop() {

        //floats to streamline drive code
        float x = gamepad1.left_stick_x;
        float z = gamepad1.right_stick_x;
        float y = gamepad1.left_stick_y;

        /*
        Holonomic Drive:
        Gamepad 1 left and right sticks control the robot main movement, holding down a moves 5x slower
         */

        if(gamepad1.a && !slowButtonPushed) {
            slowMode = !slowMode;
            slowButtonPushed = true;
        } else if(!gamepad1.a && slowButtonPushed) slowButtonPushed = false;

        if (slowMode) {
            fl.setPower((y - x - z) / slowModeModifier);
            fr.setPower((-y - x - z) / slowModeModifier);
            bl.setPower((y + x - z) / slowModeModifier);
            br.setPower((-y + x - z) / slowModeModifier);
            telemetry.addData("Slow Mode","On with factor of "+slowModeModifier);
        } else {
            fl.setPower(y - x - z);
            fr.setPower(-y - x - z);
            bl.setPower(y + x - z);
            br.setPower(-y + x - z);
            telemetry.addData("Slow Mode","Off");

        }

        arm.setPower(-gamepad2.right_stick_y);

        wristPower = gamepad2.left_trigger - gamepad2.right_trigger;
        wrist.setPower(wristPower);

        /*float targetPosition = gamepad1.right_stick_y;
        int intTargetPosition = (int) targetPosition * 200;

        arm.setTargetPosition(arm.getCurrentPosition()+(intTargetPosition));
        if (gamepad1.right_stick_y > 0) {
            arm.setPower(.7);
        } else if (gamepad1.right_stick_y < 0) {
            arm.setPower(-0.7);
        } */

        //Clamp control
               if(gamepad2.a && !clampButtonPushed) {
            clamp.setPosition((clampOn ? 1 : 0));
           clampOn = !clampOn;
           clampButtonPushed = true;
        } else if(!gamepad2.a && clampButtonPushed) clampButtonPushed = false;

        //lock control
        if(gamepad2.b && !lockButtonPushed) {
            lock.setPosition((lockOn ? 0 : 0.0625));
            lockOn = !lockOn;
            lockButtonPushed = true;
        } else if(!gamepad2.b && lockButtonPushed) lockButtonPushed = false;

        //foundation control
        if(gamepad2.x && !foundationButtonPushed) {
            foundationLeft.setPosition((foundationOn ? 0.9 : 0.4));
            foundationRight.setPosition((foundationOn ? 0 : 0.5));
            foundationOn = !foundationOn;
            foundationButtonPushed = true;
        } else if(!gamepad2.x && foundationButtonPushed) foundationButtonPushed = false;
        telemetry.addData("Foundation Left",foundationLeft.getPosition());
        telemetry.addData("Foundation Right",foundationRight.getPosition());

        //Stone Arm control
        if(gamepad2.y && !stoneArmButtonPushed) {
            stoneArm.setPosition((stoneArmOn ? 0 : 1));
            stoneArmOn = !stoneArmOn;
            stoneArmButtonPushed = true;
        } else if(!gamepad2.y && stoneArmButtonPushed) stoneArmButtonPushed = false;

        telemetry.update();
    }
}