package org.firstinspires.ftc.teamcode;


//arya told me to do this class, i have no idea if this is right
public class contants {
    public static final class Outtake {
        public static final class Claw {
            public static final double CLOSE = 0.00;
            public static final double OPEN = 0.00;
            public static final double INIT = CLOSE;
            public static final double SPECPREP = CLOSE; //getting ready to score
            public static final double SAMPPREP = CLOSE;
            public static final double SPECSCORE = CLOSE;
            public static final double SAMPSCORE = CLOSE;
            public static final double TRANSFER1 = OPEN;
            public static final double TRANSFER2 = CLOSE;
            public static final double PICKUP = OPEN; //from wall


        }

        public static final class Wrist {
            public static final double INIT = 0.00;
            public static final double SPECPREP = 0.00; //getting ready to score
            public static final double SAMPPREP = 0.00;
            public static final double SPECSCORE = 0.00;
            public static final double SAMPSCORE = 0.00;
            public static final double TRANSFER = 0.00;
            public static final double PICKUP = 0.00; //from wall
        }

        public static final class Elbow {
            public static final double INIT = 0.00;
            public static final double SPECPREP = 0.00; //getting ready to score
            public static final double SAMPPREP = 0.00;
            public static final double SPECSCORE = 0.00;
            public static final double SAMPSCORE = 0.00;
            public static final double TRANSFER = 0.00;
            public static final double PICKUP = 0.00; //from wall
        }

        public static final class ShoulderLeft {
            public static final double INIT = 0.00;
            public static final double SPECPREP = 0.00; //getting ready to score
            public static final double SAMPPREP = 0.00;
            public static final double SPECSCORE = 0.00;
            public static final double SAMPSCORE = 0.00;
            public static final double TRANSFER = 0.00;
            public static final double PICKUP = 0.00; //from wall
        }

        public static final class ShoulderRight {
            public static final double INIT = 0.00;
            public static final double SPECPREP = 0.00; //getting ready to score
            public static final double SAMPPREP = 0.00;
            public static final double SPECSCORE = 0.00;
            public static final double SAMPSCORE = 0.00;
            public static final double TRANSFER = 0.00;
            public static final double PICKUP = 0.00; //from wall
        }
    }
//
//    public static final class Slides {
//        public static final String slidesPrimary = "slides1";
//        public static final String slidesSecondary = "slides2";
//        public static final int SPECIMEN = 1500;
//        public static final int SAMPLE = 2000;
//        public static final double kP = 0.0001;
//        public static final double kD = 0.0001;
//        public static final double kF = 0.0001;
//        public static final double maxPowerConstant = 1.0;
//    }

    public static final class Intake {
        public static final class Claw {
            public static final double CLOSED = 0.0;
            public static final double OPEN = 0.0;

            public static final double INIT = CLOSED;
            public static final double PICKUPPREP = OPEN;
            public static final double PICKUP = CLOSED;
            public static final double RETRACT = CLOSED;
            public static final double TRANSFER1 = CLOSED;
            public static final double TRANSFER2 = OPEN;
        }

        public static final class Wrist {
            public static final double WINIT = 0.0;
            public static final double WPICKUPPREP = 0.0;
            public static final double WPICKUP = 0.0;
            public static final double WRETRACT = 0.0;
            public static final double WTRANSFER1 = 0.0;

            public static final class Elbow {
                public static final double EINIT = 0.0;
                public static final double EPICKUPPREP = 0.0;
                public static final double EPICKUP = 0.0;
                public static final double ERETRACT = 0.0;
                public static final double ETRANSFER1 = 0.0;

            }

            public static final class Shoulder {
                public static final double SHINIT = 0.0;
                public static final double SHPICKUPPREP = 0.0;
                public static final double SHPICKUP = 0.0;
                public static final double SHRETRACT = 0.0;
                public static final double SHTRANSFER1 = 0.0;

            }

            public static final class SlidesLeft {
                public static final double EXTEND = 0.0;
                public static final double RETRACT = 0.0;
                public static final double SLINIT = RETRACT;
                public static final double SLPICKUPPREP = EXTEND;
                public static final double SLPICKUP = EXTEND;
                public static final double SLRETRACT = RETRACT;
                public static final double SLTRANSFER1 = RETRACT;

            }

            public static final class SlidesRight {
                public static final double EXTEND = 0.0;
                public static final double RETRACT = 0.0;
                public static final double SRINIT = RETRACT;
                public static final double SRPICKUPPREP = EXTEND;
                public static final double SRPICKUP = EXTEND;
                public static final double SRRETRACT = RETRACT;
                public static final double SRTRANSFER1 = RETRACT;

            }
        }
    }
}
