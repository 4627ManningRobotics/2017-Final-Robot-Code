package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement4Reverse extends CommandGroup {
   
    public  AutoPlacement4Reverse() {
    
    	addSequential(new Wait(0.2));
    	addSequential(new SetArmPosition(900));
    	addSequential(new Wait(1));
    	addSequential(new AutoTargetingX());
    	addSequential(new Wait(0.1));
    	addSequential(new AutoTargetingX());
    	addSequential(new SetPostAngle());
    	addSequential(new AutoTargetingY());
    	addSequential(new Wait(0.1));
    	addSequential(new AutoTargetingY());
    	//(new SetArmPosition(Robot.elChupaArms.motorPosition + 20));
    	addSequential(new Wait(1));
    	addSequential(new AutoShoot());
    }
}
