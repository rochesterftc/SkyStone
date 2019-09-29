package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by George on 10/11/2018.
 */

@TeleOp(name ="Dual Stick Tank Drive",group="Competition")


public class TeleOpTest1 extends OpMode {

    DcMotor fr;
    DcMotor br;
    DcMotor fl;
    DcMotor bl;
    DcMotor rp;
    DcMotor lp;

    public void init() {

        fr = hardwareMap.dcMotor.get("right front");
        br = hardwareMap.dcMotor.get("right back");
        fl = hardwareMap.dcMotor.get("left front");
        bl = hardwareMap.dcMotor.get("left back");
        rp = hardwareMap.dcMotor.get("right puller");
        lp = hardwareMap.dcMotor.get("left puller");
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
        if (gamepad1.a) {
            fl.setPower((-y - x + z) / 5);
            bl.setPower((-y + x + z) / 5);
            fr.setPower((-y - x - z) / 5);
            br.setPower((-y + x - z) / 5);
        } else {
            fl.setPower(-y - x + z);
            bl.setPower(-y + x + z);
            fr.setPower(-y - x - z);
            br.setPower(-y + x - z);
        }

        if (gamepad2.right_bumper) {
            rp.setPower(1);
            lp.setPower(-1);
        }
        if (gamepad2.left_bumper) {
            rp.setPower(-1);
            lp.setPower(1);
        }
    }
}