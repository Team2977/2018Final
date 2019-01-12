package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GuidersOut extends Command {

	double speed;
    public GuidersOut() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.guiders);
    }

    static boolean isDone =  false;
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	isDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.guiders.GuidersSpeed(Robot.m_oi.getLeftY2()/2);
    }


    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.guiders.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.guiders.Stop();
    }
}
