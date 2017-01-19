package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GTADrive extends Command {

    public GTADrive() {
       
    requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
   //Creating axis values 	
   double rightTrigger = Robot.oi.driverAxisValue(RobotMap.RIGHT_TRIGGER);
   double leftTrigger = Robot.oi.driverAxisValue(RobotMap.LEFT_TRIGGER);
   double leftJoystickXAxis = Robot.oi.driverAxisValue(RobotMap.LEFT_JOYSTICK_X_AXIS);
   
   //Creating motor variables
   double leftMotors = (rightTrigger - leftTrigger + leftJoystickXAxis)*RobotMap.GTA_ROBOT_CONTROLS_SCALING;
   double rightMotors = (rightTrigger - leftTrigger - leftJoystickXAxis)*RobotMap.GTA_ROBOT_CONTROLS_SCALING*(-1);
   
   //Setting maximum and minimum speeds to the motors
   if (leftMotors > RobotMap.GTA_MAX_ROBOT_SPEED) {
	   
	   leftMotors = RobotMap.GTA_MAX_ROBOT_SPEED;
	   
   }
   if (rightMotors > RobotMap.GTA_MAX_ROBOT_SPEED) {
	   
	   rightMotors = RobotMap.GTA_MAX_ROBOT_SPEED;
	   
   }
   if (leftMotors < RobotMap.GTA_MIN_ROBOT_SPEED) {
	   
	   leftMotors = RobotMap.GTA_MIN_ROBOT_SPEED;
	   
   }
   if (rightMotors < RobotMap.GTA_MIN_ROBOT_SPEED) {
	   
	   rightMotors = RobotMap.GTA_MIN_ROBOT_SPEED;
	   
   }
   
   //Setting motor values to variables
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
