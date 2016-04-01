package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class AutoPortcullis extends Command {

    public AutoPortcullis() {
    	requires(Robot.driveTrain);
    	requires(Robot.elChupaArms);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   
    	System.out.println("AutoPortacolis is executing");
    	
    	Robot.elChupaArms.motorPosition = 100;
    	Robot.elChupaArms.setMotor();
    	
    	Robot.driveTrain.setLeftMotors(0.5);
    	Robot.driveTrain.setRightMotors(-0.5);
    	Timer.delay(1);
    	
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    	
    	Robot.elChupaArms.motorPosition = RobotMap.EL_CHUPAS_MAX_POSITION;
    	Robot.elChupaArms.setMotor();
    	
    	Robot.driveTrain.setLeftMotors(0.9);
    	Robot.driveTrain.setRightMotors(-0.9);
    	Timer.delay(0.5);
    	
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    
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
    	
    	if(Robot.autonomousPlacementStart != null) {
    		Robot.autonomousPlacementStart.start();
    	}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
