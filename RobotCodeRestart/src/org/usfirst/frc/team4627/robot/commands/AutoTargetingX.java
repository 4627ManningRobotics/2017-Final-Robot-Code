package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;

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
    
   double xDiff = (Robot.centerX - 160);
   
   double mappedDiff = xDiff /160;
    
   Robot.driveTrain.setLeftMotors(mappedDiff);
   Robot.driveTrain.setRightMotors(mappedDiff);
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.centerX < 170 && Robot.centerX > 150) {
        	
        return true;
        	
        } else {
        	
        return false;
        	
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
