package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by George on 9/27/2019.
 */
@Autonomous(name = "Blue Stone Foundation Park", group = "Competition")

public class BlueStoneFoundPark extends LinearOpMode {

    MecanumReference ref = new MecanumReference();


    @Override
    public void runOpMode() {

        ref.fr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ref.br.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ref.fl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ref.bl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        //foundation = 34.5 by 18.5

        driveXY(27, 1, "right");
        sleep(100);
        ref.stoneArm.setPosition(.5);
        sleep(100);
        driveXY(25, 1, "left");
        sleep(100);
        ref.stoneArm.setPosition(0);
        sleep(100);
        driveXY(18, .25, "backward");
        driveXY(13.5f, .25, "right");
        driveXY(40, 1, "forward");
        driveXY(4, 1, "backward");
        driveXY(20, 1, "left");
        driveXY(27, 1, "forward");
        turn(90, 1, "left");
        driveXY (30, 1, "backward");
        sleep(100);sleep(100);
        ref.foundationRight.setPosition(0);
        ref.foundationLeft.setPosition(1);
        sleep(100);
        driveXY (25, 1, "forward");
        sleep(100);
        ref.foundationRight.setPosition(1);
        ref.foundationLeft.setPosition(0);
        sleep(100);
        driveXY (25, 1, "left");
        driveXY (40, 1, "backward");
        driveXY(25, 1, "right");
        driveXY(18, 1, "forward");
        driveXY (4, 1, "backward");
        driveXY (48, 1, "left");

    }

    public void driveXY(float inches, double speed, String direction) {

        ref.fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        if (direction == "forward") {
            ref.fr.setTargetPosition(Math.round(inches * ref.XcountsPerInch));
            ref.br.setTargetPosition(Math.round(inches * ref.XcountsPerInch));
            ref.fl.setTargetPosition(-Math.round(inches * ref.XcountsPerInch));
            ref.bl.setTargetPosition(-Math.round(inches * ref.XcountsPerInch));
        }
        if (direction == "backward") {
            ref.fr.setTargetPosition(-Math.round(inches * ref.XcountsPerInch));
            ref.br.setTargetPosition(-Math.round(inches * ref.XcountsPerInch));
            ref.fl.setTargetPosition(Math.round(inches * ref.XcountsPerInch));
            ref.bl.setTargetPosition(Math.round(inches * ref.XcountsPerInch));
        }
        if (direction == "right") {
            ref.fr.setTargetPosition(Math.round(inches * ref.YcountsPerInch));
            ref.br.setTargetPosition(-Math.round(inches * ref.YcountsPerInch));
            ref.fl.setTargetPosition(Math.round(inches * ref.YcountsPerInch));
            ref.bl.setTargetPosition(-Math.round(inches * ref.YcountsPerInch));
        }
        if (direction == "left") {
            ref.fr.setTargetPosition(-Math.round(inches * ref.YcountsPerInch));
            ref.br.setTargetPosition(Math.round(inches * ref.YcountsPerInch));
            ref.fl.setTargetPosition(-Math.round(inches * ref.YcountsPerInch));
            ref.bl.setTargetPosition(Math.round(inches * ref.YcountsPerInch));
        }

        ref.fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        ref.fr.setPower(speed);
        ref.br.setPower(speed);
        ref.fl.setPower(speed);
        ref.bl.setPower(speed);

        while (ref.fr.isBusy() && ref.br.isBusy() && ref.fl.isBusy() && ref.bl.isBusy()) {

        }

        ref.fr.setPower(0);
        ref.br.setPower(0);
        ref.fl.setPower(0);
        ref.bl.setPower(0);

        ref.fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
    }

    public void turn(int degrees, double speed, String direction) {



        
        ref.fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.bl.setMode(DcMotor.RunMode.RESET_ENCODERS);

        if(direction == "left") {
            ref.fr.setTargetPosition(Math.round(degrees * ref.countsPerDegree));
            ref.br.setTargetPosition(Math.round(degrees * ref.countsPerDegree));
            ref.fl.setTargetPosition(Math.round(degrees * ref.countsPerDegree));
            ref.bl.setTargetPosition(Math.round(degrees * ref.countsPerDegree));
        }
        if(direction == "right") {
            ref.fr.setTargetPosition(-Math.round(degrees * ref.countsPerDegree));
            ref.br.setTargetPosition(-Math.round(degrees * ref.countsPerDegree));
            ref.fl.setTargetPosition(-Math.round(degrees * ref.countsPerDegree));
            ref.bl.setTargetPosition(-Math.round(degrees * ref.countsPerDegree));
        }

        ref.fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ref.bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        ref.fr.setPower(speed);
        ref.br.setPower(speed);
        ref.fl.setPower(speed);
        ref.bl.setPower(speed);

        while (ref.fr.isBusy() && ref.br.isBusy() && ref.fl.isBusy() && ref.bl.isBusy()) {

        }
        ref.fr.setPower(0);
        ref.br.setPower(0);
        ref.fl.setPower(0);
        ref.bl.setPower(0);

        ref.fr.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.br.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.fl.setMode(DcMotor.RunMode.RESET_ENCODERS);
        ref.bl.setMode(DcMotor.RunMode.RESET_ENCODERS);
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
