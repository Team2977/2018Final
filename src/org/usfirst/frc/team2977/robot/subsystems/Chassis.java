package org.usfirst.frc.team2977.robot.subsystems;


import org.usfirst.frc.team2977.robot.Robot;
//import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team2977.robot.commands.GyroTurn;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {

	//Declaring motor controllers
	//Talon left = new Spark(RobotMap.LeftDriveMotor);
	//Spark right = new Spark(RobotMap.RightDriveMotor);
	//Talon fR = new Talon(2);
	//Talon fL = new Talon(4);
	//Talon bR = new Talon(3);
	//Talon bL = new Talon(5);

	WPI_TalonSRX leftF = new WPI_TalonSRX(RobotMap.LeftDriveMotor);
	WPI_TalonSRX rightF = new WPI_TalonSRX(RobotMap.RightDriveMotor);
	WPI_TalonSRX leftB = new WPI_TalonSRX(RobotMap.LeftDriveMotorRev);
	WPI_TalonSRX rightB = new WPI_TalonSRX(RobotMap.RightDriveMotorRev);
	
	
	
	public AnalogInput ultraSonicFront = new AnalogInput(3);
	public AnalogInput ultraSonicBack = new AnalogInput(0);
	double deadZone = 0.2;
	double test = 0;
	
	//Delcaring interger for drive mode switch
	/** 1 is arcade, 2 is tank. Feel free to switch it above to driver preference. 
	 	If it gets set above 2 or below 1 it will probably break so please dont do anything crazy.
	 **/
	public int DriveMode = 1;
	public int Speed = 1;
	
	
	//Declaring sensors and anything else
	public ADXRS450_Gyro gyro = new ADXRS450_Gyro();	//This is our gyro. does not require port because it is plugged into the SPI on RoboRIO
	//double angle = gyro.getAngle();
	//public double angle = gyro.getAngle();
	Compressor compressor = new Compressor();
	
	public double gyroAngle() {
		return gyro.getAngle();
	}
	
	public double backUltra() {
		double ultra = ultraSonicBack.getVoltage() * 9.2;
		SmartDashboard.putNumber("BACK ULTRA", ultra);
		return ultra;
	}
	
	public double frontUltra() {
		double ultra = ultraSonicFront.getVoltage() * 9.2;
		SmartDashboard.putNumber("FRONT ULTRA", ultra);
		return ultra;
	}

	public void Driving(double LeftY, double LeftX) {
		leftF.set(LeftY - LeftX/1.5);
		leftB.set(LeftY - LeftX/1.5);
		rightF.set(-LeftY - LeftX/1.5);
		rightB.set(-LeftY - LeftX/1.5);
		SmartDashboard.putBoolean("ARM STATUS", !Robot.pneu.lowerArm.get());
		SmartDashboard.putNumber("ULTRA", backUltra());
		SmartDashboard.putNumber("GYRO", gyro.getAngle());
		
		double ultra = ultraSonicFront.getVoltage();
		SmartDashboard.putNumber("FRONT ULTRA", ultra);
		//backUltra();
		//frontUltra();
	}
	
	public void Driving(double LeftY) {
		leftF.set(LeftY/1.4);
		leftB.set(LeftY/1.4);
		rightF.set(-LeftY/2.2);
		rightB.set(-LeftY/2.2);
		SmartDashboard.putBoolean("ARM STATUS", !Robot.pneu.lowerArm.get());
		SmartDashboard.putNumber("ULTRA", backUltra());
		SmartDashboard.putNumber("GYRO", gyro.getAngle());
		
		double ultra = ultraSonicFront.getVoltage();
		SmartDashboard.putNumber("FRONT ULTRA", ultra);
		//backUltra();
		//frontUltra();
	}

	public void DriveStraight(double speed) {
		double distance = ultraSonicFront.getVoltage();
		if (distance > .5) {
		leftF.set(speed);
		leftB.set(speed);
		rightF.set(-speed);
		rightB.set(-speed);
		}
		if (distance < .5 ) {
			leftF.set(speed/2);
			leftB.set(speed/2);
			rightF.set(-speed/2);
			rightB.set(-speed/2);
		}
		if(distance < .065) {
			org.usfirst.frc.team2977.robot.commands.DriveStraight.isDone = true;
		}
		else org.usfirst.frc.team2977.robot.commands.DriveStraight.isDone = false;
	}
	
	public void DriveWithBackUltraFar(double distance){ //17 ft
		double speed = 1;
		if (backUltra() < (distance + 6)) { //was 11
			leftF.set(speed);
			leftB.set(speed);
			rightF.set(-speed);
			rightB.set(-speed);
			}
			if (backUltra() > (distance + 4) ) { //was 13
				leftF.set(speed/9);
				leftB.set(speed/9);
				rightF.set(-speed/9);
				rightB.set(-speed/9);
			}
			if(backUltra() > (distance + 1)) { //was 15
				org.usfirst.frc.team2977.robot.commands.DriveBackUltraFar.isDone = true;
			}
			//else org.usfirst.frc.team2977.robot.commands.DriveBackUltraFar.isDone = false;
	}
	
	
	public void DriveWithBackUltraNear(double distance){ //17 ft
		double speed = .7;
		if (backUltra() < (distance - 3)) { //was 11
			leftF.set(speed);
			leftB.set(speed);
			rightF.set(-speed);
			rightB.set(-speed);
			}
			if (backUltra() > (distance - 2) ) { //was 13
				leftF.set(speed/9);
				leftB.set(speed/9);
				rightF.set(-speed/9);
				rightB.set(-speed/9);
			}
			if(backUltra() > (distance - 1)) { //was 15
				org.usfirst.frc.team2977.robot.commands.DriveBackUltraNear.isDone = true;
			}
			else org.usfirst.frc.team2977.robot.commands.DriveBackUltraNear.isDone = false;
	}
	
	public void GyroTurnRight(double angle, double speed) {
		SmartDashboard.putNumber("ANGLE", angle);
			leftF.set(speed);
			leftB.set(speed);
			rightF.set(speed);
			rightB.set(speed);

			if(gyroAngle() < angle + 5 && gyroAngle() > angle - 5){
				leftF.set(0);
				leftB.set(0);
				rightF.set(0);
				rightB.set(0);
				GyroTurn.isDone = true;
			}
		
	}
	public void GyroTurnLeft(double angle) {
		SmartDashboard.putNumber("ANGLE", angle);
		double speed = .7;
			leftF.set(-speed);
			leftB.set(-speed);
			rightF.set(-speed);
			rightB.set(-speed);

			if(gyroAngle() < angle + 5 && gyroAngle() > angle - 5){
				leftF.set(0);
				leftB.set(0);
				rightF.set(0);
				rightB.set(0);
				GyroTurn.isDone = true;
			}
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
}

