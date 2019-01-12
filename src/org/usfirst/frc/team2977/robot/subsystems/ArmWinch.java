package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmWinch extends Subsystem {

	public WPI_TalonSRX arm = new WPI_TalonSRX(RobotMap.armMotor);
	
	WPI_TalonSRX winch1 = new WPI_TalonSRX(6);
	WPI_TalonSRX winch2 = new WPI_TalonSRX(7);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void ArmDown() {
		arm.set(.5);
		SmartDashboard.putNumber("Arm Value", ArmEncoder());
	}
	
	public void ArmUp() {
		arm.set(-.3);
		SmartDashboard.putNumber("Arm Value", ArmEncoder());
	}
	
	public void ArmIdle() {
		arm.set(0);
		SmartDashboard.putNumber("Arm Value", ArmEncoder());
	}
	
	public double ArmEncoder() {
		return arm.getSelectedSensorPosition(0);
	}

	
	public void WinchDown() {
		winch1.set(-.75);
		winch2.set(-.75);
	}
	
	public void WinchUp() {
		winch1.set(.75);
		winch2.set(.75);
	}
	
	public void WinchStop() {
		winch1.set(0);
		winch2.set(0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

