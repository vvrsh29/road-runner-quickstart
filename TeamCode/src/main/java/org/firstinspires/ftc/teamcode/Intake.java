package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;

import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
public class Intake {
    Servo claw = hardwareMap.get(Servo.class, "claw");
    Servo wrist = hardwareMap.get(Servo.class, "wrist");
    Servo shoulder = hardwareMap.get(Servo.class, "shoulder");
    Servo elbow = hardwareMap.get(Servo.class, "elbow");
    Servo SL = hardwareMap.get(Servo.class, "SL");
    Servo SR = hardwareMap.get(Servo.class, "SR");



}
