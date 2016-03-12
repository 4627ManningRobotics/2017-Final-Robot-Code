package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTargetingX extends Command {

    public AutoTargetingX() {
    	
       requires(Robot.driveTrain);
       requires(Robot.sensors);
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
   //double xDiff = (Robot.centerX - 160);
   
   //double mappedDiff = xDiff /160;
   if (Robot.centerX < 158) { 
   Robot.driveTrain.setLeftMotors(-RobotMap.AUTO_TARGET_SPIN_SPEED);
   Robot.driveTrain.setRightMotors(-RobotMap.AUTO_TARGET_SPIN_SPEED);
   }
   
   if (Robot.centerX > 178) {
	   
	Robot.driveTrain.setLeftMotors(RobotMap.AUTO_TARGET_SPIN_SPEED);
	Robot.driveTrain.setRightMotors(RobotMap.AUTO_TARGET_SPIN_SPEED);
	   
   }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.centerX < 178 && Robot.centerX > 158) {
        	
        return true;
        	
        } else {
        	
        return false;
        	
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
