package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import android.graphics.Picture;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.sfdev.assembly.state.StateMachine;
import com.sfdev.assembly.state.StateMachineBuilder;
import org.firstinspires.ftc.teamcode.contants;
import org.firstinspires.ftc.teamcode.FUNCTIONS;
import org.firstinspires.ftc.teamcode.FUNCTIONS;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
public class AUTONFUNCTIONS {
    FUNCTIONS funct = new FUNCTIONS();
    contants cont = new contants();
    public enum outtake
    {
        INIT,
        SPECPREP,
        SPECSCORE,
        PICKUP,
    }
    public Action INIT () {
        return new Action() {
            ElapsedTime init = new ElapsedTime();

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
               funct.init();
               funct.INTINIT();
                return init.milliseconds()<100; //Returns true as long as less than 100 milliseconds have passed.

            }
        };
    }
    public Action pikcupprep () {
        return new InstantAction(() -> {
            funct.pickup();
        });
    }
    public Action PICKUP () {
        return new Action() {
            ElapsedTime Pickup = new ElapsedTime();

            @Override
            public boolean run (@NonNull TelemetryPacket telemetryPacket) {
                funct.pickup();
                Pickup.reset();
                if (Pickup.milliseconds() > 200) { //change
                    funct.OUTclaw.setPosition(contants.Outtake.Claw.CLOSE);
                    funct.OUTelbow.setPosition(contants.Outtake.Elbow.SPECPREP);
                    funct.OUTwrist.setPosition(contants.Outtake.Wrist.SPECPREP);
                    funct.shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECPREP);
                    funct.shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECPREP);
                }
                return Pickup.milliseconds() < 100; //obvi need to change
            }

        };
    }
    public Action SCORE () {
        return new Action() {
            ElapsedTime SCORE = new ElapsedTime();
            ElapsedTime Claw = new ElapsedTime();


            @Override
            public boolean run (@NonNull TelemetryPacket telemetryPacket) {
                funct.OUTelbow.setPosition(contants.Outtake.Elbow.SPECSCORE);
                funct.OUTwrist.setPosition(contants.Outtake.Wrist.SPECSCORE);
                funct.shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECSCORE);
                funct.shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECSCORE);
                SCORE.reset();
                if (SCORE.milliseconds() > 200) { // change
                    funct.OUTclaw.setPosition(contants.Outtake.Claw.CLOSE);
                    funct.OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
                    funct.OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
                    funct.shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
                    funct.shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);
                }
                else if (Claw.milliseconds() > 200) {
                    funct.OUTclaw.setPosition(contants.Outtake.Claw.OPEN);

                }
                return SCORE.milliseconds() < 100; //obvi need to change
            }

        };
    }

}
