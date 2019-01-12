package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LeftSwitchAuto extends CommandGroup {

    public LeftSwitchAuto() {
    	addSequential(new PneumaticCommands(6));
    	addSequential(new PneumaticCommands(2));
    	addSequential(new DriveBackUltraNear(10));
    	addParallel(new ArmLiftForTime(1.7)); 
    	addSequential(new WaitCommand(1));
    	addSequential(new GyroTurn(66, .7));
    	addSequential(new DriveStraight());
        addSequential(new PneumaticCommands(5));
    }
}
