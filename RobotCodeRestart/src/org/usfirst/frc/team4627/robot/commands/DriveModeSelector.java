package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class DriveModeSelector extends Command {

    public DriveModeSelector() {
       
    requires(Robot.driveTrain);
    			
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   if (Robot.driveModeStart == 1) {
	   
	   Scheduler.getInstance().add(new GTADrive());
	   
   }
   
   if (Robot.driveModeStart == 2) {
	   
	   Scheduler.getInstance().add(new ArcadeDrive());
	   
   }
   
   if (Robot.driveModeStart == 3) {
	   
	   Scheduler.getInstance().add(new TankDrive());
	   
   }
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
