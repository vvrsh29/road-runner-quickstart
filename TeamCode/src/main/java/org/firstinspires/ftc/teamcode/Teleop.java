package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Servo;
import com.sfdev.assembly.state.StateMachine;
import com.sfdev.assembly.state.StateMachineBuilder;
import org.firstinspires.ftc.teamcode.contants;
import org.firstinspires.ftc.teamcode.Intake;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class Teleop extends LinearOpMode {
    //Intake
    Servo claw = hardwareMap.get(Servo.class, "claw");
    Servo wrist = hardwareMap.get(Servo.class, "wrist");
    Servo shoulder = hardwareMap.get(Servo.class, "shoulder");
    Servo elbow = hardwareMap.get(Servo.class, "elbow");
    Servo SL = hardwareMap.get(Servo.class, "SL");
    Servo SR = hardwareMap.get(Servo.class, "SR");

    //outtake
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
    enum intake
    {
        INIT,
        PIKCUPPREP,
        PICKUP,
        RETRACT,
        TRANSFER,
    }
    @Override
    public void runOpMode() throws InterruptedException {
        //OUTTAKE
        StateMachine Outtake = new StateMachineBuilder()
                .state(outtake.INIT)// first has to be INIT?
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
                .state(outtake.PICKUP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.PICKUP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);
                })
                .transition(()-> gamepad1.b)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SPECPREP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SPECPREP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SPECPREP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SPECPREP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECPREP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECPREP);
                })
                .transition(()-> gamepad1.x)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SAMPPREP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SAMPPREP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SAMPPREP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SAMPPREP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPPREP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPPREP);
                })
                .transition(()-> gamepad1.y)
                .onExit(()->System.out.println("exit"))
                .state(outtake.TRANSFER)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.TRANSFER1);
                    OUTelbow.setPosition(contants.Outtake.Elbow.TRANSFER);
                    OUTwrist.setPosition(contants.Outtake.Wrist.TRANSFER);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.TRANSFER);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.TRANSFER);
                })
                .transition(()-> gamepad1.right_bumper)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SAMPSCORE)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SAMPSCORE);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SAMPSCORE);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SAMPSCORE);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPSCORE);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPSCORE);
                })
                .transition(()-> gamepad1.left_bumper)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SPECSCORE)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SPECSCORE);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SPECSCORE);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SPECSCORE);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECSCORE);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECSCORE);
                })
                .build();

        StateMachine Intake = new StateMachineBuilder()
                .state(intake.INIT)// first has to be INIT?
                .onEnter(()->{
                    claw.setPosition(contants.Intake.Claw.INIT);
                    elbow.setPosition(contants.Intake.Elbow.INIT);
                    wrist.setPosition(contants.Outtake.Wrist.INIT);
                    shoulder.setPosition(contants.Outtake.ShoulderLeft.INIT);
                    SL.setPosition(contants.Outtake.ShoulderRight.INIT);
                    SR.setPosition(contants.Outtake.ShoulderRight.INIT);
                    System.out.println("Frist");

                })
                .transition(()-> gamepad1.a)
                .onExit(()->System.out.println("exit"))
                .state(outtake.PICKUP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.PICKUP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.PICKUP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.PICKUP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.PICKUP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.PICKUP);
                })
                .transition(()-> gamepad1.b)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SPECPREP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SPECPREP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SPECPREP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SPECPREP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECPREP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECPREP);
                })
                .transition(()-> gamepad1.x)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SAMPPREP)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SAMPPREP);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SAMPPREP);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SAMPPREP);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPPREP);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPPREP);
                })
                .transition(()-> gamepad1.y)
                .onExit(()->System.out.println("exit"))
                .state(outtake.TRANSFER)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.TRANSFER1);
                    OUTelbow.setPosition(contants.Outtake.Elbow.TRANSFER);
                    OUTwrist.setPosition(contants.Outtake.Wrist.TRANSFER);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.TRANSFER);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.TRANSFER);
                })
                .transition(()-> gamepad1.right_bumper)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SAMPSCORE)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SAMPSCORE);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SAMPSCORE);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SAMPSCORE);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SAMPSCORE);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SAMPSCORE);
                })
                .transition(()-> gamepad1.left_bumper)
                .onExit(()->System.out.println("exit"))
                .state(outtake.SPECSCORE)
                .onEnter(() -> {
                    OUTclaw.setPosition(contants.Outtake.Claw.SPECSCORE);
                    OUTelbow.setPosition(contants.Outtake.Elbow.SPECSCORE);
                    OUTwrist.setPosition(contants.Outtake.Wrist.SPECSCORE);
                    shoulderL.setPosition(contants.Outtake.ShoulderLeft.SPECSCORE);
                    shoulderR.setPosition(contants.Outtake.ShoulderRight.SPECSCORE);
                })
                .build();
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Retrieve the IMU from the hardware map
        IMU imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        waitForStart();
        Outtake.start();
        if (isStopRequested()) return;

        while (opModeIsActive()) {

            Outtake.update();

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x;
            double rx = gamepad1.right_stick_x;

            // This button choice was made so that it is hard to hit on accident,
            // it can be freely changed based on preference.
            // The equivalent button is start on Xbox-style controllers.
            if (gamepad1.options) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // Rotate the movement direction counter to the bot's rotation
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;  // Counteract imperfect strafing

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            frontLeftMotor.setPower(frontLeftPower);
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }
    }
}