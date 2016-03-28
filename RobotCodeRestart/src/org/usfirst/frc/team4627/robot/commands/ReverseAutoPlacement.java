package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ReverseAutoPlacement extends CommandGroup {
    
    public  ReverseAutoPlacement() {
        
    	addSequential(new Wait(1));
    	addSequential(new SetDriveMotors(-0.4));
    	addSequential(new Wait(3));
    	addSequential(new SetDriveMotors(0));
    	
    }
}
