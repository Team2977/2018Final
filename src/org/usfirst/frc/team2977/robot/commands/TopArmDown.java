package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TopArmDown extends Command {
	
	static DigitalInput armLimit = new DigitalInput(4);

    public TopArmDown() {
    	requires(Robot.armwinch);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armwinch.ArmDown();
    	SmartDashboard.putBoolean("Arm down", ArmStatus());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    
    public static boolean ArmStatus(){
    	return armLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armwinch.ArmIdle();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.armwinch.ArmIdle();
    }
}
