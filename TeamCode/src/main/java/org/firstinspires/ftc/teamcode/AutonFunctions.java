package org.firstinspires.ftc.teamcode.libs;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.InstantAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class AutonFunctions extends LinearOpMode {
    public Functions bot;
    public double x;
    public double y;
    public double heading;

    public void initFunctions() {
        bot = new Functions(hardwareMap);
        bot.init();
    }

    public Action scorePrep () {
        return new Action() {
            ElapsedTime scoreprep = new ElapsedTime();

            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                bot.outtake.clawClose();
                bot.outtake.elbowScorePrep();
                bot.outtake.shoulderScorePrep();
                bot.outtake.wristScorePrep();

                return scoreprep.milliseconds()<500; // Change 500 to a larger number if you want it to wait for longer
            }
        };
    }
