package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
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
    boolean Claw;
    boolean XPress;
    boolean YPress;
    boolean Press;
    boolean FULLPOWAH;
    double HalfSpeed;
    double back;
    double ClawPosition;
    String BackClawString;
    String ClawString;
    String BackString;

    DcMotor FrontRight;
    DcMotor FrontLeft;
    DcMotor BackRight;
    DcMotor BackLeft;
    DcMotor UpWinch;
    DcMotor DownWinch;
    DcMotor RotateBlock;
    Servo BackRightServo;
    Servo BackLeftServo;
    Servo FrontLeftServo;
    Servo FrontRightServo;
    CRServo JewelArm;
    CRServo ClawServo;
    DigitalChannel touch;

@Override
public void runOpMode() {

    FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
    FrontRight = hardwareMap.dcMotor.get("FrontRight");
    BackLeft = hardwareMap.dcMotor.get("BackLeft");
    BackRight = hardwareMap.dcMotor.get("BackRight");
    UpWinch = hardwareMap.dcMotor.get("UpWinch");
    DownWinch = hardwareMap.dcMotor.get("DownWinch");
    RotateBlock = hardwareMap.dcMotor.get("RotateBlock");
    BackRightServo = hardwareMap.servo.get("BackRightServo");
    BackLeftServo = hardwareMap.servo.get("BackLeftServo");
    FrontLeftServo = hardwareMap.servo.get("FrontLeftServo");
    FrontRightServo = hardwareMap.servo.get("FrontRightServo");
    JewelArm = hardwareMap.crservo.get("JewelArm");
    ClawServo = hardwareMap.crservo.get("ClawServo");
    touch = hardwareMap.digitalChannel.get("touch");
    FrontLeft.setDirection(DcMotor.Direction.REVERSE);
    FrontRight.setDirection(DcMotor.Direction.FORWARD);
    BackLeft.setDirection(DcMotor.Direction.REVERSE);
    BackRight.setDirection(DcMotor.Direction.FORWARD);
    UpWinch.setDirection(DcMotor.Direction.FORWARD);
    DownWinch.setDirection(DcMotor.Direction.FORWARD);
    RotateBlock.setDirection(DcMotor.Direction.REVERSE);
    BackRightServo.setDirection(Servo.Direction.FORWARD);
    BackLeftServo.setDirection(Servo.Direction.FORWARD);
    FrontLeftServo.setDirection(Servo.Direction.FORWARD);
    FrontRightServo.setDirection(Servo.Direction.REVERSE);
    JewelArm.setDirection(CRServo.Direction.FORWARD);
    ClawServo.setDirection(CRServo.Direction.REVERSE);
    touch.setMode(DigitalChannel.Mode.INPUT);
    
    waitForStart();
    BackLeftServo.setPosition(0.5);
    BackRightServo.setPosition(0.15);
    FrontLeftServo.setPosition(0);
    FrontRightServo.setPosition(0);
    XPress = false;
    YPress = false;
    Press = false;
    FULLPOWAH = false;
    HalfSpeed = 1;
    back = 1;
    ClawPosition = 0.5;
    BackClawString = "Open";
    ClawString = "Closed";
    BackString = "Forwards";
    telemetry.addData("Speed:", HalfSpeed);
    telemetry.addData("Direction", BackString);
    telemetry.addData("Back Claw", BackClawString);
    telemetry.addData("Claw", ClawString);
    telemetry.update();
    while (opModeIsActive()) {
        
        if (gamepad1.right_stick_button){
            Press = true;
        }
        else if (Press){
            if (HalfSpeed == 1){
                HalfSpeed = 0.5;
                Press = false;
            }
            else {
                HalfSpeed = 1;
                Press = false;
            }
            telemetry.addData("Speed:", HalfSpeed);
            telemetry.addData("Direction", BackString);
            telemetry.addData("Back Claw", BackClawString);
            telemetry.addData("Claw", ClawString);
            telemetry.update();
        }
        
        if (gamepad1.y){
            YPress = true;
        }
        else if (YPress){
            if (back == -1){
                back = 1;
                BackString = "Forwards";
            }
            else if (back == 1){
                back = -1;
                BackString = "Backwards";
            }
            YPress = false;
            telemetry.addData("Speed:", HalfSpeed);
            telemetry.addData("Direction", BackString);
            telemetry.addData("Back Claw", BackClawString);
            telemetry.addData("Claw", ClawString);
            telemetry.update();
        }
        
        if (Math.abs(gamepad1.right_stick_y) >= 0.2 && Math.abs(gamepad1.right_stick_x) <= 0.2){
            FrontLeft.setDirection(DcMotor.Direction.FORWARD);
            FrontRight.setDirection(DcMotor.Direction.REVERSE);
            BackLeft.setDirection(DcMotor.Direction.FORWARD);
            BackRight.setDirection(DcMotor.Direction.REVERSE);
            FrontLeft.setPower(gamepad1.right_stick_y*HalfSpeed*back);
            FrontRight.setPower(gamepad1.right_stick_y*HalfSpeed*back);
            BackLeft.setPower(gamepad1.right_stick_y*HalfSpeed*back);
            BackRight.setPower(gamepad1.right_stick_y*HalfSpeed*back);
        }
        
        else if (Math.abs(gamepad1.right_stick_x) >= 0.2 && Math.abs(gamepad1.right_stick_y) <= 0.2){
            FrontLeft.setDirection(DcMotor.Direction.REVERSE);
            FrontRight.setDirection(DcMotor.Direction.REVERSE);
            BackLeft.setDirection(DcMotor.Direction.FORWARD);
            BackRight.setDirection(DcMotor.Direction.FORWARD);
            FrontLeft.setPower(gamepad1.right_stick_x*HalfSpeed*back);
            FrontRight.setPower(gamepad1.right_stick_x*HalfSpeed*back);
            BackLeft.setPower(gamepad1.right_stick_x*HalfSpeed*back);
            BackRight.setPower(gamepad1.right_stick_x*HalfSpeed*back);
        }
        
        else if (Math.abs(gamepad1.left_stick_x) >= 0.2 && Math.abs(gamepad1.left_stick_y) <= 0.2){
            FrontRight.setDirection(DcMotor.Direction.REVERSE);
            FrontLeft.setDirection(DcMotor.Direction.REVERSE);
            BackLeft.setDirection(DcMotor.Direction.REVERSE);
            BackRight.setDirection(DcMotor.Direction.REVERSE);
            FrontRight.setPower(gamepad1.left_stick_x*HalfSpeed*back);
            FrontLeft.setPower(gamepad1.left_stick_x*HalfSpeed*back);
            BackLeft.setPower(gamepad1.left_stick_x*HalfSpeed*back);
            BackRight.setPower(gamepad1.left_stick_x*HalfSpeed*back);
        }
        else if (Math.abs(gamepad1.left_stick_y) >= 0.2 && Math.abs(gamepad1.left_stick_x) <= 0.2 && gamepad1.right_bumper == false){
            UpWinch.setPower(gamepad1.left_stick_y);
        }
        else {
            FrontLeft.setPower(0);
            FrontRight.setPower(0);
            BackLeft.setPower(0);
            BackRight.setPower(0);
            UpWinch.setPower(0);
        }
        if (gamepad1.left_stick_y < -0.1 && touch.getState() == false && gamepad1.right_bumper == false) {
            DownWinch.setPower(1);
        }
        else if (gamepad1.left_stick_y > 0.1 && touch.getState() && gamepad1.right_bumper == false) {
            DownWinch.setPower(-1);
        }
        else if (gamepad1.right_bumper) {
            DownWinch.setPower(-1*gamepad1.left_stick_y);
        }
        else {
            DownWinch.setPower(0);
        }
        
        if (gamepad1.left_stick_y < -0.2 && touch.getState() == false) {
            DownWinch.setPower(1);
        }
        else if (gamepad1.left_stick_y > 0.2 && touch.getState()) {
            DownWinch.setPower(-1);
        }
        else {
            DownWinch.setPower(0);
        }
        
        if (gamepad1.dpad_up){
            RotateBlock.setPower(.5);
        }
        else if (gamepad1.dpad_down){
            RotateBlock.setPower(-.5);
        }
        else {
            RotateBlock.setPower(0);
        }
        
        if (gamepad1.left_trigger >= 0.2){
            BackLeftServo.setPosition(0.5);
            BackRightServo.setPosition(0.15);
            BackClawString = "Open";
            telemetry.addData("Speed:", HalfSpeed);
            telemetry.addData("Direction", BackString);
            telemetry.addData("Back Claw", BackClawString);
            telemetry.addData("Claw", ClawString);
            telemetry.update();
        }
            
        else if (gamepad1.left_bumper) {
            BackLeftServo.setPosition(.65);
            BackRightServo.setPosition(0);
            BackClawString = "Closed";
            telemetry.addData("Speed:", HalfSpeed);
            telemetry.addData("Direction", BackString);
            telemetry.addData("Back Claw", BackClawString);
            telemetry.addData("Claw", ClawString);
            telemetry.update();
        }
        
        if (gamepad1.right_trigger >= 0.2){
            FrontLeftServo.setPosition(1);
            FrontRightServo.setPosition(1);
        }
        else {
            FrontLeftServo.setPosition(0);
            FrontRightServo.setPosition(0);
        }
        
        if (gamepad1.dpad_left){
            JewelArm.setPower(-1);
        }
        else if (gamepad1.dpad_right){
            JewelArm.setPower(1);
        }
        else {
            JewelArm.setPower(0);
        }
        
        if (gamepad1.x){
            XPress = true;
        }
        else if (XPress){
            if (FULLPOWAH){ 
                FULLPOWAH = false;
            }
            else if (FULLPOWAH == false){
                FULLPOWAH = true;
            }
            XPress = false;
        }
        if (gamepad1.y || gamepad1.a | gamepad1.b){
            FULLPOWAH = false;
        }
        if (FULLPOWAH){
            ClawServo.setPower(0);
        }
        else if (gamepad1.a){
            ClawServo.setPower(0.105);
        }
        else if (gamepad1.b){
            ClawServo.setPower(0.205);
        }
        else {
            ClawServo.setPower(0.155);
        }
        }
    }
}


