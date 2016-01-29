package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
    	
        requires(Robot.driveTrain);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    	// Setting Axis values
  	double yAxis = Robot.oi.driverAxisValue(RobotMap.LEFT_JOYSTICK_Y_AXIS)*(-1);
    double xAxis = Robot.oi.driverAxisValue(RobotMap.LEFT_JOYSTICK_X_AXIS);
    
    	//Setting Motor values
    double rightMotors = (yAxis - xAxis)*RobotMap.ARCADE_DRIVE_CONTROL_SCALING*(-1);
    double leftMotors = (yAxis + xAxis)*RobotMap.ARCADE_DRIVE_CONTROL_SCALING;
    
    //Setting maximum and minimum speeds to the motors
    if (leftMotors > RobotMap.ARCADE_DRIVE_MAX_SPEED) {
 	   
 	   leftMotors = RobotMap.ARCADE_DRIVE_MAX_SPEED;
 	   
    }
    if (rightMotors > RobotMap.ARCADE_DRIVE_MAX_SPEED) {
 	   
 	   rightMotors = RobotMap.ARCADE_DRIVE_MAX_SPEED;
 	   
    }
    if (leftMotors < RobotMap.ARCADE_DRIVE_MIN_SPEED) {
 	   
 	   leftMotors = RobotMap.ARCADE_DRIVE_MIN_SPEED;
 	   
    }
    if (rightMotors < RobotMap.ARCADE_DRIVE_MIN_SPEED) {
 	   
 	   rightMotors = RobotMap.ARCADE_DRIVE_MIN_SPEED;
 	   
    }
    
    // Setting variable values to the motors
    Robot.driveTrain.setLeftMotors(leftMotors);
    Robot.driveTrain.setRightMotors(rightMotors);
    
    	
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
