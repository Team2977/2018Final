package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.Wheels;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeWheels extends Subsystem {

	Talon wheels = new Talon(0);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void WheelsMove(double speed) {
		wheels.set(speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Wheels());
    }
}

