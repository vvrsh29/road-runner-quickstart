package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.contants;
public class FUNCTIONS {
    //OUTTAKE
    public Servo shoulderL = hardwareMap.get(Servo.class, "OShoulL");
    public Servo shoulderR = hardwareMap.get(Servo.class, "OShoulR");
    public Servo OUTelbow = hardwareMap.get(Servo.class, "OElbow");
    public Servo OUTwrist = hardwareMap.get(Servo.class, "OWrist");
    public Servo OUTclaw = hardwareMap.get(Servo.class, "OClaw");

    //INTAKE
    Servo claw = hardwareMap.get(Servo.class, "claw");
    Servo wrist = hardwareMap.get(Servo.class, "wrist");
    Servo shoulder = hardwareMap.get(Servo.class, "shoulder");
    Servo elbow = hardwareMap.get(Servo.class, "elbow");
    Servo SL = hardwareMap.get(Servo.class, "SL");
    Servo SR = hardwareMap.get(Servo.class, "SR");

    //OUTTAKE
    public void init() {
        OUTclaw.setPosition(contants.Outtake.Claw.INIT);
        OUTelbow.setPosition(contants.Outtake.Elbow.INIT);
        OUTwrist.setPosition(contants.Outtake.Wrist.INIT);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.INIT);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.INIT);
    }
    public void pickup() {
        OUTclaw.setPosition(contants.Outtake.Claw.PICKUP);
        OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
        OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);

//        public void PICKUP() {
//            ElapsedTime timer = new ElapsedTime();
//
//            // Step 1: Close the claw
//            OUTclaw.setPosition(contants.Outtake.Claw.PICKUP);
//            timer.reset();
//            if (timer.milliseconds() > 200) {
//                OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
//                OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
//                shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
//                shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);
//            }
//        }
    }
    public void SPECPREP() {
        OUTclaw.setPosition(contants.Outtake.Claw.SPECPREP);
        OUTelbow.setPosition(contants.Outtake.Elbow.SPECPREP);
        OUTwrist.setPosition(contants.Outtake.Wrist.SPECPREP);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECPREP);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECPREP);
    }
    public void SAMPPREP() {
        OUTclaw.setPosition(contants.Outtake.Claw.SAMPPREP);
        OUTelbow.setPosition(contants.Outtake.Elbow.SAMPPREP);
        OUTwrist.setPosition(contants.Outtake.Wrist.SAMPPREP);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPPREP);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPPREP);
    }
    public void TRANSFER() {
        OUTclaw.setPosition(contants.Outtake.Claw.TRANSFER1);
        OUTelbow.setPosition(contants.Outtake.Elbow.TRANSFER);
        OUTwrist.setPosition(contants.Outtake.Wrist.TRANSFER);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.TRANSFER);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.TRANSFER);
    }
    public void SAMPSCORE() {
        OUTclaw.setPosition(contants.Outtake.Claw.SAMPSCORE);
        OUTelbow.setPosition(contants.Outtake.Elbow.SAMPSCORE);
        OUTwrist.setPosition(contants.Outtake.Wrist.SAMPSCORE);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPSCORE);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPSCORE);
    }
    public void SPECSCORE() {
        OUTclaw.setPosition(contants.Outtake.Claw.SPECSCORE);
        OUTelbow.setPosition(contants.Outtake.Elbow.SPECSCORE);
        OUTwrist.setPosition(contants.Outtake.Wrist.SPECSCORE);
        shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECSCORE);
        shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECSCORE);
    }

    //INTAKE
    public void INTINIT() {
        claw.setPosition(contants.Intake.Claw.INIT);
        elbow.setPosition(contants.Intake.Elbow.INIT);
        wrist.setPosition(contants.Intake.Wrist.INIT);
        shoulder.setPosition(contants.Intake.Shoulder.INIT);
        SL.setPosition(contants.Intake.SlidesLeft.INIT);
        SR.setPosition(contants.Intake.SlidesLeft.INIT);
    }
    public void PICKUPPREP() {
        claw.setPosition(contants.Intake.Claw.PICKUPPREP);
        elbow.setPosition(contants.Intake.Elbow.PICKUPPREP);
        wrist.setPosition(contants.Intake.Wrist.PICKUPPREP);
        shoulder.setPosition(contants.Intake.Shoulder.PICKUPPREP);
        SL.setPosition(contants.Intake.SlidesLeft.PICKUPPREP);
        SR.setPosition(contants.Intake.SlidesRight.PICKUPPREP);
    }
    public void PICKUP() {
        claw.setPosition(contants.Intake.Claw.PICKUP);
        elbow.setPosition(contants.Intake.Elbow.PICKUP);
        wrist.setPosition(contants.Intake.Wrist.PICKUP);
        shoulder.setPosition(contants.Intake.Shoulder.PICKUP);
        SL.setPosition(contants.Intake.SlidesLeft.PICKUP);
        SR.setPosition(contants.Intake.SlidesRight.PICKUP);

    }


    public void RETRACT() {
        claw.setPosition(contants.Intake.Claw.RETRACT);
        elbow.setPosition(contants.Intake.Elbow.RETRACT);
        wrist.setPosition(contants.Intake.Wrist.RETRACT);
        shoulder.setPosition(contants.Intake.Shoulder.RETRACT);
        SL.setPosition(contants.Intake.SlidesLeft.RETRACT);
        SR.setPosition(contants.Intake.SlidesRight.RETRACT);
    }
    public void TRANSFER1() {
        claw.setPosition(contants.Intake.Claw.TRANSFER1);
        elbow.setPosition(contants.Intake.Elbow.TRANSFER1);
        wrist.setPosition(contants.Intake.Wrist.TRANSFER1);
        shoulder.setPosition(contants.Intake.Shoulder.TRANSFER1);
        SL.setPosition(contants.Intake.SlidesLeft.TRANSFER1);
        SR.setPosition(contants.Intake.SlidesRight.TRANSFER1);
    }
    public void TRANSFER2() {
        claw.setPosition(contants.Intake.Claw.TRANSFER2);

    }

}
