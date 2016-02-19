package org.usfirst.frc.team4627.robot.commands;
import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
public class AutoPlacement1 extends Command {
    public AutoPlacement1() {
        // requires driveTrain
    	requires(Robot.driveTrain);
    }
   
    
    // Called just before this Command runs the first time
    protected void initialize() {
        
   	System.out.println("Placement 1 is working");
   	
    	// Sets the direction of the robot
    	 Robot.driveTrain.setLeftMotors(0.8);
         Robot.driveTrain.setRightMotors(0.8);
         Timer.delay(0.5);
         Robot.driveTrain.setLeftMotors(0.5);
         Robot.driveTrain.setRightMotors(-0.5);
         Timer.delay(1);
         Robot.driveTrain.setLeftMotors(0);
         Robot.driveTrain.setLeftMotors(0);
         

    
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
