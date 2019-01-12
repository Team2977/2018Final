package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ChillCommands extends CommandGroup {

    public ChillCommands() {
        //This command does nothing so it doesnt break anything. great for testing things!
    	addSequential(new WaitCommand(1));
    }
}
