package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by George on 10/11/2018.
 */

@TeleOp(name ="Dual Stick Tank Drive",group="Competition")


public class TeleOp1 extends OpMode {

    /*    DcMotor RF;
        DcMotor RB;
        DcMotor LF;
        DcMotor LB; */
    DcMotor RP;
    DcMotor LP;

    public void init() {

/*        RF = hardwareMap.dcMotor.get("right front");
        RB = hardwareMap.dcMotor.get("right back");
        LF = hardwareMap.dcMotor.get("left front");
        LB = hardwareMap.dcMotor.get("left back"); */
        RP = hardwareMap.dcMotor.get("right puller");
        LP = hardwareMap.dcMotor.get("left puller");
    }

    public void loop() {

        /*float leftPower = gamepad1.left_stick_y;
        float rightPower = -gamepad1.right_stick_y;
        float liftPower = gamepad2.right_stick_y;
        left.setPower(leftPower);
        right.setPower(rightPower);
        lift.setPower(liftPower); */

        if (gamepad2.right_bumper) {
            RP.setPower(1);
            LP.setPower(-1);
        }
        if (gamepad2.left_bumper) {
            RP.setPower(-1);
            LP.setPower(1);
        }
    }
}