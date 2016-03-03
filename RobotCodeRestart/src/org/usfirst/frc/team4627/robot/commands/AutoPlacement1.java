package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoPlacement1 extends CommandGroup {
    
    public  AutoPlacement1() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
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
    	
    	
    	
        /*
         * Pseudo-code for Placement One
         * 
         * Set to 0.75 speed
         * 
         * wait 0.75
         * 
         * Zero motors
         * 
         * Set Chupas motor position to defense shot angle in RobotMap
         * set the Chupas motor
         * 
         * wait 2 seconds
         * schedule AutoTargeting
         * 
         */
    	
    	
    	
    	
    	
    	addSequential(new AutoPlacement1_Base1());
    	addSequential(new Wait());
    	addSequential(new StopDriveMotors());
    	addSequential(new DefenseShotAngleSet());
    	addSequential(new AutoTargetingShoot());
    	
    	
    }
}
