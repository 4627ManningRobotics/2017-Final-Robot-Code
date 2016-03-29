package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement4Reverse extends CommandGroup {
   
    public  AutoPlacement4Reverse() {
    
    	addSequential(new Wait(1));
    	addSequential(new AutoTurn(-5));
    	addSequential(new SetDriveMotors(0));
    	addSequential(new Wait(0.42));
    	addSequential(new SetDefenseShotAng());
    	addSequential(new Wait(0.7));
    	addSequential(new AutoTargetingX());
    	addSequential(new SetPostAngle());
    	addSequential(new AutoTargetingY());
    	addSequential(new AutoShoot());
    	addSequential(new AutoTurn(Robot.sensors.preAngle - Robot.sensors.postAngle));
    	addSequential(new SetArmPosition(Robot.armPositionAuto));
    	addSequential(new Wait(1));
    	addSequential(new SetDriveMotors(-0.4));
    	addSequential(new Wait(3));
    	addSequential(new SetDriveMotors(0));
    
    }
}
