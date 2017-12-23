package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by orange on 23/12/17.
 */
@Autonomous(name="AutonomousTest", group="Autonomous")
public class AutonomousTest extends LinearOpMode
{
    private DcMotor leftWheel;
    private DcMotor rightWheel;
    private DcMotor liftMotor;

    Servo leftClaw;
    Servo rightClaw;
    Servo leftArm;
    Servo rightArm;

    double leftWheelPower;
    double rightWheelPower;

    double leftArmDefaultPosition = 0.45;
    double rightArmDefaultPosition = 0.45;

    double leftArmPosition = 1.00;
    double rightArmPosition= 0.00;

    @Override
    public void runOpMode() throws InterruptedException
    {
        leftWheel = hardwareMap.dcMotor.get("left_wheel");
        rightWheel = hardwareMap.dcMotor.get("right_wheel");
        liftMotor = hardwareMap.dcMotor.get("lift_motor");

        leftClaw = hardwareMap.servo.get("left_claw");
        rightClaw = hardwareMap.servo.get("right_claw");
        leftArm = hardwareMap.servo.get("left_arm");
        rightArm = hardwareMap.servo.get("right_arm");

        //Wait for driver to press PLAY
        waitForStart();

        leftClaw.setPosition(0.5);
        rightClaw.setPosition(0.5);

        leftArm.setPosition(leftArmDefaultPosition);
        rightArm.setPosition(rightArmDefaultPosition);

        rightWheel.setDirection(DcMotorSimple.Direction.REVERSE);

        ElapsedTime elapsedTime = new ElapsedTime();

        elapsedTime.reset();

        while(elapsedTime.time() < 30.0)
        {

        }

        leftWheel.setPower(0.0);
        rightWheel.setPower(0.0);
        liftMotor.setPower(0.0);
        leftClaw.setPosition(0.5);
        rightClaw.setPosition(0.5);
        leftArm.setPosition(0.45);
        rightArm.setPosition(0.45);
    }

}
