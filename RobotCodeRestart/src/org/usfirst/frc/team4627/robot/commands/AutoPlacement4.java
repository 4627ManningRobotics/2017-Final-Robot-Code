package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement4 extends CommandGroup {
    
    public  AutoPlacement4() {
    	
    	addSequential(new Wait(1));
    	addSequential(new DefenseShotAngleSet());
    	addSequential(new Wait(0.7));
    	addSequential(new AutoTargetingX());
    	addSequential(new TheAligner());
    	
    	
    }
}
