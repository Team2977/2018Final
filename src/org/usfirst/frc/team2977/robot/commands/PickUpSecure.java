package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class PickUpSecure extends CommandGroup {

    public PickUpSecure() {
        // Add Commands here:
    	addSequential(new PneumaticCommands(4)); //Lower Arm
        addSequential(new WaitCommand(1.25));
        addSequential(new PneumaticCommands(1)); //Bottom Claw Close
        addSequential(new WaitCommand(.5));
        addSequential(new PneumaticCommands(3));
        addSequential(new WaitCommand(2));
        addSequential(new PneumaticCommands(6));
        //addSequential(new WaitCommand(.5));
        
        
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
