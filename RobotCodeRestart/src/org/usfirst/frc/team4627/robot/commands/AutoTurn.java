package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;



public class AutoTurn extends Command {
  
	double desiredAngle;
	double relativeAngle;
	
	public AutoTurn(double angle) {
        // requires driveTrain
    	requires(Robot.driveTrain);
    	desiredAngle = angle;
    	
    	
    }
   
    
    // Called just before this Command runs the first time
    protected void initialize() {
    
    Robot.sensors.preAngle = Robot.sensors.getGyroAngle();
    relativeAngle = (desiredAngle + Robot.sensors.preAngle);
        
   	System.out.println("AutoTurn is working");
   		 
    	// Sets the direction of the robot
   		
   		if(relativeAngle > Robot.sensors.preAngle){
    	 Robot.driveTrain.setLeftMotors(0.75);
         Robot.driveTrain.setRightMotors(0.75);
         
      
   		}
   		if(relativeAngle < Robot.sensors.preAngle){
       	 Robot.driveTrain.setLeftMotors(-0.75);
            Robot.driveTrain.setRightMotors(-0.75);
            
         
      		}
   		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (relativeAngle <= Robot.sensors.getGyroAngle() + 3 && relativeAngle >= Robot.sensors.getGyroAngle() - 3) {
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
