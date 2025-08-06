package org.firstinspires.ftc.teamcode.teleops;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.Teleop;
import org.firstinspires.ftc.teamcode.contants;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.sfdev.assembly.state.StateMachine;
import com.sfdev.assembly.state.StateMachineBuilder;

@Config
@Autonomous(name = "BLUE_TEST_AUTO_PIXEL", group = "Autonomous")
public static class BlueSideTestAuto extends LinearOpMode {
    public Servo shoulderL = hardwareMap.get(Servo.class, "OShoulL");
    public Servo shoulderR = hardwareMap.get(Servo.class, "OShoulR");
    public Servo OUTelbow = hardwareMap.get(Servo.class, "OElbow");
    public Servo OUTwrist = hardwareMap.get(Servo.class, "OWrist");
    public Servo OUTclaw = hardwareMap.get(Servo.class, "OClaw");
    enum outtake
    {
        INIT,
        SPECPREP,
        SAMPPREP,
        SPECSCORE,
        SAMPSCORE,
        PICKUP,
        TRANSFER
    }

        public class LiftUp implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                StateMachine Outtake = new StateMachineBuilder()
                        .state(Teleop.outtake.INIT)// first has to be INIT?
                        .onEnter(()->{
                            OUTclaw.setPosition(contants.Outtake.Claw.INIT);
                            OUTelbow.setPosition(contants.Outtake.Elbow.INIT);
                            OUTwrist.setPosition(contants.Outtake.Wrist.INIT);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.INIT);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.INIT);
                            System.out.println("Frist");

                        })
                        .transition(()-> gamepad1.a)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.PICKUP)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.PICKUP);
                            OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
                            OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);
                        })
                        .transition(()-> gamepad1.b)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.SPECPREP)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.SPECPREP);
                            OUTelbow.setPosition(contants.Outtake.Elbow.SPECPREP);
                            OUTwrist.setPosition(contants.Outtake.Wrist.SPECPREP);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECPREP);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECPREP);
                        })
                        .transition(()-> gamepad1.x)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.SAMPPREP)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.SAMPPREP);
                            OUTelbow.setPosition(contants.Outtake.Elbow.SAMPPREP);
                            OUTwrist.setPosition(contants.Outtake.Wrist.SAMPPREP);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPPREP);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPPREP);
                        })
                        .transition(()-> gamepad1.y)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.TRANSFER)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.TRANSFER1);
                            OUTelbow.setPosition(contants.Outtake.Elbow.TRANSFER);
                            OUTwrist.setPosition(contants.Outtake.Wrist.TRANSFER);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.TRANSFER);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.TRANSFER);
                        })
                        .transition(()-> gamepad1.right_bumper)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.SAMPSCORE)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.SAMPSCORE);
                            OUTelbow.setPosition(contants.Outtake.Elbow.SAMPSCORE);
                            OUTwrist.setPosition(contants.Outtake.Wrist.SAMPSCORE);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPSCORE);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPSCORE);
                        })
                        .transition(()-> gamepad1.left_bumper)
                        .onExit(()->System.out.println("exit"))
                        .state(Teleop.outtake.SPECSCORE)
                        .onEnter(() -> {
                            OUTclaw.setPosition(contants.Outtake.Claw.SPECSCORE);
                            OUTelbow.setPosition(contants.Outtake.Elbow.SPECSCORE);
                            OUTwrist.setPosition(contants.Outtake.Wrist.SPECSCORE);
                            shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECSCORE);
                            shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECSCORE);
                        })
                        .build();


            }
        }
        public Action liftUp() {
            return new LiftUp();
        }

        public class LiftDown implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    lift.setPower(-0.8);
                    initialized = true;
                }

                double pos = lift.getCurrentPosition();
                packet.put("liftPos", pos);
                if (pos > 100.0) {
                    return true;
                } else {
                    lift.setPower(0);
                    return false;
                }
            }
        }
        public Action liftDown(){
            return new LiftDown();
        }
    }

    public class Claw {
        private Servo claw;

        public Claw(HardwareMap hardwareMap) {
            claw = hardwareMap.get(Servo.class, "claw");
        }

        public class CloseClaw implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                claw.setPosition(0.55);
                return false;
            }
        }
        public Action closeClaw() {
            return new CloseClaw();
        }

        public class OpenClaw implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                claw.setPosition(1.0);
                return false;
            }
        }
        public Action openClaw() {
            return new OpenClaw();
        }
    }

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(11.8, 61.7, Math.toRadians(90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Claw claw = new Claw(hardwareMap);
        Lift lift = new Lift(hardwareMap);

        // vision here that outputs position
        int visionOutputPosition = 1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                .lineToYSplineHeading(33, Math.toRadians(0))
                .waitSeconds(2)
                .setTangent(Math.toRadians(90))
                .lineToY(48)
                .setTangent(Math.toRadians(0))
                .lineToX(32)
                .strafeTo(new Vector2d(44.5, 30))
                .turn(Math.toRadians(180))
                .lineToX(47.5)
                .waitSeconds(3);
        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                .lineToY(37)
                .setTangent(Math.toRadians(0))
                .lineToX(18)
                .waitSeconds(3)
                .setTangent(Math.toRadians(0))
                .lineToXSplineHeading(46, Math.toRadians(180))
                .waitSeconds(3);
        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
                .lineToYSplineHeading(33, Math.toRadians(180))
                .waitSeconds(2)
                .strafeTo(new Vector2d(46, 30))
                .waitSeconds(3);
        Action trajectoryActionCloseOut = tab1.endTrajectory().fresh()
                .strafeTo(new Vector2d(48, 12))
                .build();

        // actions that need to happen on init; for instance, a claw tightening.
        Actions.runBlocking(claw.closeClaw());


        while (!isStopRequested() && !opModeIsActive()) {
            int position = visionOutputPosition;
            telemetry.addData("Position during Init", position);
            telemetry.update();
        }

        int startPosition = visionOutputPosition;
        telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;
        if (startPosition == 1) {
            trajectoryActionChosen = tab1.build();
        } else if (startPosition == 2) {
            trajectoryActionChosen = tab2.build();
        } else {
            trajectoryActionChosen = tab3.build();
        }

        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen,
                        lift.liftUp(),
                        claw.openClaw(),
                        lift.liftDown(),
                        trajectoryActionCloseOut
                )
        );
    }
}