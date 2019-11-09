package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by George on 9/27/2019.
 */
@Autonomous(name = "Autonomous Test", group = "Testing")

public class AutonomousTest extends LinearOpMode {

    DcMotor fr;
    DcMotor fl;
    DcMotor br;
    DcMotor bl;
    DcMotor arm;
    Servo foundr;
    Servo foundl;
    Servo armLock;

    @Override
    public void runOpMode() {

        fr = hardwareMap.dcMotor.get("front right");
        fl = hardwareMap.dcMotor.get("front left");
        br = hardwareMap.dcMotor.get("back right");
        bl = hardwareMap.dcMotor.get("back left");
        arm = hardwareMap.dcMotor.get("arm");
        foundr = hardwareMap.servo.get("foundation right");
        foundl = hardwareMap.servo.get("foundation left");
        armLock = hardwareMap.servo.get("arm lock");

        waitForStart();

        arm.setMode(DcMotor.RunMode.RESET_ENCODERS);
        arm.setPower(.75);
        armLock.setPosition(.175);
        arm.getCurrentPosition();
        if (arm.getCurrentPosition() >150) {
            arm.setPower(0);
            arm.setMode(DcMotor.RunMode.RESET_ENCODERS);
        }

    }

    public void driveXY(float inches, double speed, String direction) {

        //1120 counts per rotation
        //8 inches per rotation
        //countsPerInch counts per inch

        float XcountsPerInch = 140;
        float YcountsPerInch = 140;

        if (direction == "forward") {
            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(Math.round(inches * XcountsPerInch));
            br.setTargetPosition(Math.round(inches * XcountsPerInch));
            fl.setTargetPosition(-Math.round(inches * XcountsPerInch));
            bl.setTargetPosition(-Math.round(inches * XcountsPerInch));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }

        if (direction == "backward") {
            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(-Math.round(inches * XcountsPerInch));
            br.setTargetPosition(-Math.round(inches * XcountsPerInch));
            fl.setTargetPosition(Math.round(inches * XcountsPerInch));
            bl.setTargetPosition(Math.round(inches * XcountsPerInch));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }

        if (direction == "left") {
            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(Math.round(inches * YcountsPerInch));
            br.setTargetPosition(-Math.round(inches * YcountsPerInch));
            fl.setTargetPosition(Math.round(inches * YcountsPerInch));
            bl.setTargetPosition(-Math.round(inches * YcountsPerInch));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }

        if (direction == "right") {
            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(-Math.round(inches * YcountsPerInch));
            br.setTargetPosition(Math.round(inches * YcountsPerInch));
            fl.setTargetPosition(-Math.round(inches * YcountsPerInch));
            bl.setTargetPosition(Math.round(inches * YcountsPerInch));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }
    }

    public void turn(int degrees, double speed, String direction) {

        //1120 counts per rotation
        //60 degrees per rotation
        //countsPerDegree66 counts per degree

        int countsPerDegree = 25;

        if(direction == "left") {
            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(Math.round(degrees * countsPerDegree));
            br.setTargetPosition(Math.round(degrees * countsPerDegree));
            fl.setTargetPosition(Math.round(degrees * countsPerDegree));
            bl.setTargetPosition(Math.round(degrees * countsPerDegree));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }
        if(direction == "right") {

            fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
            br.setMode(DcMotor.RunMode.RESET_ENCODERS);
            fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
            bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

            fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            fr.setTargetPosition(-Math.round(degrees * countsPerDegree));
            br.setTargetPosition(-Math.round(degrees * countsPerDegree));
            fl.setTargetPosition(-Math.round(degrees * countsPerDegree));
            bl.setTargetPosition(-Math.round(degrees * countsPerDegree));

            fr.setPower(speed);
            br.setPower(speed);
            fl.setPower(speed);
            bl.setPower(speed);

            while (fr.isBusy() && br.isBusy() && fl.isBusy() && bl.isBusy()) {

            }
            fr.setPower(0);
            br.setPower(0);
            fl.setPower(0);
            bl.setPower(0);
        }
    }

/*    public void lift (float inches, double speed, String direction) {
        //1120 counts per rotation
        //3 1/4 inches per rotation
        //344.6 counts per inch

        float lCountsPerInch = 140;

        if (direction == "lift") {
            lift.setMode(DcMotor.RunMode.RESET_ENCODERS);

            lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            lift.setTargetPosition(Math.round(299*inches));

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setPower(speed);

            while (lift.isBusy()) {

            }
            lift.setPower(0);
        }

        if (direction == "drop") {
            lift.setMode(DcMotor.RunMode.RESET_ENCODERS);

            lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            lift.setTargetPosition(-Math.round(299*inches));

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setPower(speed);

            while (lift.isBusy()) {

            }
            lift.setPower(0);
        }
    } */
}
