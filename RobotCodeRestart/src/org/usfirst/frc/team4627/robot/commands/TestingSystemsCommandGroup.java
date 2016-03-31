package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestingSystemsCommandGroup extends CommandGroup {
    
    public  TestingSystemsCommandGroup() {
        
    	addSequential(new ShiftLow());
    	addSequential(new ResetChupasEncoder());
    	addSequential(new AutoTurn(30));
    	addSequential(new AutoTurn(-60));
    	addSequential(new AutoTurn(30));
    	addSequential(new SetShootSpeed(1));
    	addSequential(new Wait(1));
    	addSequential(new SetShootSpeed(-1));
    	addSequential(new Wait(1));
    	addSequential(new SetShootSpeed(0));
    	addSequential(new SetArmPosition(RobotMap.EL_CHUPAS_MAX_POSITION));
    	addSequential(new Wait(1));
    	addSequential(new SetArmPosition(0));
    	addSequential(new AutoShoot());
    	addSequential(new ShiftHigh());
    	addSequential(new ShiftLow());
    	
    	
    }
}
