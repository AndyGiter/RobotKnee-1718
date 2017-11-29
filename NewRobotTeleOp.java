package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


/**
 * Created by FTC on 9/26/2017.
 */
@TeleOp
public class NewRobotTeleOp extends LinearOpMode {

    double SlowDown;
    double SlowWayDown;
    int Reverse;
    boolean BackClaw;
    double ServoPosition;

    DcMotor FrontRightMech;
    DcMotor FrontLeftMech;
    DcMotor BackRightMech;
    DcMotor BackLeftMech;
    DcMotor LeftWheel;
    DcMotor RightWheel;
    DcMotor RotateBlock;
    DcMotor LiftyArm;
    Servo BackRightClaw;
    Servo BackLeftClaw;
    Servo GrabbyClaw;
    Servo LiftyClaw;

@Override
public void runOpMode() {

    telemetry.addData("Status", "Initialized");
    telemetry.addData("SlowDown", "False");
    telemetry.addData("SlowWayDown","False");
    telemetry.addData("Reverse","False");
    telemetry.update();

    FrontLeftMech = hardwareMap.dcMotor.get("FrontLeftMech");
    FrontRightMech = hardwareMap.dcMotor.get("FrontRightMech");
    BackLeftMech = hardwareMap.dcMotor.get("BackLeftMech");
    BackRightMech = hardwareMap.dcMotor.get("BackRightMech");
    LeftWheel = hardwareMap.dcMotor.get("LeftWheel");
    RightWheel =hardwareMap.dcMotor.get("RightWheel");
    RotateBlock = hardwareMap.dcMotor.get("RotateBlock");
    LiftyArm = hardwareMap.dcMotor.get("LiftyArm");
    BackRightClaw = hardwareMap.servo.get("BackRightClaw");
    BackLeftClaw = hardwareMap.servo.get("BackLeftClaw");
    GrabbyClaw = hardwareMap.servo.get("GrabbyClaw");
    LiftyClaw = hardwareMap.servo.get("LiftyClaw");
    FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
    FrontRightMech.setDirection(DcMotor.Direction.FORWARD);
    BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
    BackRightMech.setDirection(DcMotor.Direction.FORWARD);
    LeftWheel.setDirection(DcMotor.Direction.REVERSE);
    RightWheel.setDirection(DcMotor.Direction.FORWARD);
    BackRightClaw.setDirection(Servo.Direction.FORWARD);
    BackLeftClaw.setDirection(Servo.Direction.FORWARD);
    GrabbyClaw.setDirection(Servo.Direction.FORWARD);
    LiftyClaw.setDirection(Servo.Direction.FORWARD);
    RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    waitForStart();
    SlowDown = 1;
    SlowWayDown = 1;
    Reverse = 1;
    BackClaw = false;
    while (opModeIsActive()) {
        
        if (gamepad1.a && Reverse == 1) {
            Reverse = -1;
            telemetry.addData("Reverse","True");
            telemetry.update();
            sleep(75);
        }
        else if (gamepad1.a && Reverse == -1) {
            Reverse = 1;
            telemetry.addData("Reverse","False");
            telemetry.update();
            sleep(75);
        }
        if (gamepad1.x && SlowDown == 1) {
            SlowDown = 0.5;
/*            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(0.5);
                LiftLeft.setPower(0.5);
            }

            while (gamepad1.left_bumper) {
                LiftRight.setPower(-0.5);
                LiftLeft.setPower(-0.5);
            }


        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-0.5);
            GrabLeft2.setPower(-0.5);
            GrabRight1.setPower(-0.5);
        }

        if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(0.5);
            GrabLeft2.setPower(0.5);
            GrabLeft1.setPower(0.5);
        }
*/
            telemetry.addData("SlowDown", "True");
            telemetry.update();


        }
        else if (gamepad1.x && SlowDown == 0.5) {
            SlowDown = 1;
            /*while (gamepad1.left_bumper) {
                LiftRight.setPower(1);
                LiftLeft.setPower(1);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-1);
                LiftLeft.setPower(-1);
            }


        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-1);
            GrabLeft2.setPower(-1);
            GrabRight1.setPower(-1);
        }

        if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(1);
            GrabLeft2.setPower(1);
            GrabLeft1.setPower(1);
        }
*/
            telemetry.addData("SlowDown", "False");
            telemetry.update();

        }
        if (gamepad1.y && SlowWayDown == 1) {
            SlowWayDown = 0.25;
/*            while (gamepad1.left_bumper) {
                LiftRight.setPower(0.25);
                LiftLeft.setPower(0.25);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-0.25);
                LiftLeft.setPower(-0.25);
            }


            if (gamepad1.right_bumper) {
                GrabLeft1.setPower(-0.25);
                GrabLeft2.setPower(-0.25);
                GrabRight1.setPower(-0.25);
            }

            if (gamepad1.right_trigger == 1) {
                GrabRight1.setPower(0.25);
                GrabLeft2.setPower(0.25);
                GrabLeft1.setPower(0.25);
            }
*/
            telemetry.addData("SlowWayDown", "True");
            telemetry.update();
        }
        else if (gamepad1.y && SlowWayDown == 0.25) {
            SlowWayDown = 1;
/*            while (gamepad1.left_bumper) {
                LiftRight.setPower(1);
                LiftLeft.setPower(1);
            }

            while (gamepad1.left_trigger == 1) {
                LiftRight.setPower(-1);
                LiftLeft.setPower(-1);
            }


            if (gamepad1.right_bumper) {
                GrabLeft1.setPower(-1);
                GrabLeft2.setPower(-1);
                GrabRight1.setPower(-1);
            }

            if (gamepad1.right_trigger == 1) {
                GrabRight1.setPower(1);
                GrabLeft2.setPower(1);
                GrabLeft1.setPower(1);
            }
*/
            telemetry.addData("SlowWayDown", "False");
            telemetry.update();
        }
        
        if(gamepad1.b){
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
        }
        
        if (gamepad1.right_stick_y != 0 && gamepad1.right_stick_x == 0){
            FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
            FrontRightMech.setDirection(DcMotor.Direction.FORWARD);
            BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
            BackRightMech.setDirection(DcMotor.Direction.FORWARD);
            FrontLeftMech.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
            FrontRightMech.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
            BackLeftMech.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
            BackRightMech.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
            LeftWheel.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
            RightWheel.setPower(gamepad1.right_stick_y*Reverse*SlowDown*SlowWayDown);
        }
        
        if (gamepad1.right_stick_x != 0 && gamepad1.right_stick_y == 0){
            FrontLeftMech.setDirection(DcMotor.Direction.FORWARD);
            FrontRightMech.setDirection(DcMotor.Direction.FORWARD);
            BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
            BackRightMech.setDirection(DcMotor.Direction.REVERSE);
            FrontLeftMech.setPower(gamepad1.right_stick_x*Reverse*SlowDown*SlowWayDown);
            FrontRightMech.setPower(gamepad1.right_stick_x*Reverse*SlowDown*SlowWayDown);
            BackLeftMech.setPower(gamepad1.right_stick_x*Reverse*SlowDown*SlowWayDown);
            BackRightMech.setPower(gamepad1.right_stick_x*Reverse*SlowDown*SlowWayDown);
        }
        
        if (gamepad1.left_stick_x != 0){
            LeftWheel.setDirection(DcMotor.Direction.REVERSE);
            RightWheel.setDirection(DcMotor.Direction.FORWARD);
            LeftWheel.setPower(gamepad1.left_stick_x);
            RightWheel.setPower(gamepad1.left_stick_x);
        }
        
        if (gamepad1.dpad_down){
            RotateBlock.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RotateBlock.setTargetPosition(10000);
            RotateBlock.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RotateBlock.setPower(1);
            RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        
        if (gamepad1.b){
            if (BackClaw){
                BackLeftClaw.setPosition(0);
                BackRightClaw.setPosition(1);
                BackClaw = false;
                telemetry.addData("Back Claw", "Open");
                telemetry.update();
            }
            else {
                BackLeftClaw.setPosition(.25);
                BackRightClaw.setPosition(.75);
                BackClaw = true;
                telemetry.addData("Back Claw", "Closed");
                telemetry.update();
            }
        }

        /*if (gamepad1.left_stick_y >= 0.1 || gamepad1.left_stick_y <= -0.1) {
            Left.setPower(gamepad1.left_stick_y);
            Right.setPower(gamepad1.left_stick_y);
        }
        if (gamepad1.left_stick_x >= 0.1 || gamepad1.left_stick_x <= -0.1) {
            Left.setPower(gamepad1.left_stick_x);
            Right.setPower(gamepad1.left_stick_x * -1);
        }*/


/*        if (gamepad1.right_bumper) {
            GrabLeft1.setPower(-1);
            GrabLeft2.setPower(-1);
            GrabRight1.setPower(-1);
        }
        else if (gamepad1.right_trigger == 1) {
            GrabRight1.setPower(1);
            GrabLeft2.setPower(1);
            GrabLeft1.setPower(1);
        }

        else {
            GrabLeft2.setPower(0);
            GrabRight1.setPower(0);
            GrabLeft1.setPower(0);
        }




        if (gamepad1.left_trigger == 1) {
            LiftRight.setPower(1);
            LiftLeft.setPower(1);
        }

        else if (gamepad1.left_bumper) {
            LiftRight.setPower(-1);
            LiftLeft.setPower(-1);
        }

        else {
            LiftRight.setPower(0);
            LiftLeft.setPower(0);
        }
*/
        }
    }
}


