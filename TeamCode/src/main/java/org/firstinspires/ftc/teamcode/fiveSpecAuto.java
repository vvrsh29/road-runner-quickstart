package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.contants;
import org.firstinspires.ftc.teamcode.FUNCTIONS;
import org.firstinspires.ftc.teamcode.AUTONFUNCTIONS;

@Config
@Autonomous(name = "5 preload", group = "Autonomous")

public class fiveSpecAuto extends LinearOpMode {


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(0, -62, Math.toRadians(-90));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Vector2d accept = new Vector2d(38,-64);
        Vector2d end = new Vector2d(50,-65);
        double TAS = 0.0; //placeHolder
        AUTONFUNCTIONS autonfunctions = new AUTONFUNCTIONS();

        // vision here that outputs position

        Action scorePreload = drive.actionBuilder(initialPose)
                .stopAndAdd(new SequentialAction(autonfunctions.PICKUP()))
                .strafeTo(new Vector2d(-4, -28))
                .stopAndAdd(new SequentialAction(autonfunctions.SCORE()))
                .stopAndAdd(new SleepAction(TAS))
                .stopAndAdd(new SequentialAction(autonfunctions.pikcupprep()))

                .build();

        Action push = drive.actionBuilder(new Pose2d(-2, -35, Math.toRadians(-90)))
                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(30,-45),Math.toRadians(90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(38,-15), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(48,-15),Math.toRadians(-90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(48,-45),Math.toRadians(-90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(135))
                .splineToConstantHeading(new Vector2d(58,-15),Math.toRadians(-90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(58,-45),Math.toRadians(-90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(135))
                .splineToConstantHeading(new Vector2d(65,-10),Math.toRadians(-90), new TranslationalVelConstraint(150))

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(65,-40),Math.toRadians(-70), new TranslationalVelConstraint(150))
               .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .waitSeconds(.05)
                .stopAndAdd(autonfunctions.PICKUP())
                .build();

        Action firstCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(0, -30), Math.toRadians(90))
                .afterTime(.05, new SequentialAction(autonfunctions.SCORE()))
                .waitSeconds(TAS)
                .stopAndAdd(new SequentialAction(autonfunctions.pikcupprep()))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .afterTime(.05, new SequentialAction(autonfunctions.PICKUP()))
                .build();
        Action secondCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(2, -30), Math.toRadians(90))
                .afterTime(.05, new SequentialAction(autonfunctions.SCORE()))
                .waitSeconds(TAS)
                .stopAndAdd(new SequentialAction(autonfunctions.pikcupprep()))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .afterTime(.05, new SequentialAction(autonfunctions.PICKUP()))
                .build();
        Action thirdCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(4, -30), Math.toRadians(90))
                .afterTime(.05, new SequentialAction(autonfunctions.SCORE()))
                .waitSeconds(TAS)
                .stopAndAdd(new SequentialAction(autonfunctions.pikcupprep()))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .afterTime(.05, new SequentialAction(autonfunctions.PICKUP()))
                .build();
        Action fourthCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))
                .setTangent(90)
                .splineToConstantHeading(new Vector2d(6, -30), Math.toRadians(90))
                .afterTime(.05, new SequentialAction(autonfunctions.SCORE()))
                .waitSeconds(TAS)
                .stopAndAdd(new SequentialAction(autonfunctions.pikcupprep()))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .afterTime(.05, new SequentialAction(autonfunctions.PICKUP()))
                .build();
        Action park = drive.actionBuilder(new Pose2d(new Vector2d(6, -30), Math.toRadians(-90)))
                .afterTime(0.25, new SequentialAction(autonfunctions.INIT()))
                .splineToConstantHeading(accept,Math.toRadians(-90), new TranslationalVelConstraint(200))
                .build();


        waitForStart();

        if (isStopRequested()) return;


        Actions.runBlocking(
                new SequentialAction(
                        scorePreload,
                        push,
                        firstCycle,
                        secondCycle,
                        thirdCycle,
                        fourthCycle,
                        park
                )
        );

    }
}