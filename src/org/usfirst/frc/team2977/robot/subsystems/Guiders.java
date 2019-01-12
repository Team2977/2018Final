package org.usfirst.frc.team2977.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Guiders extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon guider = new Talon(1);
	
	//Encoder sampleEncoder = new Encoder(1, 2, false, Encoder.EncodingType.k4X);
	Encoder RightEncoder = new Encoder(1, 2);
	int rightCount = RightEncoder.get();
	double rightDistance = RightEncoder.getRaw();
	double rightRate = RightEncoder.getRate();
	boolean direction = RightEncoder.getDirection();
	boolean stopped = RightEncoder.getStopped();
	
	
	public void GuidersOut() {
		guider.set(.5);
	}
	
	public void GuidersIn() {
		guider.set(-.5);
	}
	
	public void Stop() {
		guider.set(0);
	}
	
	public void GuidersSpeed(double speed) {
		guider.set(speed);
	}
	
	public void Information() {
		int count = RightEncoder.get();
		
		SmartDashboard.putNumber("count", count);
		SmartDashboard.putNumber("revolutions", count/500);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new org.usfirst.frc.team2977.robot.commands.GuidersOut());
    }
}

