package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTargetingY extends Command {

    public AutoTargetingY() {
       requires(Robot.elChupaArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
   double yDiff = (Robot.centerY - 120);
   
   double mappedDiff = yDiff /120;
    
//   Robot.elChupaArms.liftArms(mappedDiff);
   
   
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.centerY < 130 && Robot.centerY > 110) {
        	
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
