package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GuidersOutAuto extends Command {

	double speed;
    public GuidersOutAuto(double spee) {
    	spee = speed;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.guiders);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.guiders.GuidersSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.guiders.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//Robot.guiders.Stop();
    }
}
