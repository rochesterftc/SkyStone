package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by George on 9/27/2019.
 */
@Autonomous(name = "Blue Foundation Park Middle", group = "Competition")

public class BlueFoundParkMiddle extends LinearOpMode {

    MecanumReference ref = new MecanumReference();

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;
    Servo foundr;
    Servo foundl;

    @Override
    public void runOpMode() {

        fl = hardwareMap.dcMotor.get("front left");
        fr = hardwareMap.dcMotor.get("front right");
        bl = hardwareMap.dcMotor.get("back left");
        br = hardwareMap.dcMotor.get("back right");
        foundr = hardwareMap.servo.get("foundation right");
        foundl = hardwareMap.servo.get("foundation left");

        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        //foundation = 34.5 by 18.5
        driveXY(15, 1, "backward");
        driveXY(12, 1, "right");
        driveXY (15, 1, "backward");
        driveXY (7, .25, "backward");
        foundr.setPosition(0);
        foundl.setPosition(1);
        sleep(2000);
        driveXY (52, 1, "forward");
        sleep(100);
        foundr.setPosition(.5);
        foundl.setPosition(0.5);
        sleep(2000);
        driveXY(6, 1, "forward");
        driveXY(24, 1, "left");
        driveXY(30, 1, "backward");
        driveXY (15, 1, "left");
    }

    public void driveXY(float inches, double speed, String direction) {

        //1120 counts per rotation
        //13 inches per rotation
        //86 countsPerInch counts per X inch

        //8 inches per rotation
        //140 counts per Y inch

        float XcountsPerInch = ref.XcountsPerInch;
        float YcountsPerInch = ref.YcountsPerInch;

        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        if (direction == "forward") {
            fr.setTargetPosition(Math.round(inches * XcountsPerInch));
            br.setTargetPosition(Math.round(inches * XcountsPerInch));
            fl.setTargetPosition(-Math.round(inches * XcountsPerInch));
            bl.setTargetPosition(-Math.round(inches * XcountsPerInch));
        }
        if (direction == "backward") {
            fr.setTargetPosition(-Math.round(inches * XcountsPerInch));
            br.setTargetPosition(-Math.round(inches * XcountsPerInch));
            fl.setTargetPosition(Math.round(inches * XcountsPerInch));
            bl.setTargetPosition(Math.round(inches * XcountsPerInch));
        }
        if (direction == "right") {
            fr.setTargetPosition(-Math.round(inches * YcountsPerInch));
            br.setTargetPosition(Math.round(inches * YcountsPerInch));
            fl.setTargetPosition(-Math.round(inches * YcountsPerInch));
            bl.setTargetPosition(Math.round(inches * YcountsPerInch));
        }
        if (direction == "left") {
            fr.setTargetPosition(Math.round(inches * YcountsPerInch));
            br.setTargetPosition(-Math.round(inches * YcountsPerInch));
            fl.setTargetPosition(Math.round(inches * YcountsPerInch));
            bl.setTargetPosition(-Math.round(inches * YcountsPerInch));
        }

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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

        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }

    public void turn(int degrees, double speed, String direction) {

        //1120 counts per rotation
        //60 degrees per rotation
        //18.6 countsPerDegree counts per degree

        float countsPerDegree = ref.countsPerDegree;

        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        if(direction == "left") {
            fr.setTargetPosition(Math.round(degrees * countsPerDegree));
            br.setTargetPosition(Math.round(degrees * countsPerDegree));
            fl.setTargetPosition(Math.round(degrees * countsPerDegree));
            bl.setTargetPosition(Math.round(degrees * countsPerDegree));
        }
        if(direction == "right") {
            fr.setTargetPosition(-Math.round(degrees * countsPerDegree));
            br.setTargetPosition(-Math.round(degrees * countsPerDegree));
            fl.setTargetPosition(-Math.round(degrees * countsPerDegree));
            bl.setTargetPosition(-Math.round(degrees * countsPerDegree));
        }

        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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

        fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }

/*    public void lift (float inches, double speed, String direction) {
        //1120 counts per rotation
        //3 1/4 inches per rotation
        //344.6 counts per inch

        float lCountsPerInch = 140;

        if (direction == "lift") {
            lift.setMode(DcMotor.RunMode.RESET_ENCODERS);

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setTargetPosition(Math.round(299*inches));

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setPower(speed);

            while (lift.isBusy()) {

            }
            lift.setPower(0);
        }

        if (direction == "drop") {
            lift.setMode(DcMotor.RunMode.RESET_ENCODERS);

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setTargetPosition(-Math.round(299*inches));

            lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            lift.setPower(speed);

            while (lift.isBusy()) {

            }
            lift.setPower(0);
        }
    } */
}
