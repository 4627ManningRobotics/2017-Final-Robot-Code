package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class AutoTargetingY extends Command {

    public AutoTargetingY() {
    	
       requires(Robot.elChupaArms);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.centerY > 185) {
    		
    		Robot.elChupaArms.motorPosition-= 3;
    		Robot.elChupaArms.setMotor();
    		
    	}
    	
    	if (Robot.centerY < 175) {
    		
    		Robot.elChupaArms.motorPosition+= 3;
    		Robot.elChupaArms.setMotor();
    		
    	}
    	
  }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.centerY < 185 && Robot.centerY > 175) {
        	
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
