package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by George on 9/27/2019.
 */
@Autonomous(name = "Autonomous 1", group = "Competition")

public class Autonomous1 extends LinearOpMode {

    DcMotor RF;
    DcMotor RB;
    DcMotor LF;
    DcMotor LB;


    @Override
    public void runOpMode() {

        RF = hardwareMap.dcMotor.get("right front");
        RB = hardwareMap.dcMotor.get("right back");
        LF = hardwareMap.dcMotor.get("left front");
        LB = hardwareMap.dcMotor.get("left back");

        waitForStart();



    }

    public void driveXY(float inches, double speed, String direction) {

        //1120 counts per rotation
        //8 inches per rotation
        //countsPerInch counts per inch

        float XcountsPerInch = 140;
        float YcountsPerInch = 140;

        if (direction == "forward") {
            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(Math.round(inches * XcountsPerInch));
            RB.setTargetPosition(Math.round(inches * XcountsPerInch));
            LF.setTargetPosition(-Math.round(inches * XcountsPerInch));
            LB.setTargetPosition(-Math.round(inches * XcountsPerInch));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
        }

        if (direction == "backward") {
            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(-Math.round(inches * XcountsPerInch));
            RB.setTargetPosition(-Math.round(inches * XcountsPerInch));
            LF.setTargetPosition(Math.round(inches * XcountsPerInch));
            LB.setTargetPosition(Math.round(inches * XcountsPerInch));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
        }

        if (direction == "left") {
            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(Math.round(inches * YcountsPerInch));
            RB.setTargetPosition(-Math.round(inches * YcountsPerInch));
            LF.setTargetPosition(Math.round(inches * YcountsPerInch));
            LB.setTargetPosition(-Math.round(inches * YcountsPerInch));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
        }

        if (direction == "right") {
            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(-Math.round(inches * YcountsPerInch));
            RB.setTargetPosition(Math.round(inches * YcountsPerInch));
            LF.setTargetPosition(-Math.round(inches * YcountsPerInch));
            LB.setTargetPosition(Math.round(inches * YcountsPerInch));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
        }
    }

    public void turn(int degrees, double speed, String direction) {

        //1120 counts per rotation
        //60 degrees per rotation
        //countsPerDegree66 counts per degree

        int countsPerDegree = 25;

        if(direction == "left") {
            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(Math.round(degrees * countsPerDegree));
            RB.setTargetPosition(Math.round(degrees * countsPerDegree));
            LF.setTargetPosition(Math.round(degrees * countsPerDegree));
            LB.setTargetPosition(Math.round(degrees * countsPerDegree));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
        }
        if(direction == "right") {

            RF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            RB.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LF.setMode(DcMotor.RunMode.RESET_ENCODERS);
            LB.setMode(DcMotor.RunMode.RESET_ENCODERS);

            RF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            RF.setTargetPosition(-Math.round(degrees * countsPerDegree));
            RB.setTargetPosition(-Math.round(degrees * countsPerDegree));
            LF.setTargetPosition(-Math.round(degrees * countsPerDegree));
            LB.setTargetPosition(-Math.round(degrees * countsPerDegree));

            RF.setPower(speed);
            RB.setPower(speed);
            LF.setPower(speed);
            LB.setPower(speed);

            while (RF.isBusy() && RB.isBusy() && LF.isBusy() && LB.isBusy()) {

            }
            RF.setPower(0);
            RB.setPower(0);
            LF.setPower(0);
            LB.setPower(0);
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
