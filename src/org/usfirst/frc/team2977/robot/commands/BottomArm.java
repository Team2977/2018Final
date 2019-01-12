package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BottomArm extends Command {

	int num;
	int i;
    public BottomArm(int numbers) {
    	num = numbers;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneu);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = num;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (i == 1) { //Lift bottom arm
    		
    	}
    	else if (i == 2) { // Lower bottom arm
    		
    	}
    	else {
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
