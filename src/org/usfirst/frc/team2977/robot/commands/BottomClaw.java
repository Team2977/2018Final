package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class BottomClaw extends Command {
	String m;

    public BottomClaw() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.pneu);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (m == "Open" || m == "open") { //Open bottom claw
    		Robot.pneu.BottomClawOpen();
    	}
    	else if (m == "Close" || m == "close") { //Close bottom claw
    		Robot.pneu.BottomClawClosed();
    	}
    	else {
    		SmartDashboard.putBoolean("Error: Bottom Claw", true);
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
