package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

    @Override public void runOpMode() {
        FrontLeftMech = hardwareMap.dcMotor.get("FrontLeftMech");
        FrontRightMech = hardwareMap.dcMotor.get("FrontRightMech");
        BackLeftMech = hardwareMap.dcMotor.get("BackLeftMech");
        BackRightMech = hardwareMap.dcMotor.get("BackRightMech");
        LeftWheel = hardwareMap.dcMotor.get("LeftWheel");
        RightWheel =hardwareMap.dcMotor.get("RightWheel");
        RotateBlock = hardwareMap.dcMotor.get("RotateBlock");
        FrontLeftMech.setDirection(DcMotor.Direction.REVERSE);
        FrontRightMech.setDirection(DcMotor.Direction.FORWARD);
        BackLeftMech.setDirection(DcMotor.Direction.REVERSE);
        BackRightMech.setDirection(DcMotor.Direction.FORWARD);
        LeftWheel.setDirection(DcMotor.Direction.REVERSE);
        RightWheel.setDirection(DcMotor.Direction.FORWARD);
        FrontLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FrontRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BackRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        int InchInRev = 10000;
        
        waitForStart();
        
        while (opModeIsActive()){
            FrontLeftMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontRightMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackLeftMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BackRightMech.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            FrontLeftMech.setTargetPosition(3*InchInRev);
            FrontRightMech.setTargetPosition(3*InchInRev);
            BackLeftMech.setTargetPosition(3*InchInRev);
            BackRightMech.setTargetPosition(3*InchInRev);
            LeftWheel.setTargetPosition(3*InchInRev);
            RightWheel.setTargetPosition(3*InchInRev);
            FrontLeftMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontRightMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackLeftMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BackRightMech.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            FrontLeftMech.setPower(1);
            FrontRightMech.setPower(1);
            BackLeftMech.setPower(1);
            BackRightMech.setPower(1);
            LeftWheel.setPower(1);
            RightWheel.setPower(1);
            while (FrontLeftMech.isBusy() && FrontRightMech.isBusy() && BackLeftMech.isBusy() && BackRightMech.isBusy() && LeftWheel.isBusy() && RightWheel.isBusy() && opModeIsActive()){}
            FrontLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FrontRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackLeftMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BackRightMech.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            
            LeftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            LeftWheel.setTargetPosition(-1*InchInRev);
            RightWheel.setTargetPosition(1*InchInRev);
            LeftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            LeftWheel.setPower(1);
            RightWheel.setPower(1);
            while (LeftWheel.isBusy() && RightWheel.isBusy() && opModeIsActive()){}
            LeftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            RightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            
            RotateBlock.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RotateBlock.setTargetPosition(1*InchInRev);
            RotateBlock.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RotateBlock.setPower(1);
            while (RotateBlock.isBusy() && opModeIsActive()){}
            RotateBlock.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
}
