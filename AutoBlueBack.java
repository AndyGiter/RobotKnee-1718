package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="AutoBlueBack", group ="Concept")

public class AutoBlueBack extends LinearOpMode{
    int TickToInch;
    
    DcMotor FrontRight;
    DcMotor FrontLeft;
    DcMotor BackRight;
    DcMotor BackLeft;
    Servo BackRightServo;
    Servo BackLeftServo;
    Servo FrontLeftServo;
    Servo FrontRightServo;
    CRServo JewelArm;
    ColorSensor color;

    @Override public void runOpMode() {
        FrontLeft = hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        JewelArm = hardwareMap.crservo.get("JewelArm");
        color = hardwareMap.colorSensor.get("color");
        BackRightServo = hardwareMap.servo.get("BackRightServo");
        BackLeftServo = hardwareMap.servo.get("BackLeftServo");
        FrontLeftServo = hardwareMap.servo.get("FrontLeftServo");
        FrontRightServo = hardwareMap.servo.get("FrontRightServo");
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        JewelArm.setDirection(CRServo.Direction.FORWARD);
        BackRightServo.setDirection(Servo.Direction.FORWARD);
        BackLeftServo.setDirection(Servo.Direction.FORWARD);
        FrontLeftServo.setDirection(Servo.Direction.FORWARD);
        FrontRightServo.setDirection(Servo.Direction.REVERSE);
        FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftServo.setPosition(.65);
        BackRightServo.setPosition(0);
        FrontLeftServo.setPosition(1);
        FrontRightServo.setPosition(1);
        
        waitForStart();
        TickToInch = 89;
            FrontLeftServo.setPosition(0);
            FrontRightServo.setPosition(0);
            while (opModeIsActive()){
            JewelArm.setPower(-1);
            sleep(10000);
            JewelArm.setPower(0);
            if (color.blue() > color.red()){
                FrontLeft.setDirection(DcMotor.Direction.FORWARD);
                FrontRight.setDirection(DcMotor.Direction.REVERSE);
                BackLeft.setDirection(DcMotor.Direction.FORWARD);
                BackRight.setDirection(DcMotor.Direction.REVERSE);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontLeft.setTargetPosition(250);
                FrontRight.setTargetPosition(250);
                BackLeft.setTargetPosition(250);
                BackRight.setTargetPosition(250);
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.3);
                FrontRight.setPower(0.3);
                BackLeft.setPower(0.3);
                BackRight.setPower(0.3);
                while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
                FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                sleep(500);
                FrontLeft.setDirection(DcMotor.Direction.REVERSE);
                FrontRight.setDirection(DcMotor.Direction.FORWARD);
                BackLeft.setDirection(DcMotor.Direction.REVERSE);
                BackRight.setDirection(DcMotor.Direction.FORWARD);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontLeft.setTargetPosition(250);
                FrontRight.setTargetPosition(250);
                BackLeft.setTargetPosition(250);
                BackRight.setTargetPosition(250);
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.3);
                FrontRight.setPower(0.3);
                BackLeft.setPower(0.3);
                BackRight.setPower(0.3);
                while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
                FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
            else if (color.red() > color.blue()){
                FrontLeft.setDirection(DcMotor.Direction.REVERSE);
                FrontRight.setDirection(DcMotor.Direction.FORWARD);
                BackLeft.setDirection(DcMotor.Direction.REVERSE);
                BackRight.setDirection(DcMotor.Direction.FORWARD);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontLeft.setTargetPosition(250);
                FrontRight.setTargetPosition(250);
                BackLeft.setTargetPosition(250);
                BackRight.setTargetPosition(250);
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.3);
                FrontRight.setPower(0.3);
                BackLeft.setPower(0.3);
                BackRight.setPower(0.3);
                while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
                FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                sleep(500);
                FrontLeft.setDirection(DcMotor.Direction.FORWARD);
                FrontRight.setDirection(DcMotor.Direction.REVERSE);
                BackLeft.setDirection(DcMotor.Direction.FORWARD);
                BackRight.setDirection(DcMotor.Direction.REVERSE);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontLeft.setTargetPosition(250);
                FrontRight.setTargetPosition(250);
                BackLeft.setTargetPosition(250);
                BackRight.setTargetPosition(250);
                FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                FrontLeft.setPower(0.3);
                FrontRight.setPower(0.3);
                BackLeft.setPower(0.3);
                BackRight.setPower(0.3);
                while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
                FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
            color.enableLed(false);
            JewelArm.setPower(1);
            sleep(2000);
            FrontLeft.setDirection(DcMotor.Direction.REVERSE);
            FrontRight.setDirection(DcMotor.Direction.FORWARD);
            BackLeft.setDirection(DcMotor.Direction.REVERSE);
            BackRight.setDirection(DcMotor.Direction.FORWARD);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeft.setTargetPosition(25*TickToInch);
            FrontRight.setTargetPosition(25*TickToInch);
            BackLeft.setTargetPosition(25*TickToInch);
            BackRight.setTargetPosition(25*TickToInch);
            FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackLeft.setPower(0.3);
            BackRight.setPower(0.3);
            while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
            FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            sleep(500);
            FrontLeft.setDirection(DcMotor.Direction.FORWARD);
            FrontRight.setDirection(DcMotor.Direction.FORWARD);
            BackLeft.setDirection(DcMotor.Direction.FORWARD);
            BackRight.setDirection(DcMotor.Direction.FORWARD);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeft.setTargetPosition(37*TickToInch);
            FrontRight.setTargetPosition(37*TickToInch);
            BackLeft.setTargetPosition(37*TickToInch);
            BackRight.setTargetPosition(37*TickToInch);
            FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackLeft.setPower(0.3);
            BackRight.setPower(0.3);
            while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
            FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            sleep(500);
            FrontLeft.setDirection(DcMotor.Direction.FORWARD);
            FrontRight.setDirection(DcMotor.Direction.REVERSE);
            BackLeft.setDirection(DcMotor.Direction.FORWARD);
            BackRight.setDirection(DcMotor.Direction.REVERSE);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeft.setTargetPosition(13*TickToInch);
            FrontRight.setTargetPosition(13*TickToInch);
            BackLeft.setTargetPosition(13*TickToInch);
            BackRight.setTargetPosition(13*TickToInch);
            FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackLeft.setPower(0.3);
            BackRight.setPower(0.3);
            while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
            FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            sleep(500);
            BackLeftServo.setPosition(0.5);
            BackRightServo.setPosition(0.15);
            sleep(500);
            FrontLeft.setDirection(DcMotor.Direction.REVERSE);
            FrontRight.setDirection(DcMotor.Direction.FORWARD);
            BackLeft.setDirection(DcMotor.Direction.REVERSE);
            BackRight.setDirection(DcMotor.Direction.FORWARD);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeft.setTargetPosition(3*TickToInch);
            FrontRight.setTargetPosition(3*TickToInch);
            BackLeft.setTargetPosition(3*TickToInch);
            BackRight.setTargetPosition(3*TickToInch);
            FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeft.setPower(0.3);
            FrontRight.setPower(0.3);
            BackLeft.setPower(0.3);
            BackRight.setPower(0.3);
            while (FrontLeft.isBusy() && FrontRight.isBusy() && BackLeft.isBusy() && BackRight.isBusy() && opModeIsActive()){}
            FrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            JewelArm.setPower(0);
            break;
            
            /*FrontLeftMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRightMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeftMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRightMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeftMech.setTargetPosition(1*InchInRev);
            FrontRightMech.setTargetPosition(1*InchInRev);
            BackLeftMech.setTargetPosition(1*InchInRev);
            BackRightMech.setTargetPosition(1*InchInRev);
            LeftWheel.setTargetPosition(1*InchInRev);
            RightWheel.setTargetPosition(1*InchInRev);
            FrontLeftMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRightMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeftMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRightMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeftMech.setPower(.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(.3);
            RightWheel.setPower(.3);
            while (FrontLeftMech.isBusy() && FrontRightMech.isBusy() && BackLeftMech.isBusy() && BackRightMech.isBusy() && LeftWheel.isBusy() && RightWheel.isBusy() && opModeIsActive()){}
            FrontLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
            
            /*FrontLeftMech.setPower(.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(.3);
            RightWheel.setPower(.3);
            sleep(2000);
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            sleep(500);
            FrontLeftMech.setPower(-.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(-.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(-.3);
            RightWheel.setPower(.3);
            sleep(1700);
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            sleep(500);
            FrontLeftMech.setPower(-.3);
            FrontRightMech.setPower(-.3);
            BackLeftMech.setPower(-.3);
            BackRightMech.setPower(-.3);
            LeftWheel.setPower(-.3);
            RightWheel.setPower(-.3);
            sleep(1000);
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            sleep(500);
            BackLeftClaw.setPosition(0);
            BackRightClaw.setPosition(1);
            sleep(1000);
            FrontLeftMech.setPower(.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(.3);
            RightWheel.setPower(.3);
            sleep(750);
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            sleep(500);
            FrontLeftMech.setPower(-.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(-.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(-.3);
            RightWheel.setPower(.3);
            sleep(1250);
            FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);
            sleep(500);*/
            
            /*FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);*/
            
            /*RotateBlock.setPower(.5);
            sleep(200);
            RotateBlock.setPower(0);
            sleep(2000);
            /*RotateBlock.setPower(-.33);
            sleep(200);
            RotateBlock.setPower(0);*/
            /*sleep(50000);*/
            
            /*LeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftWheel.setTargetPosition(-1*InchInRev);
            RightWheel.setTargetPosition(1*InchInRev);
            LeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftWheel.setPower(1);
            RightWheel.setPower(1);
            while (LeftWheel.isBusy() && RightWheel.isBusy() && opModeIsActive()){}
            LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
            
            /*RotateBlock.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RotateBlock.setTargetPosition(1*InchInRev);
            RotateBlock.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RotateBlock.setPower(1);
            while (RotateBlock.isBusy() && opModeIsActive()){}
            RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RotateBlock.setPower(0);
            
            sleep(50000);*/
        }
    }
}
