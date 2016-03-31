package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestingSystemsCommandGroup extends CommandGroup {
    
    public  TestingSystemsCommandGroup() {
        
    	addSequential(new AutoTurn(30));
    	addSequential(new AutoTurn(-60));
    	addSequential(new AutoTurn(30));
    	//addSequential(new )
    	
    }
}
