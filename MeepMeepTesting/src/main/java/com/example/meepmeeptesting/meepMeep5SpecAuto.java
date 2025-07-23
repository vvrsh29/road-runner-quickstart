package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class meepMeep5SpecAuto   {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(500);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        Pose2d initialPose = new Pose2d(0, -62, Math.toRadians(-90));
        Vector2d accept = new Vector2d(40,-64);
        Vector2d end = new Vector2d(38,-64);

        myBot.runAction(myBot.getDrive().actionBuilder(initialPose)
                .strafeTo(new Vector2d(-4, -28))
                .stopAndAdd(new SleepAction(0.4))

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
                .waitSeconds(0.1)
                .waitSeconds(0.05)

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(0, -30), Math.toRadians(90))

                .stopAndAdd(new SleepAction(0.2))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .waitSeconds(0.1)
                .waitSeconds(0.05)

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(2,-30), Math.toRadians(90), new TranslationalVelConstraint(150))

                .stopAndAdd(new SleepAction(0.2))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .waitSeconds(0.1)
                .waitSeconds(0.05)

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(5, -30), Math.toRadians(90))

                .stopAndAdd(new SleepAction(0.2))
                .splineToConstantHeading(accept,Math.toRadians(-90))
                .waitSeconds(0.1)
                .waitSeconds(0.05)

                .setTangent(90)
                .splineToConstantHeading(new Vector2d(8, -30), Math.toRadians(90))
                .stopAndAdd(new SleepAction(0.2))

                .splineTo(end, Math.toRadians(-45))
                .build()
        );

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
