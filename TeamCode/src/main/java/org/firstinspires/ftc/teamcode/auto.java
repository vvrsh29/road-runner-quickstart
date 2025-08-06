package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Config
@Autonomous(name = "5 preload", group = "Autonomous")

public class A5Push extends AutonFunctions {


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(0, -62, Math.toRadians(-90));
        initFunctions();
        Vector2d accept = new Vector2d(38,-64);
        Vector2d end = new Vector2d(50,-65);
        double timeAfterScore = 0.25;

        // vision here that outputs position

        Action scorePreload = drive.actionBuilder(initialPose)
                .stopAndAdd(new SequentialAction(scorePrep()))
                .strafeTo(new Vector2d(-2, -28))
                .stopAndAdd(new SequentialAction(scoreSpec()))
                .stopAndAdd(new SleepAction(timeAfterScore))
                .stopAndAdd(new SequentialAction(scorePickup()))

                .build();

        Action push = drive.actionBuilder(new Pose2d(-2, -35, Math.toRadians(-90)))

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(30,-45),Math.toRadians(90), new TranslationalVelConstraint(170))

                .setTangent(Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(38,-20), Math.toRadians(90))
                .splineToConstantHeading(new Vector2d(50,-15),Math.toRadians(-90), new TranslationalVelConstraint(170))
                .waitSeconds(.02)

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(50,-45),Math.toRadians(-90), new TranslationalVelConstraint(170))

                .setTangent(Math.toRadians(135))
                .splineToConstantHeading(new Vector2d(58,-10),Math.toRadians(-90), new TranslationalVelConstraint(170))
                .waitSeconds(.02)

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(58,-45),Math.toRadians(-90), new TranslationalVelConstraint(170))

                .setTangent(Math.toRadians(135))
                .splineToConstantHeading(new Vector2d(68,-10),Math.toRadians(-80), new TranslationalVelConstraint(170))
                .waitSeconds(.02)

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(68,-43),Math.toRadians(-70), new TranslationalVelConstraint(170))

                .setTangent(Math.toRadians(-90))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .waitSeconds(.05)
                .strafeTo(new Vector2d(38,-65))
                .stopAndAdd(closeClaw())
                .waitSeconds(0.1)
                .stopAndAdd(scorePrep())

                .build();

        Action firstCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(10, -30), Math.toRadians(90), new TranslationalVelConstraint(130))

                .strafeTo(new Vector2d(10,-28))
                .afterTime(.05, new SequentialAction(scoreSpec()))

                .waitSeconds(timeAfterScore)
                .stopAndAdd(new SequentialAction(scorePickup()))

                .splineToConstantHeading(accept,Math.toRadians(-90), new TranslationalVelConstraint(80))

                .strafeTo(new Vector2d(38,-65))
                .afterTime(.05, new SequentialAction(closeClaw()))
                .waitSeconds(0.07)
                .stopAndAdd(scorePrep())
                .build();

        Action secondCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(8, -30), Math.toRadians(90), new TranslationalVelConstraint(130))

                .strafeTo(new Vector2d(8,-28))
                .afterTime(.05, new SequentialAction(scoreSpec()))

                .waitSeconds(timeAfterScore)
                .stopAndAdd(new SequentialAction(scorePickup()))

                .splineToConstantHeading(accept,Math.toRadians(-90), new TranslationalVelConstraint(80))

                .strafeTo(new Vector2d(38,-65))
                .afterTime(.05, new SequentialAction(closeClaw()))
                .waitSeconds(0.07)
                .stopAndAdd(scorePrep())
                .build();

        Action thirdCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(6, -30), Math.toRadians(90), new TranslationalVelConstraint(130))

                .strafeTo(new Vector2d(6,-28))
                .afterTime(.05, new SequentialAction(scoreSpec()))

                .waitSeconds(timeAfterScore)
                .stopAndAdd(new SequentialAction(scorePickup()))

                .splineToConstantHeading(accept,Math.toRadians(-90), new TranslationalVelConstraint(80))

                .strafeTo(new Vector2d(38,-65))
                .afterTime(.05, new SequentialAction(closeClaw()))
                .waitSeconds(0.07)
                .stopAndAdd(scorePrep())
                .build();

        Action fourthCycle = drive.actionBuilder(new Pose2d(accept, Math.toRadians(-90)))

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(4, -30), Math.toRadians(90),  new TranslationalVelConstraint(130))

                .strafeTo(new Vector2d(4,-28))
                .afterTime(.05, new SequentialAction(scoreSpec()))
                .stopAndAdd(new SleepAction(timeAfterScore))
                .stopAndAdd(new SequentialAction(scorePickup()))
                .build();

        Action park = drive.actionBuilder(new Pose2d(new Vector2d(3, -30), Math.toRadians(-90)))
                .afterTime(0.25, new SequentialAction(autoEnd()))
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