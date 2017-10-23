package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * This OpMode illustrates the basics of using the Vuforia engine to determine
 * the identity of Vuforia VuMarks encountered on the field. The code is structured as
 * a LinearOpMode. It shares much structure with {@link ConceptVuforiaNavigation}; we do not here
 * duplicate the core Vuforia documentation found there, but rather instead focus on the
 * differences between the use of Vuforia for navigation vs VuMark identification.
 *
 * @see ConceptVuforiaNavigation
 * @see VuforiaLocalizer
 * @see VuforiaTrackableDefaultListener
 * see  ftc_app/doc/tutorial/FTC_FieldCoordinateSystemDefinition.pdf
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list.
 *
 * IMPORTANT: In order to use this OpMode, you need to obtain your own Vuforia license key as
 * is explained in {@link ConceptVuforiaNavigation}.
 */

@Autonomous(name="5452 Autonomous", group ="Concept")

public class Vuforic extends LinearOpMode {
    
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor grabLeft1 = null;
    private DcMotor grabLeft2 = null;
    private DcMotor grabRight1 = null;

    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    VuforiaLocalizer vuforia;

    @Override public void runOpMode() {

        /*
         * To start up Vuforia, tell it the view that we wish to use for camera monitor (on the RC phone);
         * If no camera monitor is desired, use the parameterless constructor instead (commented out below).
         */
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        // OR...  Do Not Activate the Camera Monitor View, to save power
        // VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        /*
         * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
         * 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
         * A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
         * web site at https://developer.vuforia.com/license-manager.
         *
         * Vuforia license keys are always 380 characters long, and look as if they contain mostly
         * random data. As an example, here is a example of a fragment of a valid key:
         *      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
         * Once you've obtained a license key, copy the string from the Vuforia web site
         * and paste it in to your code onthe next line, between the double quotes.
         */
        parameters.vuforiaLicenseKey = "AbbrEYP/////AAAAGSRsYKryFkbHuNDCptghQKJrrNi81nioA0lFQYXey4+56/mLgwkoqS40qchgWM0lzce9hgyYZjIiNWJ+EUcQnaeZyKUtxNnl8Cw4HgHnhjyHrXmCGG/sLYGQsTo8HYshF9fgBizSsPgVP20BmfvYg6YdBby8rc3iKsd1qYZzX/Mso30iMR7kL9GjgBeeI9bD04hhD/7aw6cxgBV2HrwLn3yedxCERQOH8InA6QKr9juTBRJ9cdmRpEQexA6jg3NRYYOz6vWQke9XJL/4RV6z6uyKGA+JHlatfupo46fxd/N11ZMIJGnyDAogJaIzr5F8mxFnxOuhSamZ9CGpapTThzWbVRTlY7RuEGMcCqmQlfBx";

        /*
         * We also indicate which camera on the RC that we wish to use.
         * Here we chose the back (HiRes) camera (for greater range), but
         * for a competition robot, the front camera might be more convenient.
         */
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        /**
         * Load the data set containing the VuMarks for Relic Recovery. There's only one trackable
         * in this data set: all three of the VuMarks in the game were created from this one template,
         * but differ in their instance id information.
         * @see VuMarkInstanceId
         */
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        
        leftDrive = hardwareMap.get(DcMotor.class, "LeftMotor");
        rightDrive = hardwareMap.get(DcMotor.class, "RightMotor");
        grabLeft1 = hardwareMap.get(DcMotor.class, "GrabLeftMotor1");
        grabLeft2 = hardwareMap.get(DcMotor.class, "GrabLeftMotor2");
        grabRight1 = hardwareMap.get(DcMotor.class, "GrabRightMotor1");
        
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        GrabRight1.setDirection(DcMotor.Direction.FORWARD);
        GrabLeft1.setDirection(DcMotor.Direction.FORWARD);
        GrabLeft2.setDirection(DcMotor.Direction.REVERSE);
        
        relicTrackables.activate();
        
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            
            leftDrive.setPower(1);
            rightDrive.setPower(1); 
            ElapsedTime eTime = new ElapsedTime();
            eTime.reset();
            while(eTime.time() < 0.4) {}
            leftDrive.setPower(0);
            rightDrive.setPower(0);
            eTime.reset();
            while(eTime.time() < 1.5) {}
            
            /**
             * See if any of the instances of {@link relicTemplate} are currently visible.
             * {@link RelicRecoveryVuMark} is an enum which can have the following values:
             * UNKNOWN, LEFT, CENTER, and RIGHT. When a VuMark is visible, something other than
             * UNKNOWN will be returned by {@link RelicRecoveryVuMark#from(VuforiaTrackable)}.
             */
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

                /* Found an instance of the template. In the actual game, you will probably
                 * loop until this condition occurs, then move on to act accordingly depending
                 * on which VuMark was visible. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                
                if (vuMark.equals(RelicRecoveryVuMark.LEFT)) {
                    leftDrive.setPower(1);
                    rightDrive.setPower(-1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 3.0) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(-1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 1.0) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    GrabRight1.setPower(1);
                    GrabLeft2.setPower(1);
                    GrabLeft1.setPower(1);
                }
                else if (vuMark.equals(RelicRecoveryVuMark.CENTER)) {
                    leftDrive.setPower(1);
                    rightDrive.setPower(-1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 3.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(-1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 1.0) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    GrabRight1.setPower(1);
                    GrabLeft2.setPower(1);
                    GrabLeft1.setPower(1);
                }
                else if (vuMark.equals(RelicRecoveryVuMark.RIGHT)) {
                    leftDrive.setPower(1);
                    rightDrive.setPower(-1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 4.0) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(-1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 0.5) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    eTime.reset();
                    while(eTime.time() < 0.3) {}
                    leftDrive.setPower(1);
                    rightDrive.setPower(1);
                    eTime.reset();
                    while(eTime.time() < 1.0) {}
                    leftDrive.setPower(0);
                    rightDrive.setPower(0);
                    GrabRight1.setPower(1);
                    GrabLeft2.setPower(1);
                    GrabLeft1.setPower(1);
                }

            }
            else {
                telemetry.addData("VuMark", "Nothing Visible");
            }
        }
    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }
}
