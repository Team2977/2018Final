package org.usfirst.frc.team2977.robot;

public class RobotMap {
	
	/** XBOX Controller Mapping **/
	/** It's also in the OI **/
	public static int A = 1;
	public static int B = 2;
	public static int X = 3;
	public static int Y = 4;
	public static int LB = 5;
	public static int RB = 6;
	public static int Back = 7;
	public static int Start = 8;
	public static int L3 = 9;
	public static int R3 = 10;
	
	
	/** Motors **/
	public static int RightDriveMotor = 2;
	public static int LeftDriveMotor = 4;
	public static int RightDriveMotorRev = 3;
	public static int LeftDriveMotorRev = 5;
	public static int armMotor = 8;
	
	//these are not completed yet, just doing this for testing purposes
	public static int guiderRightMotor = 6;
	public static int guiderLeftMotor = 6;
	public static int guiderRightWheel = 6;
	public static int guiderLeftWheel = 6;
	
	/** Sensors **/
	//not sure about these ports yet so not gonna worry about it quite yet.
	public static int UltraSonicFront = 0;
	public static int UltraSonicBack = 1;
	public static int TopClawLimit = 4;
	public static int BottomClawLimit = 5;
	public static int BottomArmExtenderLimit = 6;
	
	//encoders for guiders
	public static int guiderRightEncoderA = 1;
	public static int guiderRightEncoderB = 2;
	public static int guiderLeftEncoderA = 1;
	public static int guiderLeftEncoderB = 2;
	
	/** Pneumatics **/
	public static int Compressor = 1;
	public static int BottomPushOutSolenoid = 0;
	public static int BottomPushInSolenoid = 1;	
	public static int TopPushInSolenoid = 5;
	public static int TopPushOutSolenoid = 4;
	public static int ArmUpSolenoid = 3;
	public static int ArmDownSolenoid = 2;
}