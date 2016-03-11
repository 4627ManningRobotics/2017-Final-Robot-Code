package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;



public class AutoTurn extends Command {
  
	double startAng;
	double desiredAng;
	double relativeAngle;
	
	
	public AutoTurn(double angle) {
        // requires driveTrain
    	requires(Robot.driveTrain);
    	relativeAngle = angle;
    	
    	
    }
   
    
    // Called just before this Command runs the first time
    protected void initialize() {
    
    startAng = Robot.sensors.getGyroAngle();
    desiredAng = (relativeAngle + startAng);
        
   	System.out.println("AutoTurn is working");
   		 
    	// Sets the direction of the robot
   		
   		if(desiredAng > startAng){
    	 Robot.driveTrain.setLeftMotors(0.75);
         Robot.driveTrain.setRightMotors(0.75);
         
      
   		}
   		if(desiredAng < startAng){
       	 Robot.driveTrain.setLeftMotors(-0.75);
            Robot.driveTrain.setRightMotors(-0.75);
            
         
      		}
   		
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (desiredAng <= Robot.sensors.getGyroAngle() + 3 && desiredAng >= Robot.sensors.getGyroAngle() - 3) {
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
