package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTargetingX extends CommandGroup {
    
    public  AutoTargetingX() {
    	addSequential(new AutoTargetingXCoarse());
    	addSequential(new Wait(0.5));
    //	addSequential(new AutoTargetingXFine());
    //	addSequential(new Wait(0.5));
    }
}
