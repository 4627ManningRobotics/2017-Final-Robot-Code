package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTarget extends CommandGroup {
    
    public  AutoTarget() {
    	addSequential(new AutoTargetingX());
    	addSequential(new AutoTargetingY());
    	addSequential(new AutoShoot());
    }
}
