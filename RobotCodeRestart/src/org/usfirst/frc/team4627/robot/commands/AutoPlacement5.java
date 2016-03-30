package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement5 extends CommandGroup {
    
    public  AutoPlacement5() {
    	
    	addSequential(new Wait(1));
    	addSequential(new AutoTurn(-15));
    	addSequential(new SetDriveMotors(0));
    	addSequential(new Wait(0.42));
    	addSequential(new SetDefenseShotAng());
    	addSequential(new Wait(0.7));
    	addSequential(new AutoTarget());
    	
    	
    }
}
