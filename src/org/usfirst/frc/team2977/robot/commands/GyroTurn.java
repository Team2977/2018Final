package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurn extends Command {

	public static boolean isDone = false;
	double angle;
	double speed;
    public GyroTurn(double d, double s) {
    	angle = d;
    	speed = s;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.chassis.gyro.reset();
    	isDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (angle > 0) {
    		Robot.chassis.GyroTurnRight(angle, speed);
    		}
    	else if (angle < 0){
    		Robot.chassis.GyroTurnLeft(angle);
    		}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.DriveStraight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
