package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PneumaticCommands extends Command {

	int num; 
	int i;
    public PneumaticCommands(int numbers) {
    	this.num = numbers;
    	requires(Robot.pneu);
    	Robot.pneu.done = false;
    }

    public static boolean isDone = false;

    protected void initialize() {
    	i = num;
    	isDone = false;
    }

    protected void execute() {
    	if (i == 2) {
    		Robot.pneu.BottomClawOpen();
    	}
    	if (i == 1) { 
    		Robot.pneu.BottomClawClosed();
    	}
    	if (i == 3) {  
    		Robot.pneu.LowArmUp();
    	}              
    	if (i == 4) {  
    		Robot.pneu.LowArmDown();
    	}
    	if (i == 5) {
    		Robot.pneu.TopClawOpen();
    	}
    	if (i == 6) {
    		Robot.pneu.TopClawClosed();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
