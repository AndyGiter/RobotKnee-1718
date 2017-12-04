package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.RobotLog;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorImpl;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous

public class NewRobotAuto extends LinearOpMode{

    DcMotor FrontRightMech;
    DcMotor FrontLeftMech;
    DcMotor BackRightMech;
    DcMotor BackLeftMech;
    DcMotor LeftWheel;
    DcMotor RightWheel;
    DcMotor RotateBlock;
    Servo BackRightClaw;
    Servo BackLeftClaw;

    @Override public void runOpMode() {
        FrontLeftMech = hardwareMap.dcMotor.get("FrontLeftMech");
        FrontRightMech = hardwareMap.dcMotor.get("RightWheel");
        BackLeftMech = hardwareMap.dcMotor.get("BackLeftMech");
        BackRightMech = hardwareMap.dcMotor.get("BackRightMech");
        LeftWheel = hardwareMap.dcMotor.get("LeftWheel");
        RightWheel =hardwareMap.dcMotor.get("FrontRightMech");
        RotateBlock = hardwareMap.dcMotor.get("RotateBlock");
        BackRightClaw = hardwareMap.servo.get("BackRightClaw");
        BackLeftClaw = hardwareMap.servo.get("BackLeftClaw");
        FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
        FrontRightMech.setDirection(DcMotor.Direction.FORWARD);
        BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
        BackRightMech.setDirection(DcMotor.Direction.FORWARD);
        LeftWheel.setDirection(DcMotor.Direction.REVERSE);
        RightWheel.setDirection(DcMotor.Direction.FORWARD);
        BackRightClaw.setDirection(Servo.Direction.FORWARD);
        BackLeftClaw.setDirection(Servo.Direction.FORWARD);
        RotateBlock.setDirection(DcMotor.Direction.REVERSE);
        /*FrontLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
        /*RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
        BackLeftClaw.setPosition(.65);
        BackRightClaw.setPosition(0);
        
        int InchInRev = 500;
        
        waitForStart();
        
        while (opModeIsActive()){
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
            
            FrontLeftMech.setPower(.3);
            FrontRightMech.setPower(.3);
            BackLeftMech.setPower(.3);
            BackRightMech.setPower(.3);
            LeftWheel.setPower(.3);
            RightWheel.setPower(.3);
            sleep(2500);
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
            sleep(2500);
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
            sleep(1000);
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
            sleep(500);
            
            /*FrontLeftMech.setPower(0);
            FrontRightMech.setPower(0);
            BackLeftMech.setPower(0);
            BackRightMech.setPower(0);
            LeftWheel.setPower(0);
            RightWheel.setPower(0);*/
            
            RotateBlock.setPower(.2);
            sleep(500);
            RotateBlock.setPower(0);
            sleep(500);
            RotateBlock.setPower(-.2);
            sleep(500);
            RotateBlock.setPower(0);
            sleep(50000);
            
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
