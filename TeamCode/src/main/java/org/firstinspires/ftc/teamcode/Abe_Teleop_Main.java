package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by 500260501 on 13/11/2017.
 */
@TeleOp(name="Gamepad Drive", group="Teleop")
//@Disabled
public class Abe_Teleop_Main extends OpMode
{
    private OPModeConstants opModeConstants = OPModeConstants.getInstance();

    DcMotor leftWheel;
    DcMotor rightWheel;
    DcMotor liftMotor;

    Servo leftClaw;
    Servo rightClaw;
    //Servo leftArm;

    double leftWheelPower;
    double rightWheelPower;

    double yValue, xValue;

    @Override
    public void init()
    {
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");
        liftMotor = hardwareMap.dcMotor.get("lift_motor");

        leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftClaw = hardwareMap.servo.get("left_claw");
        rightClaw = hardwareMap.servo.get("right_claw");
        //leftArm = hardwareMap.servo.get("left_arm");
        //leftArm.setPosition(0.00);


        leftClaw.setPosition(0.35);
        rightClaw.setPosition(0.65);

        //leftWheel.setDirection(DcMotorSimple.Direction.FORWARD);
        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop()
    {
        yValue = gamepad1.left_stick_y;
        xValue = gamepad1.right_stick_x;

        leftWheelPower =  (yValue + xValue) * 0.5;
        rightWheelPower = (yValue - xValue) * 0.5;

        leftWheel.setPower(Range.clip(leftWheelPower, -1.0, 1.0));
        rightWheel.setPower(Range.clip(rightWheelPower, -1.0, 1.0));

        //Controlling the claw with the triggers
        //Open claw
        if(gamepad1.left_trigger > 0.01)
        {
            leftClaw.setPosition(0.35);
            rightClaw.setPosition(0.65);
        }
        //Close claw
        if(gamepad1.right_trigger > 0.01)
        {
            leftClaw.setPosition(0.70);
            rightClaw.setPosition(0.30);
        }

        //Controlling the lift mechanism using y and a buttons
        if(gamepad1.a)
        {
            liftMotor.setPower(1.0);
        }
        else if(gamepad1.y)
        {
            liftMotor.setPower(-1.0);
        }
        else
        {
            liftMotor.setPower(0.0);
        }

        //Setting ALLSTOP in case of malfunction

    }
}