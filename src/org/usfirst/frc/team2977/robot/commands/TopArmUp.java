package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TopArmUp extends Command {

    public TopArmUp() {
    	requires(Robot.armwinch);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    boolean isDone = false;
    // Called just before this Command runs the first time
    protected void initialize() {

    	isDone = false;
    }

    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.armwinch.ArmEncoder() > 1220) {
    		isDone = true;
    	}
    	else {
    	Robot.armwinch.ArmUp();
    	SmartDashboard.putBoolean("Arm down", TopArmDown.ArmStatus());
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
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
