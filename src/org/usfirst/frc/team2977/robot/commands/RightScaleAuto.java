package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RightScaleAuto extends CommandGroup {

    public RightScaleAuto() {
    	/**
    	addSequential(new PneumaticCommands(6));
    	addSequential(new PneumaticCommands(2));
    	addSequential(new GoForwardTimed(.50));
    	addSequential(new GyroTurn(1, .2));
    	addSequential(new DriveBackUltraNear(19));
    	addSequential(new GoForwardTimed(.25));
        addSequential(new WaitCommand(.5));
        addParallel(new ArmLiftForTime(4.5));
        addSequential(new WaitCommand(4));
        addSequential(new GoForwardTimed(.45));
        addSequential(new WaitCommand(.5));
        addSequential(new GyroTurn(-86, .7));
        addSequential(new GoForwardTimed(1));
        addSequential(new PneumaticCommands(5));
        addSequential(new WaitCommand(.2));
        addSequential(new PneumaticCommands(5));
        addSequential(new WaitCommand(1));
        addSequential(new PneumaticCommands(6));
        **/
    	addSequential(new PneumaticCommands(6));
    	addSequential(new PneumaticCommands(2));
    	addSequential(new GoForwardTimed(.50));
    	addSequential(new GyroTurn(6, .2));
    	addParallel(new ArmLiftForTime(4.5));
    	addSequential(new DriveBackUltraNear(19));
    	addSequential(new GyroTurn(-6, .4));
    	addSequential(new GoForwardTimed(.50));
    	addSequential(new WaitCommand(.5));
        addSequential(new TopArmStop());
        addSequential(new GyroTurn(-35, .2));
        addSequential(new GoForwardTimed(.50));
        addSequential(new PneumaticCommands(5));
        
    	//addSequential(new GyroTurn(25, .6));
    }
}
