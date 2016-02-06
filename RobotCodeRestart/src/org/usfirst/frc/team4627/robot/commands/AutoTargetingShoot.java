package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTargetingShoot extends Command {

    public AutoTargetingShoot() {
       requires(Robot.elChupaArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
 	
    	
    Robot.elChupaArms.shootBoulder(RobotMap.EL_CHUPA_FIRING_SPEED);
    Timer.delay(0.75);
    // Insert El Chupas shooting mechanism here
    Timer.delay(1.0);
    Robot.elChupaArms.shootBoulder(0);
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
