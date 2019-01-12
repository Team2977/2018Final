package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TopArmUpOverride extends Command {

	boolean isDone = false;
    public TopArmUpOverride() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.armwinch);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	isDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armwinch.ArmUp();
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
