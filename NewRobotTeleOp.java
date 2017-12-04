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

    boolean BackClaw;
    boolean Grab;
    double LiftyClawServoPosition;
    double GrabbyClawServoPosition;

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

    FrontLeftMech = hardwareMap.dcMotor.get("FrontLeftMech");
    FrontRightMech = hardwareMap.dcMotor.get("RightWheel");
    BackLeftMech = hardwareMap.dcMotor.get("BackLeftMech");
    BackRightMech = hardwareMap.dcMotor.get("BackRightMech");
    LeftWheel = hardwareMap.dcMotor.get("LeftWheel");
    RightWheel =hardwareMap.dcMotor.get("FrontRightMech");
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
    RotateBlock.setDirection(DcMotor.Direction.REVERSE);
    BackRightClaw.setDirection(Servo.Direction.FORWARD);
    BackLeftClaw.setDirection(Servo.Direction.FORWARD);
    GrabbyClaw.setDirection(Servo.Direction.FORWARD);
    LiftyClaw.setDirection(Servo.Direction.FORWARD);
    
    waitForStart();
    BackClaw = false;
    Grab = true;
    LiftyClaw.setPosition(0.42);
    GrabbyClaw.setPosition(1);
    while (opModeIsActive()) {
        
        if (Math.abs(gamepad1.right_stick_y) >= 0.2 && Math.abs(gamepad1.right_stick_x) <= 0.2){
            FrontLeftMech.setDirection(DcMotor.Direction.FORWARD);
            FrontRightMech.setDirection(DcMotor.Direction.REVERSE);
            BackLeftMech.setDirection(DcMotor.Direction.FORWARD);
            BackRightMech.setDirection(DcMotor.Direction.REVERSE);
            LeftWheel.setDirection(DcMotor.Direction.FORWARD);
            RightWheel.setDirection(DcMotor.Direction.REVERSE);
            FrontLeftMech.setPower(gamepad1.right_stick_y);
            FrontRightMech.setPower(gamepad1.right_stick_y);
            BackLeftMech.setPower(gamepad1.right_stick_y);
            BackRightMech.setPower(gamepad1.right_stick_y);
            LeftWheel.setPower(gamepad1.right_stick_y);
            RightWheel.setPower(gamepad1.right_stick_y);
        }
        
        else if (Math.abs(gamepad1.right_stick_x) >= 0.2 && Math.abs(gamepad1.right_stick_y) <= 0.2){
            FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
            RightWheel.setDirection(DcMotor.Direction.REVERSE);
            BackLeftMech.setDirection(DcMotor.Direction.FORWARD);
            BackRightMech.setDirection(DcMotor.Direction.FORWARD);
            FrontLeftMech.setPower(gamepad1.right_stick_x);
            RightWheel.setPower(gamepad1.right_stick_x);
            BackLeftMech.setPower(gamepad1.right_stick_x);
            BackRightMech.setPower(gamepad1.right_stick_x);
        }
        
        else if (Math.abs(gamepad1.left_stick_x) >= 0.2 && Math.abs(gamepad1.left_stick_y) <= 0.2){
            LeftWheel.setDirection(DcMotor.Direction.REVERSE);
            RightWheel.setDirection(DcMotor.Direction.REVERSE);
            FrontRightMech.setDirection(DcMotor.Direction.REVERSE);
            FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
            BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
            BackRightMech.setDirection(DcMotor.Direction.REVERSE);
            LeftWheel.setPower(gamepad1.left_stick_x);
            RightWheel.setPower(gamepad1.left_stick_x);
            FrontRightMech.setPower(gamepad1.left_stick_x);
            FrontLeftMech.setPower(gamepad1.left_stick_x);
            BackLeftMech.setPower(gamepad1.left_stick_x);
            BackRightMech.setPower(gamepad1.left_stick_x);
        }
        else if (Math.abs(gamepad1.left_stick_y) >= 0.2 && Math.abs(gamepad1.left_stick_x) <= 0.2){
            LiftyArm.setPower(gamepad1.left_stick_y);
        }
        else {
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            LiftyArm.setPower(0);
        }
        
        if (gamepad1.dpad_down){
            RotateBlock.setPower(.25);
        }
        else {
            RotateBlock.setPower(0);
        }
        
        if (gamepad1.dpad_up){
            RotateBlock.setPower(-.25);
        }
        else {
            RotateBlock.setPower(0);
        }
        
        if (gamepad1.b){
                BackLeftClaw.setPosition(0);
                BackRightClaw.setPosition(1);
                BackClaw = false;
                telemetry.addData("Back Claw", "Open");
                telemetry.update();
        }
        
        if (gamepad1.right_bumper){
            LiftyClaw.setPosition(1);
        }
        else if (gamepad1.right_trigger >= 0.2){
            LiftyClaw.setPosition(0);
        }
        else {
            LiftyClaw.setPosition(0.42);
        }
        
        if (gamepad1.left_bumper){
            GrabbyClaw.setPosition(1);
        }
        
        if (gamepad1.left_trigger >= 0.2){
            GrabbyClaw.setPosition(0);
        }
        
        if (gamepad1.a){
                BackLeftClaw.setPosition(.65);
                BackRightClaw.setPosition(0);
                BackClaw = true;
                telemetry.addData("Back Claw", "Closed");
                telemetry.update();
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


