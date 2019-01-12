package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LeftScaleAuto extends CommandGroup {

    public LeftScaleAuto() {
    	/**
    	addSequential(new PneumaticCommands(6));
    	addSequential(new PneumaticCommands(2));
    	addSequential(new GoForwardTimed(.25));
    	addSequential(new GyroTurn(6, .2));
    	addSequential(new DriveBackUltraNear(22));
        addSequential(new WaitCommand(.5));
        addParallel(new ArmLiftForTime(4.35));
        addSequential(new WaitCommand(3.8));
        addSequential(new GoForwardTimed(.45));
        addSequential(new WaitCommand(.5));
        addSequential(new GyroTurn(83, .7));
        addSequential(new GoForwardTimed(1));
        addSequential(new PneumaticCommands(5));
        addSequential(new WaitCommand(.2));
        addSequential(new PneumaticCommands(5));
        addSequential(new WaitCommand(1));
        addSequential(new PneumaticCommands(6));
        **/
    	
    	addSequential(new PneumaticCommands(6));
    	addSequential(new PneumaticCommands(2));
    	addSequential(new DriveBackUltraNear(18));
    }
}
