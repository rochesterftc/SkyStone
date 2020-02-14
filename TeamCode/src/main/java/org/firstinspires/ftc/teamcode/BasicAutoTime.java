package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import static java.lang.Thread.sleep;
@Disabled
@Autonomous(name="Basic Auto Time",group="Competition")

public class  BasicAutoTime {

    DcMotor fl;
    DcMotor fr;
    DcMotor bl;
    DcMotor br;

    public void move (double x,double y,double z,int time) {

        fl.setPower(-x-y+z);
        fr.setPower(-x+y+z);
        bl.setPower(x-y+z);
        br.setPower(x+y+z);

        //sleep(50);

        fl.setPower(0);
        fr.setPower(0);
        bl.setPower(0);
        br.setPower(0);



    }

}
